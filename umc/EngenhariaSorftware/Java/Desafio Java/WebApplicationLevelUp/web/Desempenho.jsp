<%@ page import="java.util.List" %>
<%@ page import="Model.Meta" %>
<%@ page import="Model.Recomendacao" %>
<%@ page import="Model.Solid_Liskov.Recompensa" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dashboard Completo - LevelUp</title>
    <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="css/Desempenho.css">
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
</head>
<body>
<header>
    <div class="logo">🚀 LevelUp</div>
    <nav>
        <ul>
            <li><a href="index.html">Início</a></li>
            <li><a href="Cadastro.html">Cadastrar Meta</a></li>
            <li><a href="ConsultaByRegistro.html">Consultar Metas</a></li>
        </ul>
    </nav>
</header>

<main>
    <h2>📊 Dashboard Completo</h2>

<%
    List<Meta> metas = (List<Meta>) request.getAttribute("metas");
    Recompensa recompensa = (Recompensa) request.getAttribute("recompensa");

    if (metas != null && !metas.isEmpty()) {
        int totalProgresso = 0;
        int totalEtapas = 0;
        for (Meta m : metas) {
            totalProgresso += m.getProgresso();
            totalEtapas += m.getEtapas();
        }
        int percentualConcluido = totalProgresso / metas.size();
        double mediaEtapas = (double) totalEtapas / metas.size();
%>

    <!-- Resumo Geral -->
    <div class="section">
        <h3>📈 Resumo Geral</h3>
        <p><strong>Total de Metas:</strong> <%= metas.size() %></p>
        <p><strong>Percentual Concluído:</strong> <%= percentualConcluido %>%</p>
        <p><strong>Média de Etapas por Meta:</strong> <%= String.format("%.2f", mediaEtapas) %></p>
        <button class="btn" id="btnRevelar">🎁 Revelar Recompensa</button>
        <div class="recompensa hidden" id="recompensaCard">
            <h3>🏆 Sua Recompensa!</h3>
            <p><strong>Nível:</strong> <%= recompensa.getNivel() %></p>
            <p><%= recompensa.getMensagem() %></p>
        </div>
    </div>

    <!-- Gráficos de progresso -->
    <div class="section">
        <h3>📊 Gráfico de Progresso</h3>
        <canvas id="graficoProgresso"></canvas>
    </div>

    <!-- Cards de Metas -->
    <div class="section">
        <h3>🎯 Metas Detalhadas</h3>
        <div class="cards-container">
        <%
            for (Meta meta : metas) {
        %>
            <div class="card">
                <h4><%= meta.getTitulo() %></h4>
                <p><strong>Descrição:</strong> <%= meta.getDescricao() %></p>
                <p><strong>Etapa:</strong> <%= meta.getEtapaAtual() %> / <%= meta.getEtapas() %></p>
                <div class="progress">
                    <div class="progress-bar" style="width:<%= meta.getProgresso() %>%">
                        <%= meta.getProgresso() %>%
                    </div>
                </div>
                <h5>📚 Recomendações:</h5>
                <%
                    if (meta.getRecomendacoes() != null && !meta.getRecomendacoes().isEmpty()) {
                        for (Recomendacao rec : meta.getRecomendacoes()) {
                %>
                    <div class="recomendacao">
                        <strong><%= rec.getTitulo() %></strong><br>
                        <%= rec.getDescricao() %><br>
                        <a href="<%= rec.getUrlCurso() %>" target="_blank">👉 Acessar curso</a>
                    </div>
                <%
                        }
                    } else {
                %>
                    <p>Nenhuma recomendação para esta meta.</p>
                <%
                    }
                %>
            </div>
        <%
            }
        %>
        </div>
    </div>

<%
    } else {
%>
    <p>Nenhuma meta encontrada para este registro.</p>
<%
    }
%>

</main>

<footer style="text-align:center; padding:15px; background:#2c3e50; color:white;">
    <p>&copy; 2025 LevelUp - Sistema de Metas | Desenvolvido por Higor Castro</p>
</footer>

<script>
    // Mostrar recompensa
    document.getElementById('btnRevelar').addEventListener('click', function() {
        var card = document.getElementById('recompensaCard');
        card.classList.toggle('hidden');
        card.scrollIntoView({behavior: 'smooth'});
    });

    // Gráfico de progresso
    var ctx = document.getElementById('graficoProgresso').getContext('2d');
    var labels = [
        <% for (int i=0; i<metas.size(); i++) { %>
            "<%= metas.get(i).getTitulo() %>"<%= (i < metas.size()-1 ? "," : "") %>
        <% } %>
    ];
    var data = [
        <% for (int i=0; i<metas.size(); i++) { %>
            <%= metas.get(i).getProgresso() %><%= (i < metas.size()-1 ? "," : "") %>
        <% } %>
    ];
    new Chart(ctx, {
        type: 'bar',
        data: {
            labels: labels,
            datasets: [{
                label: 'Progresso (%)',
                data: data,
                backgroundColor: '#3498db'
            }]
        },
        options: {
            responsive: true,
            scales: { y: { beginAtZero:true, max:100 } }
        }
    });
</script>
</body>
</html>
