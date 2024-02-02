package com.irojas.demojwt.repository;

import com.irojas.demojwt.model.Habilidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface HabilidadRepository extends JpaRepository<Habilidad, Integer> {
}
