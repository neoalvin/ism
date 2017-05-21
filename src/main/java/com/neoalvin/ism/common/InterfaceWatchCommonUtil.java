package com.neoalvin.ism.common;

import com.neoalvin.ism.dao.InterfaceWatchInfoDao;
import com.neoalvin.ism.dao.impl.InterfaceWatchInfoDaoImpl;

/**
 * Created by alvin on 2017/4/26.
 */
public abstract class InterfaceWatchCommonUtil {

  public static void addInterfaceCallCount(){
    InterfaceWatchInfoDao interfaceWatchInfoDao = new InterfaceWatchInfoDaoImpl();
    interfaceWatchInfoDao.addInterfaceCallCount();
  }
}
