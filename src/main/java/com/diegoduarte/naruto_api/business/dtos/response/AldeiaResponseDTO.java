package com.diegoduarte.naruto_api.business.dtos.response;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AldeiaResponseDTO {

    private Long id;
    private String nome;
    private String pais;
    private List<String> clas;

}
