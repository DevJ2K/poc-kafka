package com.devj2k.kafka.controller;

import com.devj2k.kafka.producer.CustomKafkaProducer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaController {

//    private final KafkaTemplate<String, String> kafkaTemplate;

//    @Value(value = "${spring.kafka.publish-topic}")
    private final String topic;

    private final CustomKafkaProducer customKafkaProducer;


    KafkaController(
            @Value(value = "${spring.kafka.bootstrap-servers}") String bootstrapAddress,
            @Value(value = "${spring.kafka.publish-topic}") String topic
    ) {
         this.customKafkaProducer = new CustomKafkaProducer(bootstrapAddress);
         this.topic = topic;
//        this.kafkaTemplate = kafkaTemplate;
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }

    @PostMapping("/publish")
    public String publish(@RequestParam String message) {
//        kafkaTemplate.send(new ProducerRecord<>("mon-topic", message));
        customKafkaProducer.sendMessage(topic, message);
        return "Message published: " + message;
    }
}
