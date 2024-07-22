package com.example.ktv.repositories;

import com.example.ktv.entities.SupplierEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<SupplierEntity,Long> {
}
