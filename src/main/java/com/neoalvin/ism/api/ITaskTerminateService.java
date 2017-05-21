package com.neoalvin.ism.api;

import com.neoalvin.ism.model.task.TerminateTaskInput;
import com.neoalvin.ism.model.task.TerminateTaskOutput;

/**
 * 任务终止服务接口
 * Created by alvin on 2017/4/24.
 */
public interface ITaskTerminateService {
  /**
   * 终止任务
   * @param input
   * @return
   */
  TerminateTaskOutput terminateTask(TerminateTaskInput input);
}
