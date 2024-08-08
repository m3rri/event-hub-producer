package com.example.eventhubproducer.poc.consumer;

import com.example.eventhubproducer.poc.dto.CdcProductRequestDto;
import com.example.eventhubproducer.poc.dto.CdcUsrRequestDto;
import com.example.eventhubproducer.poc.entity.MgrProduct;
import com.example.eventhubproducer.poc.entity.MgrUsr;
import com.example.eventhubproducer.poc.repository.mysql.MgrProductRepository;
import com.example.eventhubproducer.poc.repository.mysql.MgrUsrRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class UsrConsumer {
    private final MgrUsrRepository mgrUsrRepository;

    @KafkaListener(topics = "save-user", groupId = "consumers-0")
    public void consume(CdcUsrRequestDto dto){
        MgrUsr mgrUsr = MgrUsr.builder()
                        .id(dto.getId())
                        .name(dto.getName())
                        .build();

        mgrUsrRepository.save(mgrUsr);
        log.info("consumer::save-user::"+dto);
    }
}
