package com.neoalvin.ism.dao.impl;

import com.neoalvin.ism.dao.InterfaceWatchInfoDao;
import com.neoalvin.ism.dao.util.TmisDaoUtil;
import com.neoalvin.ism.model.InterfaceWatchInfo;
import org.apache.ibatis.session.SqlSession;

/**
 * Created by alvin on 2017/4/26.
 */
public class InterfaceWatchInfoDaoImpl implements InterfaceWatchInfoDao{

  /**
   * 获得会话对象
   */
  private SqlSession session = TmisDaoUtil.getSession();

  public InterfaceWatchInfo selectInterfaceWatchInfo() {
    try {
      InterfaceWatchInfoDao interfaceWatchInfoDao=session.getMapper(InterfaceWatchInfoDao.class);
      return interfaceWatchInfoDao.selectInterfaceWatchInfo();
    }
    finally{
      session.close();
    }
  }

  public void addInterfaceCount() {
    try {
      InterfaceWatchInfoDao interfaceWatchInfoDao=session.getMapper(InterfaceWatchInfoDao.class);
      interfaceWatchInfoDao.addInterfaceCount();
    }
    finally{
      session.close();
    }
  }

  public void addInterfaceCallCount() {
    try {
      InterfaceWatchInfoDao interfaceWatchInfoDao=session.getMapper(InterfaceWatchInfoDao.class);
      interfaceWatchInfoDao.addInterfaceCallCount();
    }
    finally{
      session.close();
    }
  }
}
