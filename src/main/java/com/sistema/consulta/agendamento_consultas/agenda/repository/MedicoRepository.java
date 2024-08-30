package com.sistema.consulta.agendamento_consultas.agenda.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistema.consulta.agendamento_consultas.agenda.model.Medico;

public interface MedicoRepository extends JpaRepository<Medico, Long>{
}
