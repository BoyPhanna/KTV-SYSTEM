package com.example.ktv.repositories;

import com.example.ktv.entities.InvoiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository  extends JpaRepository<InvoiceEntity,Long> {
}
