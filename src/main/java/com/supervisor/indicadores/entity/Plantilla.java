package com.supervisor.indicadores.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "plantilla")
public class Plantilla {

    @Id
    @GeneratedValue (strategy = GenerationType.UUID)
    private String id;

    private String noPartida;

    private String partida;

    private String dispositivo;

    private String descripcionTicket;

    private String descripcionTecnico;


}
