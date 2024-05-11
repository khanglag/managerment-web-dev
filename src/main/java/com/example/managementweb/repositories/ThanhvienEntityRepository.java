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

    @Query("SELECT d " +
            "FROM ThanhvienEntity d " +
            "WHERE d.email = :email")
    Optional<ThanhvienEntity> findByEmail(String email);

    @Query("SELECT t FROM ThanhvienEntity t LEFT JOIN FETCH t.xulies WHERE t.id = :id")
    Optional<ThanhvienEntity> findByid(String id);

}