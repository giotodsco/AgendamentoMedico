package com.example.agendamentosMedicos.dto.request;

import com.example.agendamentosMedicos.model.Medico;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public record HorariosMedicosRequest(String data, String horario) {
}
