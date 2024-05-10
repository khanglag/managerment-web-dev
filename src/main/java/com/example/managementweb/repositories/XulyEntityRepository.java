package com.example.managementweb.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.managementweb.models.entities.XulyEntity;

import java.util.List;

public interface XulyEntityRepository extends JpaRepository<XulyEntity, Integer> {
    @Query("SELECT p FROM XulyEntity p WHERE p.maTV.id = :id AND p.trangthaiXL = 1")
    List<XulyEntity> findByPerson(String id);
}
