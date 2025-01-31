package com.uisrael.legalPro.repository;

import com.uisrael.legalPro.models.Seguimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISeguimientoRepository extends JpaRepository<Seguimiento, Integer> {
    List<Seguimiento> findAllByOrderByFechaLimiteAsc();
}
