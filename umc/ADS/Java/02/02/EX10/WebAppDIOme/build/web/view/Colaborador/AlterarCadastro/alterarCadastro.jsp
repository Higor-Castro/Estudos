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
        // Captura os parâmetros enviados pelo formulário HTML através do método HTTP (POST ou GET)
        String nome = request.getParameter("nome");       // Recebe o valor do campo 'nome'
        String telefone = request.getParameter("telefone"); // Recebe o valor do campo 'telefone'
        String email = request.getParameter("email");     // Recebe o valor do campo 'email'
        String senha = request.getParameter("senha");     // Recebe o valor do campo 'senha'
        String cpf = request.getParameter("cpf");         // Recebe o valor do campo 'cpf'

        // Cria uma nova instância da classe Cadastro e atribui os valores recebidos
        Cadastro cadastro = new Cadastro();
        cadastro.setNome(nome);           // Define o nome no objeto Cadastro
        cadastro.setTelefone(telefone);   // Define o telefone no objeto Cadastro
        cadastro.setEmail(email);         // Define o email no objeto Cadastro
        cadastro.setSenha(senha);         // Define a senha no objeto Cadastro
        cadastro.setCpf(cpf);             // Define o CPF no objeto Cadastro
       
        // Instancia o CadastroDAO para realizar operações no banco de dados
        CadastroDAO cadastroDAO = new CadastroDAO();

        // Verifica se o método de alteração (update) foi bem-sucedido
        if(cadastroDAO.alterarCadastro(cadastro)){
                // Caso o cadastro seja alterado com sucesso, exibe uma mensagem ao usuário
                out.println("<p>Cadastro Alterado com sucesso!!</p>");
        } else {
                // Caso contrário, informa que o CPF não foi encontrado
                out.println("<h2> CPF não encontrado!!!</h2>");
        }
 %>
        </div>   
    </body>
</html>
