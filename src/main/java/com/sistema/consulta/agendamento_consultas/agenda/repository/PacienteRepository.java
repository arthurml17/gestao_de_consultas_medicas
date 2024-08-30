package com.sistema.consulta.agendamento_consultas.agenda.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistema.consulta.agendamento_consultas.agenda.model.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Long>{
}
