package com.sistema.consulta.agendamento_consultas.agenda.util;

import com.github.javafaker.Faker;
import com.sistema.consulta.agendamento_consultas.agenda.model.Medico;
import com.sistema.consulta.agendamento_consultas.agenda.model.Paciente;
import com.sistema.consulta.agendamento_consultas.agenda.service.impl.MedicoServiceImpl;
import com.sistema.consulta.agendamento_consultas.agenda.service.impl.PacienteServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Locale;

@RequiredArgsConstructor
@Component
public class DataInitialization implements CommandLineRunner {

    private final MedicoServiceImpl medicoService;

    private final PacienteServiceImpl pacienteService;

    private Faker faker;

    @Override
    public void run(String... args) throws Exception {

        this.faker = new Faker(new Locale("pt", "BR"));

        if(medicoService.listMedicos().isEmpty())
            gerarMedicos();

        if(pacienteService.listPacientes().isEmpty())
            gerarPacientes();
    }

    private void gerarMedicos(){
        for(int i = 1; i <= 10; i++){
            Medico medico = Medico.builder()
                    .nome(faker.name().fullName())
                    .crm("CRM/PB" + (102023+i))
                    .especialidade(faker.medical().medicineName())
                    .build();
            medicoService.createMedico(medico);
        }
    }

    private void gerarPacientes(){
        for(int i = 1; i <= 10; i++){
            Paciente paciente = Paciente.builder()
                    .nome(faker.name().fullName())
                    .email(faker.name().username() + "@gmail.com")
                    .dataNascimento(LocalDate.now())
                    .telefone(faker.phoneNumber().cellPhone())
                    .build();
            pacienteService.createPaciente(paciente);
        }
    }

}
