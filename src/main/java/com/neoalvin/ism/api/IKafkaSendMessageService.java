package com.neoalvin.ism.api;

import com.neoalvin.ism.model.kafka.SendKafkaMessageInput;

/**
 * kafka相关服务操作接口
 * Created by alvin on 2017/4/24.
 */
public interface IKafkaSendMessageService {
  void sendKafkaMessage(SendKafkaMessageInput input);
  void close();
}
