package com.example.agendamentosMedicos.dto.request;

import jakarta.persistence.Column;

public record PacienteRequestDTO(String name, String document, int idade) {
}
