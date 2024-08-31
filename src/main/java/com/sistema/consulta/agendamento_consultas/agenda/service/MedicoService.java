package com.sistema.consulta.agendamento_consultas.agenda.service;


import com.sistema.consulta.agendamento_consultas.agenda.model.Medico;

import java.util.List;

public interface MedicoService {

    List<Medico> listMedicos();

    Medico getMedico(Long medicoId);

    Medico createMedico(Medico medico);

    void removeMedico(Long medicoId);

}
