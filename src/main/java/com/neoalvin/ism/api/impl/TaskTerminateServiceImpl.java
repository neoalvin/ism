package com.neoalvin.ism.api.impl;

import com.neoalvin.ism.api.ITaskTerminateService;
import com.neoalvin.ism.model.task.TerminateTaskInput;
import com.neoalvin.ism.model.task.TerminateTaskOutput;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 任务终止接口实现类
 * Created by alvin on 2017/4/24.
 */
public class TaskTerminateServiceImpl implements ITaskTerminateService{
  /**
   * 定义日志对象
   */
  private static final Logger LOGGER = LoggerFactory.getLogger(TaskTerminateServiceImpl.class);

  /**
   * 终止任务
   * @param input
   * @return
   */
  public TerminateTaskOutput terminateTask(TerminateTaskInput input) {
    LOGGER.info("[]: Start to terminate task.");
    LOGGER.info("[]: Terminate task successfully.");
    return null;
  }
}
