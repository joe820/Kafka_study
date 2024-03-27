package com.example.kafka_sample.Service;

import com.example.kafka_sample.VO.MyKafkaMsgVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class MyKafkaProducer {
    private static final String TOPIC = "test6";
    private final KafkaTemplate<String, MyKafkaMsgVO> kafkaTemplate;

    @Autowired
    public MyKafkaProducer(KafkaTemplate kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(MyKafkaMsgVO message) {
        System.out.println(String.format("Produce message(KafkaMsgVO) : %s", message));
        this.kafkaTemplate.send(TOPIC, message);
    }
}