package com.devj2k.kafka.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }
}
