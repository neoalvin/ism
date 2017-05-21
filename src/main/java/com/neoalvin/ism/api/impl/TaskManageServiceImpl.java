package com.neoalvin.ism.api.impl;

import com.neoalvin.ism.api.IKafkaSendMessageService;
import com.neoalvin.ism.api.ITaskManageService;
import com.neoalvin.ism.api.IkafkaSubscribeMessageService;
import com.neoalvin.ism.common.CommonConstants;
import com.neoalvin.ism.common.JsonCommonUtil;
import com.neoalvin.ism.model.RetCode;
import com.neoalvin.ism.model.UserInfo;
import com.neoalvin.ism.model.kafka.KafkaMessageRecord;
import com.neoalvin.ism.model.kafka.SendKafkaMessageInput;
import com.neoalvin.ism.model.kafka.SubscribeKafkaMessageInput;
import com.neoalvin.ism.model.task.AuthData;
import com.neoalvin.ism.model.task.SubmitTaskInput;
import com.neoalvin.ism.model.task.TaskResultInfo;
import com.neoalvin.ism.validator.JobManageValidator;
import com.neoalvin.ism.validator.UserAuthValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

/**
 * 作业操作实现类
 * Created by alvin on 2017/4/23.
 */
public class TaskManageServiceImpl implements ITaskManageService {
  /**
   * 定义日志对象
   */
  private static final Logger LOGGER = LoggerFactory.getLogger(TaskManageServiceImpl.class);

  /**
   * 提交作业
   * @param input
   * @return
   */
  public TaskResultInfo submitTask(SubmitTaskInput input) {
    //定义返回对象
    TaskResultInfo output = new TaskResultInfo();

    //判断入参是否为null
    if(null == input){
      output.setResultCode(1);
      output.setTaskStatus("input is null");
      LOGGER.error("[IJobManageService]: Commit job failed, input is null.");
    }

    //入口日志，打印入参
    LOGGER.info("[IJobManageService]: Start to commit job. input = " + input.toString());

    try {
      //入参校验, 认证失败则直接返回
      RetCode retCode = JobManageValidator.validateCommitJobInput(input);
      if (CommonConstants.RETCODE_ERROR.equals(retCode.getCode())) {
        LOGGER.error("[IJobManageService]: Check commit job input failed, " + retCode.getMessage());
        output.setResultCode(1);
        output.setTaskStatus(retCode.getMessage());
        return output;
      }

      //用户验证
      UserInfo userInfo = convertAuthDataToUserInfo(input.getAuthData());
      retCode = UserAuthValidator.validateUserByIdAndPwd(userInfo);
      if (CommonConstants.RETCODE_ERROR.equals(retCode.getCode())) {
        LOGGER.error("[IJobManageService]: Validate user failed, " + retCode.getMessage());
        output.setResultCode(1);
        output.setTaskStatus(retCode.getMessage());
        return output;
      }

      //模拟任务执行成功
      output = buildTaskOutput(input,1,0,"success");

      //构造发布消息的入参
      SendKafkaMessageInput sendKafkaMessageInput = new SendKafkaMessageInput();
      sendKafkaMessageInput.setTopicNameList(Arrays.asList("alvin_ism_task_info_topic"));
      sendKafkaMessageInput.setMessage(JsonCommonUtil.convertObjectToJson(output));

      //发布任务状态到消息队列中
      IKafkaSendMessageService kafkaSendMessageService = new KafkaSendMessageServiceImpl();
      kafkaSendMessageService.sendKafkaMessage(sendKafkaMessageInput);
      kafkaSendMessageService.close();

    }catch(Exception e){
      LOGGER.error("[IJobManageService]: Validate user error, " + e.toString());
    }

    return output;
  }

  /**
   * 查询任务状态信息
   * @param taskId
   * @return
   */
  public TaskResultInfo queryTaskStatus(String taskId){
    //构造订阅消息的入参
    SubscribeKafkaMessageInput input = new SubscribeKafkaMessageInput();
    input.setGroup("alvin_group");
    input.setTopicName("alvin_ism_task_info_topic");

    //订阅消息
    IkafkaSubscribeMessageService subscribeMessageService = new kafkaSubscribeMessageServiceImpl();
    List<KafkaMessageRecord> kafkaMessageRecordList = subscribeMessageService.subscribeKafkaMessage(input);

    //TODO
    TaskResultInfo taskResultInfo = new TaskResultInfo();
    return taskResultInfo;
  }

  /**
   * 将AuthData转换为UserInfo
   * @param authData
   * @return
   */
  private UserInfo convertAuthDataToUserInfo(AuthData authData){
    return new UserInfo(authData.getBusinessId(), authData.getBusinessPwd());
  }

  private TaskResultInfo buildTaskOutput(SubmitTaskInput input, int count, int retCode, String status){
    String userId = input.getAuthData().getBusinessId();
    String imageName = input.getRequestData().getImageName();

    String taskId = userId + "_" + imageName + "_" + count;

    TaskResultInfo taskResultInfo = new TaskResultInfo();
    taskResultInfo.setResultCode(retCode);
    taskResultInfo.setTaskId(taskId);
    taskResultInfo.setImageName(imageName);
    taskResultInfo.setTaskStatus(status);
    return taskResultInfo;
  }
}
