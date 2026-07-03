package com.diegoduarte.naruto_api.business.converter;

import com.diegoduarte.naruto_api.business.dtos.request.NinjaRequestDTO;
import com.diegoduarte.naruto_api.business.dtos.response.NinjaResponseDTO;
import com.diegoduarte.naruto_api.infrastructure.entities.AldeiaEntity;
import com.diegoduarte.naruto_api.infrastructure.entities.ClaEntity;
import com.diegoduarte.naruto_api.infrastructure.entities.NinjaEntity;
import org.springframework.stereotype.Component;

@Component
public class NinjaConverter {

    public NinjaEntity toEntity (NinjaRequestDTO dto, AldeiaEntity aldeia, ClaEntity cla) {

        NinjaEntity entity = new NinjaEntity();

        entity.setNome(dto.getNome());
        entity.setRank(dto.getRank());
        entity.setChakra(dto.getChakra());
        entity.setAtivo(dto.getAtivo());
        entity.setAldeia(aldeia);
        entity.setCla(cla);

        return entity;
    }

    public NinjaResponseDTO toDTO (NinjaEntity entity) {

        return NinjaResponseDTO.builder()
                .id(entity.getId())
                .nome(entity.getNome())
                .rank(entity.getRank())
                .chakra(entity.getChakra())
                .ativo(entity.isAtivo())
                .aldeia(entity.getAldeia().getNome())
                .cla(entity.getCla() != null ? entity.getCla().getNome() : null)
                .build();
    }
}
