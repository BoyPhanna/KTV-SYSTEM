package com.example.ktv.repositories;

import com.example.ktv.entities.StaffEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StaffRepository extends JpaRepository<StaffEntity,Long> {
}
