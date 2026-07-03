package com.diegoduarte.naruto_api.business.dtos.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NinjaJutsuResponseDTO {

    private Long id;
    private String ninja;
    private String jutsu;
}
