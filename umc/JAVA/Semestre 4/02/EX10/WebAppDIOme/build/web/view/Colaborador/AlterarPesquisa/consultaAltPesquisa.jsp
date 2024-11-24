<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Pesquisa"%>
<%@page import="model.dao.PesquisaDAO"%>
<!DOCTYPE html>
<html>
<head>
    <!-- Define o tipo de conteúdo da página como HTML com codificação UTF-8 -->
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Link para o arquivo de estilo CSS -->
    <link rel="stylesheet" href="../../css/Pesquisa.css">
    <title>DIO.me</title> <!-- Título da página -->
</head>
<body>
    <!-- Barra de navegação -->
    <div class="navbar">
        <h1>Portal Colaborador DIO.me</h1> <!-- Título principal do portal -->
        <div class="navbar-buttons">
            <a href="../../../index.html">Portal DIO.me</a> <!-- Botão para retornar ao portal principal -->
        </div>
    </div>
    
    <!-- Container principal da página -->
    <div class="container">
    <%
        // Captura o CPF enviado pelo formulário anterior
        String cpf = request.getParameter("cpf");

        // Cria uma instância da classe Pesquisa e define o CPF capturado
        Pesquisa pesquisa = new Pesquisa();
        pesquisa.setCpf(cpf);

        // Cria uma instância de PesquisaDAO para consultar o banco de dados
        PesquisaDAO pesquisaDao = new PesquisaDAO();

        // Verifica se a pesquisa existe no banco de dados
        if (pesquisaDao.consultaPesquisa(pesquisa) != null) {
            // Exibe o formulário de alteração caso a pesquisa seja encontrada
            out.println("<div class='container__titulo'><h2>Alteração Pesquisa</h2>");
            out.println("<div class='indice'><h3>Escala de Satisfação:</h3>");
            out.println("<ul> <li>1: 😠 Muito Insatisfeito</li>");
            out.println("<li>2: 🙁 Pouco Insatisfeito</li>");
            out.println("<li>3: 😐 Neutro</li>");
            out.println("<li>4: 🙂 Pouco Satisfeito</li>");
            out.println("<li>5: 😍 Muito Satisfeito</li> </ul></div>");
    %>
        <!-- Formulário de alteração de pesquisa -->
        <form method="post" action="alterarPesquisa.jsp" class="formulario">
            <!-- Campo de Nome (apenas leitura) -->
            <div class="form-group">
                <label class="labelPergunta">Nome:</label>
                <input type="text" id="nome" name="nome" placeholder="Digite seu Nome" value="<%= pesquisa.getNome() %>" 
                       readonly title="O Nome não pode ser alterado.">
            </div>

            <!-- Campo de CPF (apenas leitura) -->
            <div class="form-group">
                <label class="labelPergunta">CPF:</label>
                <input type="text" id="cpf" name="cpf" placeholder="Digite seu CPF" value="<%= pesquisa.getCpf() %>" 
                       required maxlength="11" pattern="\d{11}" readonly title="O CPF não pode ser alterado.">
            </div>

            <!-- Perguntas de avaliação -->
            <label class="labelPergunta">1) Como você avaliaria a facilidade de navegação na plataforma?</label>
            <input type="number" id="navegacao" name="navegacao" required maxlength="1" value="<%= pesquisa.getP1() %>" min="1" max="5" />

            <label class="labelPergunta">2) Como você considera o conteúdo apresentado relevante para o seu aprendizado?</label>
            <input type="number" id="conteudo" name="conteudo" required maxlength="1" value="<%= pesquisa.getP2() %>" min="1" max="5" />

            <label class="labelPergunta">3) Você sente que os materiais são bem organizados e fáceis de entender?</label>
            <input type="number" id="organizacao" name="organizacao" required maxlength="1" value="<%= pesquisa.getP3() %>" min="1" max="5" />

            <label class="labelPergunta">4) A plataforma oferece um bom suporte ao aluno em caso de dúvidas?</label>
            <input type="number" id="suporte" name="suporte" required maxlength="1" value="<%= pesquisa.getP4() %>" min="1" max="5" />

            <label class="labelPergunta">5) Você acha que a plataforma ajudou a melhorar o seu desempenho acadêmico?</label>
            <input type="number" id="desempenho" name="desempenho" required maxlength="1" value="<%= pesquisa.getP5() %>" min="1" max="5" />

            <!-- Botão de submissão -->
            <input class="butPesquisa" type="submit" value="Alterar Pesquisa">
        </form>
    <%
        } else {
            // Exibe uma mensagem de erro caso a pesquisa não seja encontrada
            out.println("<p class='resultado'>Erro! Pesquisa não realizada!!!</p>");
        }
    %>
    </div>  
</body>
</html>
