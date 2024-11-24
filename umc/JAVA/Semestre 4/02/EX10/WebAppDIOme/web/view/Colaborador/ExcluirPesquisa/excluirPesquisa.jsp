<%@page contentType="text/html" pageEncoding="UTF-8"%> <!-- Define o tipo de conteúdo e codificação de caracteres -->
<%@page import="model.Pesquisa"%> <!-- Importa a classe Pesquisa -->
<%@page import="model.dao.PesquisaDAO"%> <!-- Importa a classe PesquisaDAO -->
<!DOCTYPE html>
<html>
    <head>
        <!-- Define o charset da página como UTF-8 -->
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Link para o arquivo de estilo CSS -->
        <link rel="stylesheet" href="../../css/style.css">
        <title>Dio.me</title> <!-- Define o título da página -->
    </head>
    <body>
        <!-- Barra de navegação -->
        <div class="navbar">
            <h1>Portal Colaborador DIO.me</h1> <!-- Título do portal -->
            <div class="navbar-buttons">
                <a href="../../../index.html">Portal DIO.me</a> <!-- Link para a página principal do portal -->
            </div>
        </div>
        
        <!-- Conteúdo principal da página -->
        <div class="main">
<%
        // Recebe o CPF da requisição HTTP
        String cpf = request.getParameter("cpf");
            
        // Cria uma nova instância de Pesquisa e atribui o CPF recebido
        Pesquisa pesquisa = new Pesquisa();
        pesquisa.setCpf(cpf);
        
        // Instancia o DAO de Pesquisa para realizar a exclusão no banco de dados
        PesquisaDAO pesquisaDAO = new PesquisaDAO();

        // Tenta excluir a pesquisa no banco de dados
        if(pesquisaDAO.excluirPesquisa(pesquisa)){
            // Se a exclusão for bem-sucedida, exibe uma mensagem de sucesso
            out.println("<h2>Pesquisa Excluída com Sucesso!!</h2><ul>");
        } else {
            // Caso o CPF não seja encontrado no banco, exibe uma mensagem de erro
            out.println("<h2> CPF não encontrado!!!</h2>");
        }
 %>           
        </div>   
    </body>
</html>
