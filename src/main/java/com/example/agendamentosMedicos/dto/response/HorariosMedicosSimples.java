package com.example.agendamentosMedicos.dto.response;

import com.example.agendamentosMedicos.model.HorariosMedico;

public record HorariosMedicosSimples(Long id, String data, String horario, boolean disponivel) {
    public HorariosMedicosSimples(HorariosMedico horario){
        this(
                horario.getId(),
                horario.getData(),
                horario.getHorario(),
                horario.isDisponivel()
        );
    }
}
