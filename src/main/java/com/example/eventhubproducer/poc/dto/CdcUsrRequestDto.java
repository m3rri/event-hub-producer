package com.example.eventhubproducer.poc.dto;

import com.example.eventhubproducer.poc.entity.TgtUsr;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CdcUsrRequestDto {
    private Long id;
    private String name;

    public static CdcUsrRequestDto from(TgtUsr tgtUsr){
        CdcUsrRequestDto requestDto = new CdcUsrRequestDto();
        requestDto.setId(tgtUsr.getId());
        requestDto.setName(tgtUsr.getName());

        return requestDto;
    }

    public String toString(){
        return "{'id': "+this.id+", 'name': '"+this.name+"'}";
    }
}
