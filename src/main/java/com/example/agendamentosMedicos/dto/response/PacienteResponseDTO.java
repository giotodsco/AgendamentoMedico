package com.example.agendamentosMedicos.dto.response;

import com.example.agendamentosMedicos.model.Consulta;
import com.example.agendamentosMedicos.model.Paciente;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

public record PacienteResponseDTO(Long id, String name, String document, int idade, List<Consulta> consultasListPacient) {
    public PacienteResponseDTO(Paciente paciente){
        this(
                paciente.getId(),
                paciente.getName(),
                paciente.getDocument(),
                paciente.getIdade(),
                paciente.getConsultasListPacient()
        );
    }
}
