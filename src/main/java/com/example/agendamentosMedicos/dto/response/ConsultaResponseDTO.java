package com.example.agendamentosMedicos.dto.response;

import com.example.agendamentosMedicos.enums.StatusConsulta;

import com.example.agendamentosMedicos.model.Consulta;
import jakarta.persistence.*;

public record ConsultaResponseDTO(Long id, String namePaciente, String nameMedico, String data, String horario, StatusConsulta statusConsulta) {
    public ConsultaResponseDTO(Consulta consulta){
        this(
                consulta.getId(),
                consulta.getPaciente().getName(),
                consulta.getMedico().getName(),
                consulta.getHorariosMedico().getData(),
                consulta.getHorariosMedico().getHorario(),
                consulta.getStatusConsulta()
        );

    }

}
