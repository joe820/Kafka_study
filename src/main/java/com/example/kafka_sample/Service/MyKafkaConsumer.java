package com.example.kafka_sample.Service;

import com.example.kafka_sample.VO.MyKafkaMsgVO;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class MyKafkaConsumer {
    @KafkaListener(topics = "test6", groupId = "foo2")
    public void consume(MyKafkaMsgVO vo) {
        System.out.println("name = " + vo.getName());
        System.out.println("consume message = " + vo.getMsg());
    }
}