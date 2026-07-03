package com.diegoduarte.naruto_api.infrastructure.entities;

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
@Table(name = "cla")
public class ClaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "kekkei_genkai")
    private String kekkeiGenkai;

    @ManyToOne
    @JoinColumn(name = "aldeia_id")
    private AldeiaEntity aldeia;
}
