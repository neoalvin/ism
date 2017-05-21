package com.neoalvin.ism.service.impl;

import com.neoalvin.ism.dao.InterfaceWatchInfoDao;
import com.neoalvin.ism.model.InterfaceWatchInfo;
import com.neoalvin.ism.service.InterfaceWatchInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by alvin on 2017/4/26.
 */
@Service
public class InterfaceWatchInfoServiceImpl implements InterfaceWatchInfoService{

  @Resource
  InterfaceWatchInfoDao interfaceWatchInfoDao;

  public InterfaceWatchInfo selectInterfaceWatchInfo() {
    return interfaceWatchInfoDao.selectInterfaceWatchInfo();
  }

  public void addInterfaceCallCount() {
    interfaceWatchInfoDao.addInterfaceCallCount();
  }

  public void addInterfaceCount() {
    interfaceWatchInfoDao.addInterfaceCount();
  }
}
