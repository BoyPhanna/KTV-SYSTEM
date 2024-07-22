package com.example.ktv.repositories;

import com.example.ktv.entities.CheckInEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CheckInRepository extends JpaRepository<CheckInEntity,Long> {
}
