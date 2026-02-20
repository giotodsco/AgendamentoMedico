package com.example.agendamentosMedicos.service;

import com.example.agendamentosMedicos.dto.request.HorariosMedicosRequest;
import com.example.agendamentosMedicos.dto.response.HorariosMedicosResponse;
import com.example.agendamentosMedicos.dto.response.HorariosMedicosSimples;
import com.example.agendamentosMedicos.dto.response.MedicoResponseDTO;
import com.example.agendamentosMedicos.model.HorariosMedico;
import com.example.agendamentosMedicos.model.Medico;
import com.example.agendamentosMedicos.repository.MedicoHorarioRepository;
import com.example.agendamentosMedicos.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicoHorarioService {
    @Autowired
    private MedicoRepository repository;
    @Autowired
    private MedicoHorarioRepository medicoHorarioRepository;

    public HorariosMedicosSimples createHorario(HorariosMedicosRequest request, Long idMedico){
        Medico medicoParaColocarHorario = repository.findById(idMedico).orElseThrow(() -> new RuntimeException("Médico não encontrado"));
        HorariosMedico horariosMedico = new HorariosMedico(request, medicoParaColocarHorario);

        HorariosMedico horariosMedicoSalvo = medicoHorarioRepository.save(horariosMedico);
        medicoParaColocarHorario.getHorariosMedicos().add(horariosMedicoSalvo);
        repository.save(medicoParaColocarHorario);
        return new HorariosMedicosSimples(horariosMedicoSalvo);
    }
}
