package com.diegoduarte.naruto_api.business.dtos.response;

import com.diegoduarte.naruto_api.infrastructure.enums.RankJutsuEnum;
import com.diegoduarte.naruto_api.infrastructure.enums.TipoJutsuEnum;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class JutsuResponseDTO {

    private Long id;
    private String nome;
    private TipoJutsuEnum tipo;
    private RankJutsuEnum rank;
}
