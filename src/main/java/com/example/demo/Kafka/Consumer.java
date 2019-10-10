package com.example.demo.Kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * author:lizhaojie
 * 创建日期:2019/9/27-10:28
 */
@Component
public class Consumer {

    private static Logger logger = LoggerFactory.getLogger(Consumer.class);

    @KafkaListener(topics = "test")
    public void listen(ConsumerRecord<?,?> record){
        logger.info("主题:{} 内容：{}",record.topic(),record.value());
    }

}
