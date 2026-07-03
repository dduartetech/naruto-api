package com.diegoduarte.naruto_api.business.converter;

import com.diegoduarte.naruto_api.business.dtos.request.NinjaJutsuRequestDTO;
import com.diegoduarte.naruto_api.business.dtos.response.NinjaJutsuResponseDTO;
import com.diegoduarte.naruto_api.infrastructure.entities.JutsuEntity;
import com.diegoduarte.naruto_api.infrastructure.entities.NinjaEntity;
import com.diegoduarte.naruto_api.infrastructure.entities.NinjaJutsuEntity;
import org.springframework.stereotype.Component;

@Component
public class NinjaJutsuConverter {

    public NinjaJutsuEntity toEntity (NinjaJutsuRequestDTO dto, NinjaEntity ninja, JutsuEntity jutsu) {

        NinjaJutsuEntity entity = new NinjaJutsuEntity();

        entity.setNinja(ninja);
        entity.setJutsu(jutsu);

        return entity;
    }

    public NinjaJutsuResponseDTO toDTO (NinjaJutsuEntity entity) {

        return NinjaJutsuResponseDTO.builder()
                .id(entity.getId())
                .ninja(entity.getNinja().getNome())
                .jutsu(entity.getJutsu().getNome())
                .build();
    }
}
