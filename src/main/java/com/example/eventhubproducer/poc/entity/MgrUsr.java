package com.example.eventhubproducer.poc.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "mgr_usr")
@Entity
@Getter @Setter
@NoArgsConstructor
public class MgrUsr {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @Builder
    public MgrUsr(Long id, String name){
        this.id = id;
        this.name = name;
    }
}
