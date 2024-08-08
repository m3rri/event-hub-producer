package com.example.eventhubproducer.poc.repository.mysql;

import com.example.eventhubproducer.poc.entity.MgrUsr;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MgrUsrRepository extends JpaRepository<MgrUsr, Long> {
}
