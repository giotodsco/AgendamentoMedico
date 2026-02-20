package com.example.agendamentosMedicos.dto.response;

import com.example.agendamentosMedicos.model.HorariosMedico;
import com.example.agendamentosMedicos.model.Medico;

public record HorariosMedicosResponse(Long id, Long medicoId, String data, String horario, boolean isDisponivel) {
    public HorariosMedicosResponse(HorariosMedico horariosMedico){
        this(
                horariosMedico.getId(),
                horariosMedico.getMedico().getId(),
                horariosMedico.getData(),
                horariosMedico.getHorario(),
                horariosMedico.isDisponivel()

        );
    }

}
