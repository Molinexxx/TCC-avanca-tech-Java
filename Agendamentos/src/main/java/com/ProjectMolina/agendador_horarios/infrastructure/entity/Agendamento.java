package com.ProjectMolina.agendador_horarios.infrastructure.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "agendamento")
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Informe o servico")
    private String servico;

    @NotBlank(message = "Informe o profissional")
    @Column(name = "profissional")
    private String profissional;

    @NotNull(message = "Informe a data e hora do agendamento")
    @Future(message = "A data do agendamento deve estar no futuro")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime dataHoraAgendamento;

    @NotBlank(message = "Informe o nome do cliente")
    private String cliente;

    @NotBlank(message = "Informe o telefone do cliente")
    @Pattern(regexp = "^[0-9()\\-\\s+]{8,20}$", message = "Informe um telefone valido")
    @Column(name = "telefone_cliente")
    private String telefoneCliente;

    @Column(nullable = false)
    private LocalDateTime dataInsercao = LocalDateTime.now();
}
