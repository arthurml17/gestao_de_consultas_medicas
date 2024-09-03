package com.sistema.consulta.agendamento_consultas.agenda.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import com.sistema.consulta.agendamento_consultas.agenda.service.AgendaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.sistema.consulta.agendamento_consultas.agenda.model.Consulta;
import com.sistema.consulta.agendamento_consultas.agenda.model.Medico;
import com.sistema.consulta.agendamento_consultas.agenda.repository.ConsultaRepository;

@Service
@RequiredArgsConstructor
public class AgendaServiceImpl implements AgendaService {

    private final ConsultaRepository consultaRepository;

    private final PacienteServiceImpl pacienteService;

    private final MedicoServiceImpl medicoService;

    @Override
    public List<Consulta> listConsultas() {
        return consultaRepository.findAll();
    }

    @Override
    public Consulta getConsulta(Long consultaId){
        Optional<Consulta> consulta = consultaRepository.findById(consultaId);
        if(consulta.isEmpty())
            throw new IllegalArgumentException("Consulta não cadastrada");

        return consulta.get();
    }

    @Override
    public Consulta agendarConsulta(Consulta consulta) throws Exception {
        try {
            if(consulta == null || consulta.getMedico() == null || consulta.getPaciente() == null)
                throw new IllegalArgumentException("Consulta invalida");

            pacienteService.getPaciente(consulta.getPaciente().getId());

            Medico medico = medicoService.getMedico(consulta.getMedico().getId());

            if(checarDisponibilidadeMedico(medico, consulta.getDataHora()))
                throw new IllegalArgumentException("Médico não disponivel para essa data e hora");

            return consultaRepository.save(consulta);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public void cancelarConsulta(Long consultaId) {
        if(!consultaRepository.existsById(consultaId))
            throw new IllegalArgumentException("Consulta não encontrada");
            
        consultaRepository.deleteById(consultaId);
    }



    @Override
    public boolean checarDisponibilidadeMedico(Medico medico, LocalDateTime dataHora){
        return consultaRepository.existsByMedicoAndDataHora(medico, dataHora);
    }

}
