package com.neoalvin.ism.api.impl;

import com.alibaba.dubbo.rpc.protocol.rest.support.ContentType;
import com.neoalvin.ism.api.IZookeeperRestService;
import com.neoalvin.ism.api.IZookeeperService;
import com.neoalvin.ism.model.zk.GetZkNodeInfoInput;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 *
 * Created by alvin on 2017/4/25.
 */
@Path("zkInfo")
public class ZookeeperRestServiceImpl implements IZookeeperRestService {

  private IZookeeperService zookeeperService;

  public void setZookeeperService(IZookeeperService zookeeperService){
    this.zookeeperService = zookeeperService;
  }
  /**
   * 获取子节点列表
   * @return
   */
  @GET
  @Path("dubboServices")
  @Consumes({MediaType.APPLICATION_JSON, MediaType.TEXT_XML})
  @Produces({ContentType.APPLICATION_JSON_UTF_8, ContentType.TEXT_XML_UTF_8})
  public List<String> getDubboServices(){
    IZookeeperService zookeeperService = new ZookeeperServiceImpl();
    return zookeeperService.getDubboServices();
  }

  @POST
  @Path("nodesInfo")
  @Consumes({MediaType.APPLICATION_JSON, MediaType.TEXT_XML})
  @Produces({ContentType.APPLICATION_JSON_UTF_8, ContentType.TEXT_XML_UTF_8})
  public List<String> getNodesInfo(GetZkNodeInfoInput input) {
    IZookeeperService zookeeperService = new ZookeeperServiceImpl();
    return zookeeperService.getNodesInfo(input);
  }
}
