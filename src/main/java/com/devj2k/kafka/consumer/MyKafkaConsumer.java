package com.devj2k.kafka.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class MyKafkaConsumer {

    @KafkaListener(topics = "mon-topic", containerFactory = "kafkaListenerContainerFactory")
    public void consume(String message) {
        System.out.println("Message received: " + message);
    }
}
