<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Pesquisa"%>
<%@page import="model.dao.PesquisaDAO"%>
<!DOCTYPE html>
<html>
<head>
    <!-- Define o tipo de conteúdo como HTML com codificação UTF-8 -->
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Link para o arquivo CSS externo -->
    <link rel="stylesheet" href="../../css/style.css">
    <title>DIO.me</title> <!-- Define o título da página -->
</head>
<body>
    <!-- Barra de navegação -->
    <div class="navbar">
        <h1>Portal Colaborador DIO.me</h1> <!-- Título na barra -->
        <div class="navbar-buttons">
            <a href="../../../index.html">Portal DIO.me</a> <!-- Botão para voltar à página inicial -->
        </div>
    </div>
    
    <!-- Contêiner principal -->
    <div class="container">
    <%
        // Captura os parâmetros enviados pelo formulário (os valores das perguntas e CPF)
        String cpf = request.getParameter("cpf"); // CPF enviado pelo formulário
        int navegacao = Integer.parseInt(request.getParameter("navegacao")); // Avaliação da navegação
        int conteudo = Integer.parseInt(request.getParameter("conteudo"));   // Avaliação do conteúdo
        int organizacao = Integer.parseInt(request.getParameter("organizacao")); // Avaliação da organização
        int suporte = Integer.parseInt(request.getParameter("suporte"));     // Avaliação do suporte
        int desempenho = Integer.parseInt(request.getParameter("desempenho")); // Avaliação do desempenho

        // Cria uma nova instância da classe Pesquisa e define os valores capturados
        Pesquisa pesquisa  = new Pesquisa();
        pesquisa.setCpf(cpf); // Define o CPF no objeto Pesquisa
        pesquisa.setP1(navegacao); // Define a avaliação da navegação
        pesquisa.setP2(conteudo); // Define a avaliação do conteúdo
        pesquisa.setP3(organizacao); // Define a avaliação da organização
        pesquisa.setP4(suporte); // Define a avaliação do suporte
        pesquisa.setP5(desempenho); // Define a avaliação do desempenho

        // Instancia a classe DAO para acessar o banco de dados
        PesquisaDAO pesquisaDao = new PesquisaDAO();

        // Verifica se a pesquisa foi alterada com sucesso no banco de dados
        if(pesquisaDao.alterarPesquisa(pesquisa)){
            // Mensagem exibida em caso de sucesso
            out.println("<p>Pesquisa alterado com sucesso!!!</p></div>");
        } else {
            // Mensagem exibida em caso de falha
            out.println("<p class='resultado'>Erro! Pesquisa não realizada!!!</p>");
        }
    %>
    </div>  
</body>
</html>
