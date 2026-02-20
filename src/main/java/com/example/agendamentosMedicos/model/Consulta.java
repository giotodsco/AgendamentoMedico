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

    private String data;

    private String horario;

    private StatusConsulta statusConsulta;

    public Consulta(Paciente paciente, Medico medico, String data, String horario){
        this.paciente = paciente;
        this.medico = medico;
        this.data = data;
        this.horario = horario;
        this.statusConsulta = StatusConsulta.AGENDADO;
    }
}
