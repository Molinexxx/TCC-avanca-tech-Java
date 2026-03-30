package com.ProjectMolina.agendador_horarios.services;

import com.ProjectMolina.agendador_horarios.infrastructure.entity.Agendamento;
import com.ProjectMolina.agendador_horarios.infrastructure.repository.AgendamentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class AgendamentoService {

    private final AgendamentoRepository agendamentoRepository;

    public Agendamento salvarAgendamento(Agendamento agendamento) {
        validarDisponibilidade(agendamento.getProfissional(), agendamento.getDataHoraAgendamento(), null);
        return agendamentoRepository.save(agendamento);
    }

    public void deletarAgendamento(LocalDateTime dataHoraAgendamento, String cliente) {
        Agendamento agendamento = agendamentoRepository.findByDataHoraAgendamentoAndCliente(dataHoraAgendamento, cliente);
        if (Objects.isNull(agendamento)) {
            throw new RuntimeException("Nao existe agendamento para os dados informados");
        }
        agendamentoRepository.deleteByDataHoraAgendamentoAndCliente(dataHoraAgendamento, cliente);
    }

    public List<Agendamento> buscarAgendamentosDia(LocalDate data) {
        LocalDateTime primeiraHoraDia = data.atStartOfDay();
        LocalDateTime horaFinalDia = data.atTime(LocalTime.MAX.withNano(0));
        return agendamentoRepository.findByDataHoraAgendamentoBetween(primeiraHoraDia, horaFinalDia)
                .stream()
                .sorted((a, b) -> a.getDataHoraAgendamento().compareTo(b.getDataHoraAgendamento()))
                .toList();
    }

    public List<Agendamento> listarTodos() {
        return agendamentoRepository.findAll()
                .stream()
                .sorted((a, b) -> a.getDataHoraAgendamento().compareTo(b.getDataHoraAgendamento()))
                .toList();
    }

    public Agendamento alterarAgendamento(Agendamento agendamento, String cliente, LocalDateTime dataHoraAgendamento) {
        Agendamento agendaAtual = agendamentoRepository.findByDataHoraAgendamentoAndCliente(dataHoraAgendamento, cliente);

        if (Objects.isNull(agendaAtual)) {
            throw new RuntimeException("Nao existe agendamento para atualizar");
        }

        validarDisponibilidade(agendamento.getProfissional(), agendamento.getDataHoraAgendamento(), agendaAtual.getId());
        agendamento.setId(agendaAtual.getId());
        agendamento.setDataInsercao(agendaAtual.getDataInsercao());
        return agendamentoRepository.save(agendamento);
    }

    private void validarDisponibilidade(String profissional, LocalDateTime dataHoraAgendamento, Long idAtual) {
        Agendamento existente = agendamentoRepository.findByProfissionalAndDataHoraAgendamento(profissional, dataHoraAgendamento);
        if (Objects.nonNull(existente) && !Objects.equals(existente.getId(), idAtual)) {
            throw new RuntimeException("O profissional ja possui um agendamento neste horario");
        }
    }
}
