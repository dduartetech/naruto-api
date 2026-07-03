package com.diegoduarte.naruto_api.infrastructure.entities;

import com.diegoduarte.naruto_api.infrastructure.enums.RankNinjaEnum;
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
@Table(name = "ninja")
public class NinjaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Enumerated(EnumType.STRING)
    @Column(name = "rank")
    private RankNinjaEnum rank;

    @Column(name = "chakra")
    private int chakra;

    @Column(name = "ativo")
    private boolean ativo;

    @ManyToOne
    @JoinColumn(name = "aldeia_id")
    private AldeiaEntity aldeia;

    @ManyToOne
    @JoinColumn(name = "cla_id", nullable = true)
    private ClaEntity cla;
}
