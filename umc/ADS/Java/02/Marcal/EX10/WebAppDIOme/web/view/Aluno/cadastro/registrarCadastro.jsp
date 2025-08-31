<%@page contentType="text/html" pageEncoding="UTF-8"%> <!-- Define o tipo de conteúdo da página e a codificação para UTF-8 -->
<%@page import="model.Cadastro"%> <!-- Importa a classe Cadastro -->
<%@page import="model.dao.CadastroDAO"%> <!-- Importa a classe CadastroDAO -->

<!DOCTYPE html>
<html>
    <head>
        <!-- Define a codificação da página para UTF-8 -->
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Link para o arquivo de estilo CSS -->
        <link rel="stylesheet" href="../../css/style.css">
        <title>DIO.me</title> <!-- Título da página -->
    </head>
    <body>
     <!-- Barra de navegação -->
     <div class="navbar">
        <h1>Portal do Aluno DIO.me</h1> <!-- Título do portal -->
        <div class="navbar-buttons">
            <a href="../../../index.html">Portal DIO.me</a> <!-- Link para a página principal -->
        </div>
    </div>
        
<%
    // Captura os parâmetros de entrada enviados pelo formulário HTML
    String nome = request.getParameter("nome");
    String telefone = request.getParameter("telefone");
    String email = request.getParameter("email");
    String senha = request.getParameter("senha");
    String cpf = request.getParameter("cpf");
    
    // Cria uma nova instância da classe Cadastro e atribui os valores dos parâmetros recebidos
    Cadastro usuario = new Cadastro();
    usuario.setNome(nome);           // Atribui o nome
    usuario.setTelefone(telefone);   // Atribui o telefone
    usuario.setEmail(email);         // Atribui o email
    usuario.setSenha(senha);         // Atribui a senha
    usuario.setCpf(cpf);             // Atribui o CPF
    
    // Cria uma nova instância de CadastroDAO para realizar a operação de consulta no banco
    CadastroDAO cadastroDAO = new CadastroDAO(); 
    
    // Verifica se o cadastro já existe no banco de dados
    if(cadastroDAO.consultar(usuario)){
        // Se o cadastro for encontrado, exibe uma mensagem de sucesso
        out.println("<p class='resultado'>Cadastro Realizado com sucesso!</p>");
    }else{
        // Se o cadastro não for encontrado, exibe uma mensagem de erro
        out.println("<p class='resultado'>Erro! Cadastro não realizado!!!</p>");
    }
%>

    </body>
</html>
