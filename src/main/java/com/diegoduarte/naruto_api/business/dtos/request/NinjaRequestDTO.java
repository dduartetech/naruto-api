package com.diegoduarte.naruto_api.business.dtos.request;

import com.diegoduarte.naruto_api.infrastructure.enums.RankNinjaEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NinjaRequestDTO {

    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    @NotNull(message = "Rank é obrigatório")
    private RankNinjaEnum rank;

    @NotNull(message = "Chakra é obrigatório")
    private Integer chakra;

    @NotNull(message = "Status obrigatório")
    private Boolean ativo;

    @NotNull(message = "Aldeia é obrigatório")
    private Long aldeiaId;

    private Long claId;
}
