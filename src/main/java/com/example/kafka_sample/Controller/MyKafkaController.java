package com.example.kafka_sample.Controller;

import com.example.kafka_sample.Service.MyKafkaProducer;
import com.example.kafka_sample.VO.MyKafkaMsgVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/kafka")
public class MyKafkaController {
    private final MyKafkaProducer producer;

    @Autowired
    MyKafkaController(MyKafkaProducer producer) {
        this.producer = producer;
    }

    @PostMapping
    public String sendMessageJson(@RequestBody MyKafkaMsgVO message) {
        this.producer.sendMessage(message);
        return "success";
    }
}