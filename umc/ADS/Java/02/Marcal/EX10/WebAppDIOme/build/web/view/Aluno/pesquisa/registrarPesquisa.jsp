<%@page contentType="text/html" pageEncoding="UTF-8"%> <!-- Define o tipo de conteúdo e a codificação da página -->
<%@page import="model.Pesquisa"%> <!-- Importa a classe Pesquisa -->
<%@page import="model.dao.PesquisaDAO"%> <!-- Importa a classe PesquisaDAO -->

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> <!-- Define a codificação de caracteres para UTF-8 -->
    <link rel="stylesheet" href="../../css/style.css"> <!-- Link para o arquivo de estilo CSS -->
    <title>DIO.me</title> <!-- Título da página -->
</head>
<body>
    <!-- Barra de navegação -->
    <div class="navbar">
        <h1>Portal do Aluno DIO.me</h1> <!-- Título do portal -->
        <div class="navbar-buttons">
            <a href="../../../index.html">Portal DIO.me</a> <!-- Link para o portal principal -->
        </div>
    </div>
    <%
        // Captura os parâmetros enviados pelo formulário
        String cpf = request.getParameter("cpf");  // CPF do aluno
        // Converte as respostas de cada pergunta para inteiros
        int navegacao = Integer.parseInt(request.getParameter("navegacao"));
        int conteudo = Integer.parseInt(request.getParameter("conteudo"));
        int organizacao = Integer.parseInt(request.getParameter("organizacao"));
        int suporte = Integer.parseInt(request.getParameter("suporte"));
        int desempenho = Integer.parseInt(request.getParameter("desempenho"));

        // Criação de uma nova instância da classe Pesquisa e atribuição dos valores coletados
        Pesquisa pesquisa  = new Pesquisa();
        pesquisa.setCpf(cpf);  // Define o CPF do aluno
        pesquisa.setP1(navegacao);  // Define a resposta da pergunta sobre navegação
        pesquisa.setP2(conteudo);  // Define a resposta da pergunta sobre conteúdo
        pesquisa.setP3(organizacao);  // Define a resposta da pergunta sobre organização
        pesquisa.setP4(suporte);  // Define a resposta da pergunta sobre suporte
        pesquisa.setP5(desempenho);  // Define a resposta da pergunta sobre desempenho

        // Cria uma nova instância de PesquisaDAO para interagir com o banco de dados
        PesquisaDAO pesquisaDao = new PesquisaDAO();

        // Verifica se a pesquisa foi registrada com sucesso no banco de dados
        if(pesquisaDao.consultar(pesquisa)){
            // Se a operação for bem-sucedida, exibe uma mensagem de sucesso
            out.println("<p class='resultado'>Pesquisa realizada com sucesso!</p>");
        } else {
            // Se houver um erro, exibe uma mensagem de falha
            out.println("<p class='resultado'>Erro! Pesquisa não realizada!!!</p>");
        }
    %>
</body>
</html>
