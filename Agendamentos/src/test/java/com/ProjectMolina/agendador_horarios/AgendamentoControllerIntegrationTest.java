package com.ProjectMolina.agendador_horarios;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class AgendamentoControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void deveCriarAgendamentoEConsultarAgendaDoDia() throws Exception {
        String payload = """
                {
                  "servico": "Corte premium",
                  "profissional": "Ana",
                  "dataHoraAgendamento": "2099-12-30T10:00",
                  "cliente": "Marcos",
                  "telefoneCliente": "(11) 99999-1111"
                }
                """;

        mockMvc.perform(post("/agendamentos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payload))
                .andExpect(status().isAccepted())
                .andExpect(jsonPath("$.cliente").value("Marcos"))
                .andExpect(jsonPath("$.profissional").value("Ana"));

        mockMvc.perform(get("/agendamentos")
                        .param("data", "2099-12-30"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].servico").value("Corte premium"))
                .andExpect(jsonPath("$[0].telefoneCliente").value("(11) 99999-1111"));
    }
}
