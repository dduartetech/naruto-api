package com.diegoduarte.naruto_api.infrastructure.repositories;

import com.diegoduarte.naruto_api.infrastructure.entities.NinjaJutsuEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NinjaJutsuRepository extends JpaRepository<NinjaJutsuEntity, Long> {
}
