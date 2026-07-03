package com.diegoduarte.naruto_api.business.converter;

import com.diegoduarte.naruto_api.business.dtos.request.ClaRequestDTO;
import com.diegoduarte.naruto_api.business.dtos.response.ClaResponseDTO;
import com.diegoduarte.naruto_api.infrastructure.entities.AldeiaEntity;
import com.diegoduarte.naruto_api.infrastructure.entities.ClaEntity;
import org.springframework.stereotype.Component;

@Component
public class ClaConverter {

    public ClaEntity toEntity (ClaRequestDTO dto, AldeiaEntity aldeia) {

        ClaEntity entity = new ClaEntity();

        entity.setNome(dto.getNome());
        entity.setKekkeiGenkai(dto.getKekkeiGenkai());
        entity.setAldeia(aldeia);

        return entity;
    }

    public ClaResponseDTO toDTO (ClaEntity entity) {
        return ClaResponseDTO.builder()
                .id(entity.getId())
                .nome(entity.getNome())
                .kekkeiGenkai(entity.getKekkeiGenkai())
                .aldeia(entity.getAldeia().getNome())
                .build();
    }
}
