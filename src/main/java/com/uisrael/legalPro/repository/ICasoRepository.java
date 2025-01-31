package com.uisrael.legalPro.repository;

import com.uisrael.legalPro.models.Caso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICasoRepository extends JpaRepository<Caso, Integer> {
}
