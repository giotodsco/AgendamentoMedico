package com.example.agendamentosMedicos.repository;

import com.example.agendamentosMedicos.model.HorariosMedico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicoHorarioRepository extends JpaRepository<HorariosMedico, Long> {
}
