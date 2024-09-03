package com.sistema.consulta.agendamento_consultas.agenda.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "medicos")
public class Medico extends BaseEntity {

    @Column(name = "nome", nullable = false, length = 100)
    private String nome;

    @Column(name = "especialidade", nullable = false, length = 100)
    private String especialidade;

    @Column(name = "crm", nullable = false, unique = true, length = 20)
    private String crm;

}
