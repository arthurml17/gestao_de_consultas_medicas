package com.sistema.consulta.agendamento_consultas.agenda.service;

import com.sistema.consulta.agendamento_consultas.agenda.model.Paciente;

import java.time.LocalDateTime;
import java.util.List;

public interface PacienteService {

    List<Paciente> listPacientes();

    Paciente getPaciente(Long pacienteId);

    Paciente createPaciente(Paciente paciente);

    void removePaciente(Long pacienteId);
}
