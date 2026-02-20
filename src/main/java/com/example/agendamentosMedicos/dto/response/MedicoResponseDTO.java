package com.example.agendamentosMedicos.dto.response;

import com.example.agendamentosMedicos.enums.Especialidade;
import com.example.agendamentosMedicos.model.Consulta;
import com.example.agendamentosMedicos.model.Medico;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.util.List;

public record MedicoResponseDTO(Long id, String name, Especialidade especialidade, String crm, List<Consulta> consultasListMedico) {
    public MedicoResponseDTO(Medico medico){
        this(
                medico.getId(),
                medico.getName(),
                medico.getEspecialidade(),
                medico.getCrm(),
                medico.getConsultasListMedico()
        );
    }
}
