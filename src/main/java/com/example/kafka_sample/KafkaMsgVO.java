package com.example.kafka_sample;

public class KafkaMsgVO {
    private String name;
    private String msg;

    public void setName(String name) {
        this.name = name;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getName() {
        return name;
    }

    public String getMsg() {
        return msg;
    }
}
