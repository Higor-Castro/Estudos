<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Cadastro"%>
<%@page import="model.dao.CadastroDAO"%>
<!DOCTYPE html>
<html>
    <head>
        <!-- Configura o tipo de conteúdo e o charset -->
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Importa o CSS para estilização -->
        <link rel="stylesheet" href="../../css/cadastro.css">
        <title>DIO.me</title>
    </head>
    <body>
        <!-- Barra de navegação com o título do portal -->
        <div class="navbar">
            <h1>Portal Colaborador DIO.me</h1>
            <div class="navbar-buttons">
                <a href="../../../index.html">Portal DIO.me</a>
            </div>
        </div>
        
        <!-- Container principal da página -->
        <div class="container">
<%
        // Recebe o CPF enviado pelo formulário anterior como parâmetro HTTP
        String cpf = request.getParameter("cpf");
            
        // Cria uma instância da classe Cadastro e atribui o valor do CPF
        Cadastro cadastro = new Cadastro();
        cadastro.setCpf(cpf); // Define o CPF no objeto cadastro
        
        // Instancia a classe CadastroDAO para consultar o banco de dados
        CadastroDAO cadastroDAO = new CadastroDAO();
        
        // Verifica se existe um cadastro associado ao CPF
        if(cadastroDAO.consultaCadastro(cadastro) != null){
                // Caso o CPF seja encontrado, exibe o formulário para alterar os dados
                out.println("<div class='container__titulo'><h1>Alteração Cadastro</h1>");
                out.println("<p>Preencha seus dados</p></div>");
 %>   
<!-- Formulário para alteração de cadastro -->
<form method="post" action="alterarCadastro.jsp" class="formulario">
    <!-- Campo para alterar o nome -->
    <div class="form-group">
        <label for="nome">Nome:</label>
        <input type="text" id="nome" name="nome" placeholder="Nome Completo" value="<%= cadastro.getNome() %>" required>
    </div>

    <!-- Campo para alterar o telefone -->
    <div class="form-group">
        <label for="telefone">Telefone:</label>
        <input type="text" id="telefone" name="telefone" placeholder="+55 1192222-2222" required maxlength="15" 
               value="<%= cadastro.getTelefone() %>">
    </div>

    <!-- Campo para alterar o email -->
    <div class="form-group">
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" placeholder="teste@gmail.com" value="<%= cadastro.getEmail() %>" required>
    </div>

    <!-- Campo para alterar a senha -->
    <div class="form-group">
        <label for="senha">Senha:</label>
        <input type="password" id="senha" name="senha" placeholder="Senha" value="<%= cadastro.getSenha() %>" required>
    </div>

    <!-- Campo para exibir o CPF (não pode ser alterado) -->
    <div class="form-group">
        <label for="cpf">CPF:</label>
        <input type="text" id="cpf" name="cpf" placeholder="Digite seu CPF" value="<%= cadastro.getCpf() %>" 
               required maxlength="11" pattern="\d{11}" readonly title="O CPF não pode ser alterado.">
    </div>

    <!-- Botão para submeter as alterações -->
    <input type="submit" value="Alterar Cadastro">
</form>

<%
        } else {
               // Caso o CPF não seja encontrado, exibe uma mensagem de erro
               out.println("<h2> CPF não encontrado!!!</h2>");
        }
 %>
        </div>   
    </body>
</html>
