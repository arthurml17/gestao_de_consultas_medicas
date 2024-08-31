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
    public List<Consulta> listConsultas(){
        return agendaService.listConsultas();
    }

    @GetMapping("/{consultaId}")
    public Consulta getConsulta(@RequestParam Long consultaId) { return agendaService.getConsulta(consultaId);}

    @PostMapping
    public ResponseEntity<Consulta> agendarConsulta(@RequestBody Consulta consulta){
        Consulta novaConsulta = agendaService.agendarConsulta(consulta);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaConsulta);
    }

    @DeleteMapping("/{consultaId}")
    public ResponseEntity<HttpStatus> cancelarConsulta(@RequestParam Long consultaId) {
        try{
            agendaService.cancelarConsulta(consultaId);
            return ResponseEntity.status(HttpStatus.OK).build();
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
