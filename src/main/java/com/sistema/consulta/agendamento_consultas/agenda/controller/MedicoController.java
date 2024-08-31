package com.sistema.consulta.agendamento_consultas.agenda.controller;

import com.sistema.consulta.agendamento_consultas.agenda.model.Medico;
import com.sistema.consulta.agendamento_consultas.agenda.service.impl.MedicoServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medico")
@RequiredArgsConstructor
public class MedicoController {

    private final MedicoServiceImpl medicoService;


    @GetMapping
    public List<Medico> listMedicos(){
        return medicoService.listMedicos();
    }

    @GetMapping("/{medicoId}")
    public Medico getMedico(@RequestParam Long medicoId) { return medicoService.getMedico(medicoId);}

    @PostMapping
    public ResponseEntity<Medico> createMedico(@RequestBody Medico medico){
        return ResponseEntity.status(HttpStatus.CREATED).body(medicoService.createMedico(medico));
    }

    @DeleteMapping("/{medicoId}")
    public ResponseEntity<HttpStatus> deleteMedico(@RequestParam Long medicoId) {
        medicoService.removeMedico(medicoId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
