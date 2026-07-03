package com.diegoduarte.naruto_api.infrastructure.repositories;

import com.diegoduarte.naruto_api.infrastructure.entities.ClaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClaRepository extends JpaRepository<ClaEntity, Long> {
}
