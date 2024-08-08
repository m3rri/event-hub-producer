package com.example.eventhubproducer.poc.controller;

import com.example.eventhubproducer.poc.dto.CdcProductRequestDto;
import com.example.eventhubproducer.poc.service.TgtProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class ProducerProductController {
    private final TgtProductService tgtProductService;
    private final KafkaTemplate<String, CdcProductRequestDto> kafkaTemplate;

    @PostMapping("product")
    public void sendName(@RequestParam("name") String name){
        CdcProductRequestDto body = tgtProductService.save(name);
        log.info("product save complete");
        kafkaTemplate.send("save-product", body);
        log.info("send complete::save-product");
    }

}
