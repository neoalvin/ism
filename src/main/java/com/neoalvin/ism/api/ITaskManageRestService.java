package com.neoalvin.ism.api;

import com.neoalvin.ism.model.task.SubmitTaskInput;
import com.neoalvin.ism.model.task.TaskResultInfo;

/**
 * Created by alvin on 2017/4/26.
 */
public interface ITaskManageRestService {
  TaskResultInfo submitTask(SubmitTaskInput input);
  TaskResultInfo queryTaskStatus(String taskId);
}
