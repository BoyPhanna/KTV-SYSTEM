package com.example.ktv.repositories;

import com.example.ktv.entities.CheckOutEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CheckOutRepository extends JpaRepository<CheckOutEntity,Long> {
}
