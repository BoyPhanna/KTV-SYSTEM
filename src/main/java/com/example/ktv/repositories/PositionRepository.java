package com.example.ktv.repositories;

import com.example.ktv.entities.PositionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PositionRepository extends JpaRepository<PositionEntity,Long> {
}
