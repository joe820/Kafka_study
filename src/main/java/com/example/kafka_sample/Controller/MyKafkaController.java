package com.example.kafka_sample.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/kafka")
public class MyKafkaController {
//    private final My
    @RequestMapping(value = "/test")
    public String testMethod() {
        return "호출 성공";
    }


}
