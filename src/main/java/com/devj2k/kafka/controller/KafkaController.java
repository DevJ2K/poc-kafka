package com.devj2k.kafka.controller;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaController {

    private final KafkaTemplate<String, String> kafkaTemplate;

    KafkaController(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;

    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }

    @PostMapping("/publish")
    public String publish(@RequestParam String message) {
        // Logic to publish the message to Kafka topic
        kafkaTemplate.send(new ProducerRecord<>("mon-topic", message));
        return "Message published: " + message;
    }
}
