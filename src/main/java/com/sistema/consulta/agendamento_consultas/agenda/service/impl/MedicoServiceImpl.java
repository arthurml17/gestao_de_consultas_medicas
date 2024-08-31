package com.sistema.consulta.agendamento_consultas.agenda.service.impl;

import com.sistema.consulta.agendamento_consultas.agenda.model.Medico;
import com.sistema.consulta.agendamento_consultas.agenda.repository.MedicoRepository;
import com.sistema.consulta.agendamento_consultas.agenda.service.MedicoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MedicoServiceImpl implements MedicoService {

    private final MedicoRepository medicoRepository;


    @Override
    public List<Medico> listMedicos() {
        return medicoRepository.findAll();
    }

    @Override
    public Medico getMedico(Long medicoId) {
        Optional<Medico> medico = medicoRepository.findById(medicoId);
        if(medico.isEmpty())
            throw new IllegalArgumentException("Medico não encontrado.");

        return medico.get();
    }

    @Override
    public Medico createMedico(Medico medico) {
        return medicoRepository.save(medico);
    }

    @Override
    public void removeMedico(Long medicoId) {
        medicoRepository.deleteById(medicoId);
    }
}
