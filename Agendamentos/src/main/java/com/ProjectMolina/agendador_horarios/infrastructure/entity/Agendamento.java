package com.ProjectMolina.agendador_horarios.infrastructure.entity;

import jakarta.persistence.*;
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
@Table (name = "agendamento")
public class Agendamento {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;
    private String servico;
    private String profissinal;
    private LocalDateTime dataHoraAgendamento;
    private String cliente;
    private String TelefoneDoCliente;
    private  LocalDateTime dataInsercao = LocalDateTime.now();
}
