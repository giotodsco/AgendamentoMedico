package com.example.agendamentosMedicos.repository;

import com.example.agendamentosMedicos.model.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
}
