package com.example.ktv.repositories;

import com.example.ktv.entities.InvoiceDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceDetailRepository extends JpaRepository<InvoiceDetailEntity,Long> {
}
