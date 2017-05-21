package com.neoalvin.ism.api;

import com.neoalvin.ism.model.RetCode;
import com.neoalvin.ism.model.UserInfo;

/**
 * 用户认证REST接口
 * Created by alvin on 2017/4/24.
 */
public interface IUserAuthRestService {
  /**
   * 注册用户
   * @param userInfo
   * @return
   */
  RetCode registryUser(UserInfo userInfo);

  /**
   * 验证用户
   * @param userInfo
   * @return
   */
  RetCode validateUser(UserInfo userInfo);
}
