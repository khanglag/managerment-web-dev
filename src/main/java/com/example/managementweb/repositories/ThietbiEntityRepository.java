package com.example.managementweb.repositories;

import com.example.managementweb.models.entities.ThanhvienEntity;
import com.example.managementweb.models.entities.ThietbiEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public interface ThietbiEntityRepository extends JpaRepository<ThietbiEntity, Integer> {

    List<ThietbiEntity> findAll();

    @Query("SELECT d " +
            "FROM ThietbiEntity d " +
            "WHERE d.tenTB LIKE CONCAT('%', :TenTB, '%') ")
    List<ThietbiEntity> findByTenTB(String TenTB);

    @Query("SELECT d " +
            "FROM ThietbiEntity d " +
            "WHERE d.id = :id")
    Optional<ThietbiEntity> findByID(String id);
}