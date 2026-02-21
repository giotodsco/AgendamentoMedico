package com.example.agendamentosMedicos.model;

import com.example.agendamentosMedicos.dto.request.HorariosMedicosRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_horarios_medico")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class HorariosMedico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String data;

    private String horario;

    private boolean isDisponivel;

    @ManyToOne
    @JoinColumn(name = "medico_id")
    private Medico medico;

    public HorariosMedico(HorariosMedicosRequest request, Medico medico){
        //(Long medicoid, String data, String horario)
        this.medico = medico;
        this.data = request.data();
        this.horario = request.horario();
        this.isDisponivel = true;
    }

}
