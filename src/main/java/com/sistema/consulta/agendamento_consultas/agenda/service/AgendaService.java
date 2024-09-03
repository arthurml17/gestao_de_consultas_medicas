package com.sistema.consulta.agendamento_consultas.agenda.service;

import java.time.LocalDateTime;
import java.util.List;

import com.sistema.consulta.agendamento_consultas.agenda.model.Consulta;
import com.sistema.consulta.agendamento_consultas.agenda.model.Medico;

public interface AgendaService {

    List<Consulta> listConsultas();

    Consulta getConsulta(Long consultaId);

    Consulta agendarConsulta(Consulta consulta) throws Exception;

    boolean checarDisponibilidadeMedico(Medico medico, LocalDateTime dataHora);

    void cancelarConsulta(Long consultaId);
}
