package com.example.agendamentosMedicos.service;

import com.example.agendamentosMedicos.dto.request.MedicoRequestDTO;
import com.example.agendamentosMedicos.dto.request.PacienteRequestDTO;
import com.example.agendamentosMedicos.dto.response.MedicoResponseDTO;
import com.example.agendamentosMedicos.dto.response.MedicoResponseEspecialidadeDTO;
import com.example.agendamentosMedicos.dto.response.PacienteResponseDTO;
import com.example.agendamentosMedicos.enums.Especialidade;
import com.example.agendamentosMedicos.model.Medico;
import com.example.agendamentosMedicos.model.Paciente;
import com.example.agendamentosMedicos.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicoService {
    @Autowired
    private MedicoRepository repository;

    public MedicoResponseDTO createMedico(MedicoRequestDTO requestDTO){
        Medico medico = new Medico(requestDTO);
        repository.save(medico);

        return new MedicoResponseDTO(medico);
    }

    public List<MedicoResponseEspecialidadeDTO> listarPerEspecialidade(Especialidade especialidade){
        return repository.findByEspecialidade(especialidade).stream()
                .map(MedicoResponseEspecialidadeDTO::new)
                .toList();
    }

    public List<MedicoResponseDTO> listarMedicos(){
        return repository.findAll().stream()
                .map(MedicoResponseDTO::new)
                .toList();
    }

}
