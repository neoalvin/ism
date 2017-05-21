package com.neoalvin.ism.api;

import com.neoalvin.ism.model.RetCode;
import com.neoalvin.ism.model.UserInfo;

/**
 * 用户认证接口
 * Created by alvin on 2017/4/23.
 */
public interface IUserAuthService {
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
