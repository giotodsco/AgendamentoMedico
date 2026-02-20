package com.example.agendamentosMedicos.service;

import com.example.agendamentosMedicos.dto.request.PacienteRequestDTO;
import com.example.agendamentosMedicos.dto.response.PacienteResponseDTO;
import com.example.agendamentosMedicos.model.Paciente;
import com.example.agendamentosMedicos.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    public PacienteResponseDTO createPaciente(PacienteRequestDTO requestDTO){
        Paciente paciente = new Paciente(requestDTO);
        pacienteRepository.save(paciente);

        return new PacienteResponseDTO(paciente);
    }

}
