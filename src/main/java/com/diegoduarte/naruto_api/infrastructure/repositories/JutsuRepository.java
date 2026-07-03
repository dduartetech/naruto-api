package com.diegoduarte.naruto_api.infrastructure.repositories;

import com.diegoduarte.naruto_api.infrastructure.entities.JutsuEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JutsuRepository extends JpaRepository<JutsuEntity, Long> {
}
