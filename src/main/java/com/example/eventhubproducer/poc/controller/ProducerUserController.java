package com.example.eventhubproducer.poc.controller;

import com.example.eventhubproducer.poc.dto.CdcUsrRequestDto;
import com.example.eventhubproducer.poc.service.TgtUsrService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class ProducerUserController {
    private final TgtUsrService tgtUsrService;
    private final KafkaTemplate<String, CdcUsrRequestDto> kafkaTemplate;

    @PostMapping("user")
    public void sendName(@RequestParam("name") String name){
        CdcUsrRequestDto body = tgtUsrService.save(name);
        log.info("user save complete");
        kafkaTemplate.send("save-user", body);
        log.info("send complete::save-user");
    }
}
