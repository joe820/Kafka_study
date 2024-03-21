package com.example.kafka_sample;

import org.apache.kafka.clients.consumer.*;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

public class MyConsumer {
    public static void main(String[] args) {
        Properties properties = new Properties();

        String serverConfig = "192.168.56.128:9092";
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, serverConfig);
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.put(ConsumerConfig.GROUP_ID_CONFIG, "test1");

        Consumer<String, String> consumer = new KafkaConsumer<>(properties);
        consumer.subscribe(Collections.singletonList("test1"));

        String message = null;

        try {
            do {
                ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(100000));

                for (ConsumerRecord<String, String> record : records) {
                    message = record.value();
                    System.out.println(message);
                }
            } while (!message.equals("quit"));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            consumer.close();
        }
    }
}
