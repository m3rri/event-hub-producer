package com.example.eventhubproducer.poc.repository.mysql;

import com.example.eventhubproducer.poc.entity.TgtUsr;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TgtUsrRepository extends JpaRepository<TgtUsr, Long> {
}
