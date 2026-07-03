package com.diegoduarte.naruto_api.business.converter;

import com.diegoduarte.naruto_api.business.dtos.request.JutsuRequestDTO;
import com.diegoduarte.naruto_api.business.dtos.response.JutsuResponseDTO;
import com.diegoduarte.naruto_api.infrastructure.entities.JutsuEntity;
import org.springframework.stereotype.Component;

@Component
public class JutsuConverter {

    public JutsuEntity toEntity (JutsuRequestDTO dto) {

        JutsuEntity entity = new JutsuEntity();

        entity.setNome(dto.getNome());
        entity.setRank(dto.getRank());
        entity.setTipo(dto.getTipo());

        return entity;
    }

    public JutsuResponseDTO toDTO (JutsuEntity entity) {

        return JutsuResponseDTO.builder()
                .id(entity.getId())
                .nome(entity.getNome())
                .rank(entity.getRank())
                .tipo(entity.getTipo())
                .build();
    }
}
