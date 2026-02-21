package com.example.agendamentosMedicos.model;

import com.example.agendamentosMedicos.dto.request.ConsultaRequestDTO;
import com.example.agendamentosMedicos.dto.response.ConsultaResponseDTO;
import com.example.agendamentosMedicos.enums.StatusConsulta;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_consulta")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Consulta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "medico_id")
    private Medico medico;

    private HorariosMedico horariosMedico;

    private StatusConsulta statusConsulta;

    public Consulta(Paciente paciente, Medico medico, HorariosMedico horariosMedico){
        this.paciente = paciente;
        this.medico = medico;
        this.horariosMedico = horariosMedico;
        this.statusConsulta = StatusConsulta.AGENDADO;
    }
}
