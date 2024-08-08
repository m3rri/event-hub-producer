package com.example.eventhubproducer.poc.repository.mysql;

import com.example.eventhubproducer.poc.entity.MgrProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MgrProductRepository extends JpaRepository<MgrProduct, Long> {
}
