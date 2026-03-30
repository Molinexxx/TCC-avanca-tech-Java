const form = document.querySelector("#agendamento-form");
const feedback = document.querySelector("#feedback");
const lista = document.querySelector("#lista-agendamentos");
const filtroData = document.querySelector("#filtro-data");
const contador = document.querySelector("#count-agendamentos");

const hoje = new Date().toISOString().split("T")[0];
filtroData.value = hoje;

async function carregarAgendamentos(data) {
    const response = await fetch(`/agendamentos?data=${data}`);
    const agendamentos = await response.json();

    contador.textContent = agendamentos.length;
    lista.innerHTML = "";

    if (!agendamentos.length) {
        lista.innerHTML = '<div class="empty">Nenhum agendamento encontrado para a data selecionada.</div>';
        return;
    }

    agendamentos.forEach((agendamento) => {
        const horario = new Date(agendamento.dataHoraAgendamento).toLocaleString("pt-BR", {
            dateStyle: "short",
            timeStyle: "short"
        });

        const card = document.createElement("article");
        card.className = "card";
        card.innerHTML = `
            <span class="badge badge--soft">${agendamento.servico}</span>
            <strong>${agendamento.cliente}</strong>
            <p><b>Profissional:</b> ${agendamento.profissional}</p>
            <p><b>Telefone:</b> ${agendamento.telefoneCliente}</p>
            <p><b>Horario:</b> ${horario}</p>
        `;
        lista.appendChild(card);
    });
}

function definirFeedback(mensagem, tipo) {
    feedback.textContent = mensagem;
    feedback.className = `feedback feedback--${tipo}`;
}

form.addEventListener("submit", async (event) => {
    event.preventDefault();
    const body = Object.fromEntries(new FormData(form).entries());

    try {
        const response = await fetch("/agendamentos", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(body)
        });

        const payload = await response.json();

        if (!response.ok) {
            const mensagem = payload.erro || Object.values(payload)[0] || "Nao foi possivel salvar o agendamento.";
            throw new Error(mensagem);
        }

        definirFeedback("Agendamento salvo com sucesso.", "success");
        form.reset();
        filtroData.value = body.dataHoraAgendamento.split("T")[0];
        await carregarAgendamentos(filtroData.value);
    } catch (error) {
        definirFeedback(error.message, "error");
    }
});

filtroData.addEventListener("change", () => carregarAgendamentos(filtroData.value));

carregarAgendamentos(hoje);
