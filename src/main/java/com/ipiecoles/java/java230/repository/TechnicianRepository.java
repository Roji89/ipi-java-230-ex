package com.ipiecoles.java.java230.repository;

import com.ipiecoles.java.java230.model.Technicien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TechnicianRepository extends JpaRepository<Technicien,Long> {

    @Query("select t from Technicien t where t.manager.nom = ?1")
    List<Technicien> findByManagerNom(String nom);
}
