package com.example.agendamentosMedicos.dto.request;

import com.example.agendamentosMedicos.enums.StatusConsulta;
import com.example.agendamentosMedicos.model.Medico;
import com.example.agendamentosMedicos.model.Paciente;
import jakarta.persistence.*;

public record ConsultaRequestDTO(Long idPaciente, Long idMedico, String data, String horario, StatusConsulta consulta) {
}
