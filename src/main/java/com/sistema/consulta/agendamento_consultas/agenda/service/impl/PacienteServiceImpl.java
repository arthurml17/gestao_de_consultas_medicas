package com.sistema.consulta.agendamento_consultas.agenda.service.impl;

import com.sistema.consulta.agendamento_consultas.agenda.model.Paciente;
import com.sistema.consulta.agendamento_consultas.agenda.repository.PacienteRepository;
import com.sistema.consulta.agendamento_consultas.agenda.service.PacienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PacienteServiceImpl implements PacienteService {

    private final PacienteRepository pacienteRepository;

    @Override
    public List<Paciente> listPacientes() {
        return pacienteRepository.findAll();
    }

    @Override
    public Paciente getPaciente(Long pacienteId) {

        Optional<Paciente> paciente = pacienteRepository.findById(pacienteId);
        if(paciente.isEmpty())
            throw new IllegalArgumentException("Paciente não encontrado.");

        return paciente.get();
    }

    @Override
    public Paciente createPaciente(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    @Override
    public void removePaciente(Long pacienteId) {
        pacienteRepository.deleteById(pacienteId);
    }
}
