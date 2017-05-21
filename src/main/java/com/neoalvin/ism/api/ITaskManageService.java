package com.neoalvin.ism.api;


import com.neoalvin.ism.model.task.SubmitTaskInput;
import com.neoalvin.ism.model.task.TaskResultInfo;

/**
 * 作业管理服务接口
 * Created by alvin on 2017/4/23.
 */
public interface ITaskManageService {
  /**
   * 提交作业
   * @param input
   * @return
   */
  TaskResultInfo submitTask(SubmitTaskInput input);
  TaskResultInfo queryTaskStatus(String taskId);
}
