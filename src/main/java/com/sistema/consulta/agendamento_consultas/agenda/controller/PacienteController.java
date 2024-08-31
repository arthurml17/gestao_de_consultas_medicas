package com.sistema.consulta.agendamento_consultas.agenda.controller;

import com.sistema.consulta.agendamento_consultas.agenda.model.Paciente;
import com.sistema.consulta.agendamento_consultas.agenda.service.impl.PacienteServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/paciente")
@RequiredArgsConstructor
public class PacienteController {

    private final PacienteServiceImpl pacienteService;

    @GetMapping
    public ResponseEntity<List<Paciente>> listPacientes(){
        return ResponseEntity.status(HttpStatus.OK).body(pacienteService.listPacientes());
    }

    @GetMapping("/{pacienteId}")
    public ResponseEntity<Paciente> getPaciente(@RequestParam Long pacienteId) {
        return ResponseEntity.status(HttpStatus.OK).body(pacienteService.getPaciente(pacienteId));
    }

    @PostMapping
    public ResponseEntity<Paciente> createMedico(@RequestBody Paciente paciente){
        return ResponseEntity.status(HttpStatus.CREATED).body(pacienteService.createPaciente(paciente));
    }

    @DeleteMapping("/{pacienteId}")
    public ResponseEntity<HttpStatus> deletePaceinte(@RequestParam Long pacienteId) {
        pacienteService.removePaciente(pacienteId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }


}
