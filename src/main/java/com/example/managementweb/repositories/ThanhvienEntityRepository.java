package com.example.managementweb.repositories;

import com.example.managementweb.models.entities.ThanhvienEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.Optional;

public interface ThanhvienEntityRepository extends JpaRepository<ThanhvienEntity, Integer> {

    @Query("SELECT d " +
            "FROM ThanhvienEntity d " +
            "WHERE d.id = :id")
    Optional<ThanhvienEntity> findByID(String id);
}