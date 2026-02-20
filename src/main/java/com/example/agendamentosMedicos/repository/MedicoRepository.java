package com.example.agendamentosMedicos.repository;

import com.example.agendamentosMedicos.dto.response.MedicoResponseDTO;
import com.example.agendamentosMedicos.enums.Especialidade;
import com.example.agendamentosMedicos.model.Medico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MedicoRepository extends JpaRepository<Medico, Long> {

    List<Medico> findByEspecialidade(Especialidade especialidade);
}
