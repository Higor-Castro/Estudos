<%@ page import="java.util.List" %>
<%@ page import="Model.Meta" %>
<%@ page import="Model.Recomendacao" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Minhas Metas</title>
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/metas.css">
</head>
<body>

    <!-- Header padrão -->
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

    <!-- Conteúdo principal -->
    <main>
        <h1>📌 Minhas Metas</h1>

        <%
            List<Meta> metas = (List<Meta>) request.getAttribute("metas"); 
            if (metas != null && !metas.isEmpty()) {
                for (Meta meta : metas) {
        %>
        <div class="card">
            <div class="user-info">
                <h2>👤 Usuário</h2>
                <p><strong>Registro:</strong> <%= meta.getUsuario().getRegistro() %></p>
                <p><strong>Nome:</strong> <%= meta.getUsuario().getNome() %></p>
                <p><strong>Cargo:</strong> <%= meta.getUsuario().getCargo() %></p>
                <p><strong>Departamento:</strong> <%= meta.getUsuario().getDepartamento() %></p>
                <p><strong>Email:</strong> <%= meta.getUsuario().getEmail() %></p>
            </div>
            <hr>

            <h2>🎯 Meta: <%= meta.getTitulo() %></h2>
            <p><%= meta.getDescricao() %></p>
            <p><strong>Etapa:</strong> <%= meta.getEtapaAtual() %> / <%= meta.getEtapas() %></p>
            <p><strong>Data de criação:</strong> <%= meta.getDataCriacao() %></p>

            <div class="progress">
                <div class="progress-bar" style="width:<%= meta.getProgresso() %>%">
                    <%= meta.getProgresso() %>%
                </div>
            </div>

            <h3>📚 Recomendações desta etapa:</h3>
            <%
                boolean temRec = false;
                if (meta.getRecomendacoes() != null && !meta.getRecomendacoes().isEmpty()) {
                    for (Recomendacao rec : meta.getRecomendacoes()) {
                        if (rec.getEtapa() == meta.getEtapaAtual()) {
                            temRec = true;
            %>
                <div class="recomendacao">
                    <strong><%= rec.getTitulo() %></strong><br>
                    <%= rec.getDescricao() %><br>
                    <a href="<%= rec.getUrlCurso() %>" target="_blank">👉 Acessar curso</a>
                </div>
            <%
                        }
                    }
                }
                if (!temRec) {
            %>
                <p>Nenhuma recomendação para esta etapa.</p>
            <%
                }
            %>

            <div class="acoes">
                <div class="form">
                    <button onclick="alterarDisplay()" class="btn btn-warning">✏️ Alterar</button>
                </div>

                <form action="Controll" method="post">
                    <input type="hidden" name="id" value="<%= meta.getId() %>"/>
                    <input type="hidden" name="registro" value="<%= meta.getUsuario().getRegistro() %>"/>
                    <button type="submit" name="ButAction" value="Deletar" class="btn btn-danger">🗑️ Excluir</button>
                </form>

                <form action="Controll" method="post">
                    <input type="hidden" name="idMeta" value="<%= meta.getId() %>"/>
                    <input type="hidden" name="etapas" value="<%= meta.getEtapas()%>"/>
                    <input type="hidden" name="etapaAtual" value="<%= meta.getEtapaAtual()%>"/>
                    <button type="submit" name="ButAction" value="ProximaEtapa" class="btn">➡️ Próxima Etapa</button>
                </form>
            </div>
        </div>

        <!-- Formulario para Update da Meta -->  
    <div class="card cardEscondido" style="display: none">
    <form action="Controll" method="post" class="editar-card" accept-charset="UTF-8">
        <h3>Alterar Meta</h3>
        <h3>👤 Usuário</h3>
        <input type="hidden" name="registro" value="<%= meta.getUsuario().getRegistro() %>"/>
        <label>Nome:</label>
        <input type="text" name="nome" value="<%= meta.getUsuario().getNome() %>"/>
        <label>Cargo:</label>
        <input type="text" name="cargo" value="<%= meta.getUsuario().getCargo() %>"/>
        <label>Departamento:</label>
        <input type="text" name="departamento" value="<%= meta.getUsuario().getDepartamento() %>"/>
        <label>Email:</label>
        <input type="email" name="email" value="<%= meta.getUsuario().getEmail() %>"/>
        <hr>
        <h3>🎯 Meta</h3>
        <input type="hidden" name="idMeta" value="<%= meta.getId() %>"/>
        <label>Título:</label>
        <input type="text" name="titulo" value="<%= meta.getTitulo() %>"/>
        <label>Descrição:</label>
        <textarea name="descricao"><%= meta.getDescricao() %></textarea>
        <p><strong>Etapa:</strong> <%= meta.getEtapas() %></p> <br>
        <select name="frequencia" required>
                <option value="">Selecione...</option>
                <option value="diaria">Diária</option>
                <option value="semanal">Semanal</option>
                <option value="mensal">Mensal</option>
        </select>
        <hr>
        <h3>📚 Recomendação da Etapa Atual</h3>
        <%
            Recomendacao recAtual = null;
            if (meta.getRecomendacoes() != null) {
                for (Recomendacao rec : meta.getRecomendacoes()) {
                    if (rec.getEtapa() == meta.getEtapaAtual()) {
                        recAtual = rec;
                        break;
                    }
                }
            }
            if (recAtual != null) {
        %>
            <input type="hidden" name="idRecomendacao" value="<%= recAtual.getId() %>"/>
            <label>Título da recomendação:</label>
            <input type="text" name="tituloRecomendacao" value="<%= recAtual.getTitulo() %>"/>
            <label>Descrição:</label>
            <textarea name="descricaoRecomendacao"><%= recAtual.getDescricao() %></textarea>
            <label>URL do Curso:</label>
            <input type="text" name="urlCurso" value="<%= recAtual.getUrlCurso() %>"/>
        <%
            } else {
        %>
            <p>⚠️ Nenhuma recomendação nesta etapa.</p>
        <%
            }
        %>

        <!-- BOTÃO SALVAR -->
        <div class="acoes">
            <button type="submit" name="ButAction" value="Alterar" class="btn btn-success">
                💾 Salvar
            </button>
             <button type="button" class="btn btnFechar">
                 ❌ Fechar
             </button>
        </div>
    </form>
</div>
        <%
                }
            } else {
        %>
        <p>Nenhuma meta encontrada.</p>
        <%
            }
        %>
    </main>

    <!-- Footer padrão -->
    <footer>
        <p>&copy; 2025 LevelUp - Sistema de Metas | Desenvolvido por Higor Castro</p>
    </footer>

    <script>
        function alterarDisplay() {
            const card = document.querySelector(".cardEscondido");

            // Cria overlay se não existir
            let overlay = document.getElementById("overlayModal");
            if (!overlay) {
                overlay = document.createElement("div");
                overlay.id = "overlayModal";
                document.body.appendChild(overlay);
                Object.assign(overlay.style, {
                    position: "fixed",
                    top: 0, left: 0,
                    width: "100%", height: "100%",
                    backgroundColor: "rgba(0,0,0,0.5)",
                    zIndex: 900
                });
            }
            overlay.style.display = "block";

            // Mostra e centraliza o card
            Object.assign(card.style, {
                display: "block",
                position: "fixed",
                top: "50%", left: "50%",
                transform: "translate(-50%, -50%)",
                zIndex: 1000,
                width: "400px", maxHeight: "90%", overflowY: "auto",
                padding: "20px", backgroundColor: "#fff", borderRadius: "10px"
            });

            // Remove disabled para edição
            card.querySelectorAll("input, textarea").forEach(i => i.removeAttribute("disabled"));

            // Fecha card + overlay ao salvar ou clicar em fechar
            ["submit",".btnFechar"].forEach(sel => {
                const el = card.querySelector(sel);
                if(el) el.addEventListener("click", () => {
                    card.style.display = overlay.style.display = "none";
                });
            });
        }


    </script>
</body>
</html>

