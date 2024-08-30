package com.sistema.consulta.agendamento_consultas.agenda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sistema.consulta.agendamento_consultas.agenda.model.Paciente;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long>{
}
