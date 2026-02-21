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

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class MedicoHorarioService {
    @Autowired
    private MedicoRepository repository;
    @Autowired
    private MedicoHorarioRepository medicoHorarioRepository;

    public HorariosMedicosSimples createHorario(HorariosMedicosRequest request, Long idMedico){
        Medico medicoParaColocarHorario = repository.findById(idMedico).orElseThrow(() -> new RuntimeException("Médico não encontrado"));

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataConsulta = LocalDate.parse(request.data(), formatter);

        boolean horarioJaExiste = medicoParaColocarHorario.getHorariosMedicos().stream()
                .anyMatch
                        (hora -> hora.getData().equals(request.data()) && hora.getHorario().equals(request.horario()));

        if(dataConsulta.isBefore(LocalDate.now())){
            throw new RuntimeException("Data deve ser futura!");
        }

        if(horarioJaExiste){
            throw new RuntimeException("Medico ja tem consulta nesse dia e hora");
        }

        HorariosMedico horariosMedico = new HorariosMedico(request, medicoParaColocarHorario);

        HorariosMedico horariosMedicoSalvo = medicoHorarioRepository.save(horariosMedico);
        medicoParaColocarHorario.getHorariosMedicos().add(horariosMedicoSalvo);
        repository.save(medicoParaColocarHorario);
        return new HorariosMedicosSimples(horariosMedicoSalvo);
    }
}
