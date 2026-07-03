package com.diegoduarte.naruto_api.business.converter;

import com.diegoduarte.naruto_api.business.dtos.request.AldeiaRequestDTO;
import com.diegoduarte.naruto_api.business.dtos.response.AldeiaResponseDTO;
import com.diegoduarte.naruto_api.infrastructure.entities.AldeiaEntity;
import com.diegoduarte.naruto_api.infrastructure.entities.ClaEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AldeiaConverter {

    public AldeiaEntity toEntity (AldeiaRequestDTO dto) {

        AldeiaEntity entity = new AldeiaEntity();

        entity.setNome(dto.getNome());
        entity.setPais(dto.getPais());

        return entity;
    }

    public AldeiaResponseDTO toDTO (AldeiaEntity entity) {

        List<String> clas = entity.getClas() != null ?
                entity.getClas().stream()
                        .map(ClaEntity::getNome)
                        .toList()
                : List.of();

        return AldeiaResponseDTO.builder()
                .id(entity.getId())
                .nome(entity.getNome())
                .pais(entity.getPais())
                .clas(clas)
                .build();
    }
}
