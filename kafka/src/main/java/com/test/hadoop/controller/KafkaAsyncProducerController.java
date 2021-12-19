package com.test.hadoop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaAsyncProducerController {
    @Autowired
    private KafkaTemplate template;

    @RequestMapping("send/sync/{message}")
    public String sendSync(@PathVariable String message) {

        return "";
    }
}
