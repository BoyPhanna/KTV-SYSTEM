package com.example.ktv.repositories;

import com.example.ktv.entities.ImportEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImportRepository extends JpaRepository<ImportEntity,Long> {
}
