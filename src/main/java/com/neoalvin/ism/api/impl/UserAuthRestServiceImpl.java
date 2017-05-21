package com.neoalvin.ism.api.impl;

import com.alibaba.dubbo.rpc.protocol.rest.support.ContentType;
import com.neoalvin.ism.api.IUserAuthRestService;
import com.neoalvin.ism.api.IUserAuthService;
import com.neoalvin.ism.common.InterfaceWatchCommonUtil;
import com.neoalvin.ism.model.RetCode;
import com.neoalvin.ism.model.UserInfo;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * 用户认证相关操作REST实现类
 * Created by alvin on 2017/4/24.
 */
@Path("user")
public class UserAuthRestServiceImpl implements IUserAuthRestService{
  /**
   * 定义用户认证操作服务类实例
   */
  private IUserAuthService userAuthService;

  /**
   * 设置IUserAuthService实例
   * @param userAuthService
   */
  public void setUserAuthService(IUserAuthService userAuthService){
    this.userAuthService = userAuthService;
  }

  /**
   * 注册用户
   * @param userInfo
   * @return
   */
  @POST
  @Path("registryUser")
  @Consumes({MediaType.APPLICATION_JSON})
  @Produces({ContentType.APPLICATION_JSON_UTF_8, ContentType.TEXT_XML_UTF_8})
  public RetCode registryUser(UserInfo userInfo) {
    InterfaceWatchCommonUtil.addInterfaceCallCount();
    return userAuthService.registryUser(userInfo);
  }

  /**
   * 验证用户
   * @param userInfo
   * @return
   */
  @POST
  @Path("validateUser")
  @Consumes({MediaType.APPLICATION_JSON})
  @Produces({ContentType.APPLICATION_JSON_UTF_8, ContentType.TEXT_XML_UTF_8})
  public RetCode validateUser(UserInfo userInfo) {
    InterfaceWatchCommonUtil.addInterfaceCallCount();
    return userAuthService.validateUser(userInfo);
  }
}
