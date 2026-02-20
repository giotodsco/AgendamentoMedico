package com.example.agendamentosMedicos.dto.request;

import com.example.agendamentosMedicos.enums.Especialidade;

public record MedicoRequestDTO(String name, Especialidade especialidade, String crm) {
}
