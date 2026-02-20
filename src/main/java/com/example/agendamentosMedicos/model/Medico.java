package com.example.agendamentosMedicos.model;

import com.example.agendamentosMedicos.dto.request.MedicoRequestDTO;
import com.example.agendamentosMedicos.enums.Especialidade;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_medico")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    @Column(unique = true)
    private String crm;

    @OneToMany(mappedBy = "medico")
    private List<HorariosMedico> horariosMedicos = new ArrayList<>();

    @OneToMany(mappedBy = "medico")
    private List<Consulta> consultasListMedico = new ArrayList<>();

    public Medico(MedicoRequestDTO requestDTO){
        //String name, Especialidade especialidade, String crm
        this.name = requestDTO.name();
        this.especialidade = requestDTO.especialidade();
        this.crm = requestDTO.crm();
    }
}
