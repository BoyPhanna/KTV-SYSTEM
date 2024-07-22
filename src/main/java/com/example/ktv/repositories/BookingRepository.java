package com.example.ktv.repositories;

import com.example.ktv.entities.BookingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<BookingEntity,Long> {
}
