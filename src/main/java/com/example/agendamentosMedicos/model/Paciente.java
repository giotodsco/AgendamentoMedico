package com.example.agendamentosMedicos.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.IdGeneratorType;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_paciente")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true)
    private String document;

    private int idade;

    @OneToMany(mappedBy = "paciente")
    private List<Consulta> consultasListPacient = new ArrayList<>();

}
