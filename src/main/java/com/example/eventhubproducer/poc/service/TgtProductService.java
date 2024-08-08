package com.example.eventhubproducer.poc.service;

import com.example.eventhubproducer.poc.dto.CdcProductRequestDto;
import com.example.eventhubproducer.poc.entity.TgtProduct;
import com.example.eventhubproducer.poc.repository.mysql.TgtProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TgtProductService {
    private final TgtProductRepository tgtProductRepository;

    @Transactional
    public CdcProductRequestDto save(String name){
        TgtProduct tgtProduct = new TgtProduct();
        tgtProduct.setName(name);

        TgtProduct saved = tgtProductRepository.save(tgtProduct);

        return CdcProductRequestDto.from(saved);
    }
}
