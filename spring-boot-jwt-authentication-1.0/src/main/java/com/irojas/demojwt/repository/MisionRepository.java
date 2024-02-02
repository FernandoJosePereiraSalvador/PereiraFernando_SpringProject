package com.irojas.demojwt.repository;

import com.irojas.demojwt.model.Mision;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface MisionRepository extends JpaRepository<Mision, Integer> {
}
