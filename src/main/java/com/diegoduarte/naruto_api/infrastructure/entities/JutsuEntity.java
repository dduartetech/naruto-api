package com.diegoduarte.naruto_api.infrastructure.entities;

import com.diegoduarte.naruto_api.infrastructure.enums.RankJutsuEnum;
import com.diegoduarte.naruto_api.infrastructure.enums.TipoJutsuEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "jutsu")
public class JutsuEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo")
    private TipoJutsuEnum tipo;

    @Enumerated(EnumType.STRING)
    @Column(name = "rank")
    private RankJutsuEnum rank;

}
