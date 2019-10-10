package com.example.demo.Kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

/**
 * author:lizhaojie
 * 创建日期:2019/9/27-10:27
 */
@Component
public class Producer {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    public void sendMessage(String message) {
        kafkaTemplate.send("test", message);
    }

    public void sendMessageSecond(String message) {
        kafkaTemplate.send("test2", message);
    }


}
