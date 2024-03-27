package com.example.kafka_sample.Temp;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;
import java.util.Scanner;

public class MyProducer {

    public static void main(String[] args) {
        /* Producer 설정세팅 */
        Properties properties = new Properties();

        String serverConfig = "169.254.100.100:9092";//"192.168.56.128:9092";
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, serverConfig);
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        //properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class.getName());
        Producer<String, String> producer = new KafkaProducer<String, String>(properties);

        while(true) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Input message >");
            String message = sc.nextLine();

            ProducerRecord<String, String> record = new ProducerRecord<>("test1", message);
            try {
                producer.send(record, (metadata, exception) -> {
                    if(exception != null) {
                        exception.printStackTrace();
                    }
                });
            } catch (Exception e) {
                // exception
            } finally {
                producer.flush();
            }

            if(message.equals("quit")) {
                producer.close();
                break;
            }
        }
    }
}
