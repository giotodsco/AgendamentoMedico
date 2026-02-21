package com.example.agendamentosMedicos.service;

import com.example.agendamentosMedicos.dto.request.ConsultaRequestDTO;
import com.example.agendamentosMedicos.dto.response.ConsultaResponseDTO;
import com.example.agendamentosMedicos.dto.response.HorariosMedicosResponse;
import com.example.agendamentosMedicos.dto.response.PacienteResponseDTO;
import com.example.agendamentosMedicos.model.Consulta;
import com.example.agendamentosMedicos.model.HorariosMedico;
import com.example.agendamentosMedicos.model.Medico;
import com.example.agendamentosMedicos.model.Paciente;
import com.example.agendamentosMedicos.repository.ConsultaRepository;
import com.example.agendamentosMedicos.repository.MedicoHorarioRepository;
import com.example.agendamentosMedicos.repository.MedicoRepository;
import com.example.agendamentosMedicos.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsultaService {
    @Autowired
    private ConsultaRepository consultaRepository;
    @Autowired
    private PacienteRepository repositoryPaciente;
    @Autowired
    private MedicoHorarioRepository medicoHorarioRepository;
    @Autowired
    private MedicoRepository medicoRepository;

    public ConsultaResponseDTO createConsulta(Long idPaciente, Long idMedico, Long idHorario){
        Paciente pacienteId = repositoryPaciente.getById(idPaciente);
        Medico medicoId = medicoRepository.getById(idMedico);
        HorariosMedico horariosMedico = medicoHorarioRepository.findById(idHorario).orElseThrow(() -> new RuntimeException("Nenhum horario"));

        Consulta consulta = new Consulta(pacienteId, medicoId, horariosMedico);
        horariosMedico.setDisponivel(false);

        medicoId.getConsultasListMedico().add(consulta);
        pacienteId.getConsultasListPacient().add(consulta);

        repositoryPaciente.save(pacienteId);
        consultaRepository.save(consulta);
        medicoRepository.save(medicoId);
        medicoHorarioRepository.save(horariosMedico);

        return new ConsultaResponseDTO(consulta);
    }

}
