<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Cadastro"%> <!-- Importa a classe Cadastro -->
<%@page import="model.dao.CadastroDAO"%> <!-- Importa a classe CadastroDAO -->
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
        // Recebe o CPF enviado via formulário ou URL
        String cpf = request.getParameter("cpf");
            
        // Instancia um objeto da classe Cadastro e define o CPF recebido
        Cadastro cadastro = new Cadastro();
        cadastro.setCpf(cpf);
        
        // Instancia o DAO de Cadastro para realizar a exclusão no banco de dados
        CadastroDAO cadastroDAO = new CadastroDAO();

        // Verifica se a exclusão foi bem-sucedida
        if (cadastroDAO.excluirCadastro(cadastro)) {
            // Caso a exclusão seja realizada com sucesso, exibe a mensagem de sucesso
            out.println("<h2>Cadastro do aluno excluído com sucesso </h2><ul>");
        } else {
            // Caso o CPF não seja encontrado no banco de dados, exibe uma mensagem de erro
            out.println("<h2> CPF não encontrado!!!</h2>");
        }
 %>           
        </div>   
    </body>
</html>
