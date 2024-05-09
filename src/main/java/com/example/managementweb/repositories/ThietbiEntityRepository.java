package com.example.managementweb.repositories;

import com.example.managementweb.models.entities.ThietbiEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.*;
@Repository
public interface ThietbiEntityRepository extends JpaRepository<ThietbiEntity, Integer> {
    List<ThietbiEntity> findByName(String TenTB);
}