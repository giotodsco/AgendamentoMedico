package com.example.agendamentosMedicos.model;

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
    @JoinColumn(name = "paciente_id")
    private Medico medico;

    private String data;

    private String horario;

    private StatusConsulta statusConsulta;
}
