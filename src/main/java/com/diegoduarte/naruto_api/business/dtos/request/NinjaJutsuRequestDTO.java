package com.diegoduarte.naruto_api.business.dtos.request;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NinjaJutsuRequestDTO {

    @NotNull(message = "Ninja é obrigatório")
    private Long ninjaId;

    @NotNull(message = "Jutsu é obrigatório")
    private Long jutsuId;
}
