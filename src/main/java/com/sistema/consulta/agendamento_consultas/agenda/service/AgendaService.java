package com.sistema.consulta.agendamento_consultas.agenda.service;

import java.util.List;

import com.sistema.consulta.agendamento_consultas.agenda.model.Consulta;

public interface AgendaService {

    List<Consulta> listarConsultas();

    void cancelarConsulta(Long consultaId);

    Consulta agendarConsulta(Consulta consulta);
}
