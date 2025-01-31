package com.uisrael.legalPro.repository;

import com.uisrael.legalPro.models.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITareaRepository extends JpaRepository<Tarea, Integer> {
}
