package com.example.ktv.repositories;

import com.example.ktv.entities.RoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<RoomEntity,Long> {
}
