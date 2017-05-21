package com.neoalvin.ism.dao;

import com.neoalvin.ism.model.InterfaceWatchInfo;
import org.springframework.stereotype.Repository;

/**
 * Created by alvin on 2017/4/26.
 */
@Repository
public interface InterfaceWatchInfoDao {
  public InterfaceWatchInfo selectInterfaceWatchInfo();
  public void addInterfaceCallCount();
  public void addInterfaceCount();
}
