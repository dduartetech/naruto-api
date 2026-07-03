package com.diegoduarte.naruto_api.business.dtos.request;

import com.diegoduarte.naruto_api.infrastructure.enums.RankJutsuEnum;
import com.diegoduarte.naruto_api.infrastructure.enums.TipoJutsuEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class JutsuRequestDTO {

    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    @NotNull(message = "Tipo é obrigatório")
    private TipoJutsuEnum tipo;

    @NotNull(message = "Rank é obrigatório")
    private RankJutsuEnum rank;
}
