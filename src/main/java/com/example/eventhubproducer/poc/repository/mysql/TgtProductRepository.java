package com.example.eventhubproducer.poc.repository.mysql;

import com.example.eventhubproducer.poc.entity.TgtProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TgtProductRepository extends JpaRepository<TgtProduct, Long> {
}
