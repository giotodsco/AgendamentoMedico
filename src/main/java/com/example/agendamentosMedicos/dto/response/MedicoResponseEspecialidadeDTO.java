package com.example.agendamentosMedicos.dto.response;

import com.example.agendamentosMedicos.enums.Especialidade;
import com.example.agendamentosMedicos.model.Consulta;
import com.example.agendamentosMedicos.model.Medico;

import java.util.List;

public record MedicoResponseEspecialidadeDTO(Long id, String name, Especialidade especialidade, String crm) {
    public MedicoResponseEspecialidadeDTO(Medico medico){
        this(
                medico.getId(),
                medico.getName(),
                medico.getEspecialidade(),
                medico.getCrm()
        );
    }
}
