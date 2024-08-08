package com.example.eventhubproducer.poc.dto;

import com.example.eventhubproducer.poc.entity.TgtProduct;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CdcProductRequestDto {
    private Long id;
    private String name;

    public static CdcProductRequestDto from(TgtProduct tgtProduct){
        CdcProductRequestDto requestDto = new CdcProductRequestDto();
        requestDto.setId(tgtProduct.getId());
        requestDto.setName(tgtProduct.getName());

        return requestDto;
    }

    public String toString(){
        return "{'id': "+this.id+", 'name': '"+this.name+"'}";
    }
}
