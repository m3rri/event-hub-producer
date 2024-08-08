package com.example.eventhubproducer.poc.consumer;

import com.example.eventhubproducer.poc.dto.CdcProductRequestDto;
import com.example.eventhubproducer.poc.entity.MgrProduct;
import com.example.eventhubproducer.poc.repository.mysql.MgrProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductConsumer {
    private final MgrProductRepository mgrProductRepository;

    @KafkaListener(topics = "save-product", groupId = "consumers-0")
    public void consume(CdcProductRequestDto dto){
        MgrProduct mgrProduct = MgrProduct.builder()
                        .id(dto.getId())
                        .name(dto.getName())
                        .build();

        mgrProductRepository.save(mgrProduct);
        log.info("consumer::save-product::"+dto);
    }
}
