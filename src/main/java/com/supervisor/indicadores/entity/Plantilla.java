package com.supervisor.indicadores.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
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


    @NotBlank(message = "activity_pt_st is required")
    private String activity_pt_st;

    @NotBlank(message = "activity_type is required")
    private String activity_type;

    @NotBlank(message = "ticket_description is required")
    private String ticket_description;

    private String admin_activity;

    private String fault_type;

    private String fault_cat;

    @Column(unique = true)
    @NotBlank(message = "tech_description is required")
    private String tech_description;

    private String fault_case;

    private String device;

    private String solution_type;

    private String tools;

    private String suplies;

    private String party_number;

    private String party_desc;

    private String comments;

}
