package com.example.eventhubproducer.poc.service;

import com.example.eventhubproducer.poc.dto.CdcUsrRequestDto;
import com.example.eventhubproducer.poc.entity.TgtUsr;
import com.example.eventhubproducer.poc.repository.mysql.TgtUsrRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TgtUsrService {
    private final TgtUsrRepository tgtUsrRepository;

    @Transactional
    public CdcUsrRequestDto save(String name){
        TgtUsr tgtUsr = new TgtUsr();
        tgtUsr.setName(name);

        TgtUsr saved = tgtUsrRepository.save(tgtUsr);

        return CdcUsrRequestDto.from(saved);
    }
}
