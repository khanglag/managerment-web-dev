package com.example.managementweb.repositories;

import com.example.managementweb.models.entities.ThanhvienEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ThanhvienEntityRepository extends JpaRepository<ThanhvienEntity, Integer> {
}