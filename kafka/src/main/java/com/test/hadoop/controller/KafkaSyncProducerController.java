package com.test.hadoop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaSyncProducerController {
    @Autowired
    private KafkaTemplate template;


}
