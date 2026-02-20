package com.example.agendamentosMedicos.controller;

import com.example.agendamentosMedicos.dto.request.MedicoRequestDTO;
import com.example.agendamentosMedicos.dto.response.MedicoResponseDTO;
import com.example.agendamentosMedicos.dto.response.MedicoResponseEspecialidadeDTO;
import com.example.agendamentosMedicos.enums.Especialidade;
import com.example.agendamentosMedicos.service.MedicoService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medico")
public class MedicoController {
    @Autowired
    private MedicoService service;

    @PostMapping
    public ResponseEntity<MedicoResponseDTO> createMedico(@RequestBody MedicoRequestDTO requestDTO){
        MedicoResponseDTO medicoResponseDTO = service.createMedico(requestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(medicoResponseDTO);
    }

    @GetMapping("/especialidade/{especialidade}")
    public ResponseEntity<List<MedicoResponseEspecialidadeDTO>> procurarEspecialidade(@PathVariable Especialidade especialidade){
        return ResponseEntity.ok(service.listarPerEspecialidade(especialidade));
    }
}
