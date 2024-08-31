package com.sistema.consulta.agendamento_consultas.agenda.controller;

import com.sistema.consulta.agendamento_consultas.agenda.model.Consulta;
import com.sistema.consulta.agendamento_consultas.agenda.service.impl.AgendaServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/consulta")
@RequiredArgsConstructor
public class ConsultaController {

    private final AgendaServiceImpl agendaService;

    @GetMapping
    public ResponseEntity<List<Consulta>> listConsultas(){
        return ResponseEntity.status(HttpStatus.OK).body(agendaService.listConsultas());
    }

    @GetMapping("/{consultaId}")
    public ResponseEntity<Consulta> getConsulta(@RequestParam Long consultaId) {
        return ResponseEntity.status(HttpStatus.OK).body(agendaService.getConsulta(consultaId));
    }

    @PostMapping
    public ResponseEntity<Consulta> agendarConsulta(@RequestBody Consulta consulta){
        return ResponseEntity.status(HttpStatus.CREATED).body(agendaService.agendarConsulta(consulta));
    }

    @DeleteMapping("/{consultaId}")
    public ResponseEntity<HttpStatus> cancelarConsulta(@RequestParam Long consultaId) {
        agendaService.cancelarConsulta(consultaId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
