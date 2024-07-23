package com.example.ktv.repositories;

import com.example.ktv.entities.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<CustomerEntity,Long> {
    Optional<CustomerEntity> findByEmail(String email);

//    Optional<CustomerEntity> findByToken(String token);

    boolean existsByEmail(String email);
}
