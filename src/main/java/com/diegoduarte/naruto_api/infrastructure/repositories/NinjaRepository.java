package com.diegoduarte.naruto_api.infrastructure.repositories;

import com.diegoduarte.naruto_api.infrastructure.entities.NinjaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NinjaRepository extends JpaRepository<NinjaEntity, Long> {
}
