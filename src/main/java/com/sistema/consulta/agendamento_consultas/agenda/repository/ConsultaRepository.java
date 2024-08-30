package com.sistema.consulta.agendamento_consultas.agenda.repository;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sistema.consulta.agendamento_consultas.agenda.model.Consulta;
import com.sistema.consulta.agendamento_consultas.agenda.model.Medico;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Long>{

    Optional<Consulta> findByMedicoAndDataHora(Medico medico, LocalDateTime dataHora);    

}
