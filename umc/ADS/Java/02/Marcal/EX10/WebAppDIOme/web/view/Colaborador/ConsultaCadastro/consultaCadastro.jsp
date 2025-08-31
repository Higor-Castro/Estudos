<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Cadastro"%>
<%@page import="model.dao.CadastroDAO"%>
<!DOCTYPE html>
<html>
    <head>
        <!-- Define o tipo de conteúdo e o charset da página -->
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Vincula o arquivo CSS para estilização -->
        <link rel="stylesheet" href="../../css/style.css">
        <title>DIO.me</title> <!-- Título da página -->
    </head>
    <body>
        <!-- Barra de navegação -->
        <div class="navbar">
            <h1>Portal Colaborador DIO.me</h1> <!-- Título principal do portal -->
            <div class="navbar-buttons">
                <a href="../../../index.html">Portal DIO.me</a> <!-- Link para o portal principal -->
            </div>
        </div>
        
        <!-- Área principal do conteúdo -->
        <div class="main">
<%
        // Captura o CPF enviado como parâmetro através do formulário ou URL
        String cpf = request.getParameter("cpf");
            
        // Instancia um objeto da classe Cadastro e define o CPF capturado
        Cadastro cadastro = new Cadastro();
        cadastro.setCpf(cpf);
        
        // Instancia o DAO de Cadastro para buscar os dados no banco
        CadastroDAO cadastroDAO = new CadastroDAO();

        // Verifica se o CPF existe no banco de dados
        if (cadastroDAO.consultaCadastro(cadastro) != null) {
            // Exibe os dados do cadastro se encontrado
            out.println("<h2>Resultado Cadastro</h2><ul>");
            out.println("<li> Nome: " + cadastro.getNome() + "</li>");
            out.println("<li> CPF: " + cadastro.getCpf() + "</li>");
            out.println("<li> Email: " + cadastro.getEmail() + "</li>");
            out.println("<li> Telefone: " + cadastro.getTelefone() + "</li>");
        } else {
            // Exibe uma mensagem de erro se o CPF não for encontrado
            out.println("<h2> CPF não encontrado!!!</h2>");
        }
 %>           
        </div>   
    </body>
</html>
