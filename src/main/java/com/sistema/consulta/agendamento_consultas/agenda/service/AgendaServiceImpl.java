package com.sistema.consulta.agendamento_consultas.agenda.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.consulta.agendamento_consultas.agenda.model.Consulta;
import com.sistema.consulta.agendamento_consultas.agenda.model.Medico;
import com.sistema.consulta.agendamento_consultas.agenda.repository.ConsultaRepository;
import com.sistema.consulta.agendamento_consultas.agenda.repository.MedicoRepository;
import com.sistema.consulta.agendamento_consultas.agenda.repository.PacienteRepository;

@Service
public class AgendaServiceImpl implements AgendaService{
    
    @Autowired
    private ConsultaRepository consultaRepository;
    
    @Autowired
    private PacienteRepository pacienteRepository;
    
    @Autowired
    private MedicoRepository medicoRepository;

    @Override
    public List<Consulta> listarConsultas() {
        return consultaRepository.findAll();
    }

    @Override
    public void cancelarConsulta(Long consultaId) {
        if(!consultaRepository.existsById(consultaId))
            throw new IllegalArgumentException("Consulta não encontrada");
            
        consultaRepository.deleteById(consultaId);
    }

    @Override
    public Consulta agendarConsulta(Consulta consulta) {
        if(consulta == null || consulta.getMedico() == null || consulta.getPaciente() == null)
            throw new IllegalArgumentException("Consulta invalida");
        
        pacienteRepository.findById(consulta.getPaciente().getId())
            .orElseThrow(() -> new IllegalArgumentException("Paciente não encontrado"));

        Medico medico = medicoRepository.findById(consulta.getMedico().getId())
            .orElseThrow(() -> new IllegalArgumentException("Medico não encontrado"));

        if(checarDisponibilidadeMedico(medico, consulta.getDataHora()) == false)
            throw new IllegalArgumentException("Médico não disponivel para essa data e hora");
        
        return consultaRepository.save(consulta);
    }

    private boolean checarDisponibilidadeMedico(Medico medico, LocalDateTime dataHora){
        Optional<Consulta> consultaOpt = consultaRepository.findByMedicoAndDataHora(medico, dataHora);
        return !consultaOpt.isPresent();
    }
}
