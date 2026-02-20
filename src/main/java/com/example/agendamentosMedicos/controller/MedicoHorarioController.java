package com.example.agendamentosMedicos.controller;

import com.example.agendamentosMedicos.dto.request.HorariosMedicosRequest;
import com.example.agendamentosMedicos.dto.response.HorariosMedicosResponse;
import com.example.agendamentosMedicos.dto.response.HorariosMedicosSimples;
import com.example.agendamentosMedicos.service.MedicoHorarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/horario")
public class MedicoHorarioController {
    @Autowired
    private MedicoHorarioService service;

    @PostMapping("/medico/{idMedico}")
    public ResponseEntity<HorariosMedicosSimples> createHorario(@RequestBody HorariosMedicosRequest request, @PathVariable Long idMedico){
        HorariosMedicosSimples response = service.createHorario(request, idMedico);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
