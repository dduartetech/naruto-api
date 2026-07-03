package com.diegoduarte.naruto_api.business.dtos.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClaResponseDTO {

    private Long id;
    private String nome;
    private String kekkeiGenkai;
    private String aldeia;

}
