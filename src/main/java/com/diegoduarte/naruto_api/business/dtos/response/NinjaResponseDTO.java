package com.diegoduarte.naruto_api.business.dtos.response;

import com.diegoduarte.naruto_api.infrastructure.enums.RankNinjaEnum;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NinjaResponseDTO {

    private Long id;
    private String nome;
    private RankNinjaEnum rank;
    private Integer chakra;
    private Boolean ativo;
    private String aldeia;
    private String cla;
}
