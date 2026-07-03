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
@Table(name = "ninja_jutsu")
public class NinjaJutsuEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ninja_id")
    private NinjaEntity ninja;

    @ManyToOne
    @JoinColumn(name = "jutsu_id")
    private JutsuEntity jutsu;

}
