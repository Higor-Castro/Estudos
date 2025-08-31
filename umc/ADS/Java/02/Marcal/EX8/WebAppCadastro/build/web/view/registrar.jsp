<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Usuario"%>
<%@page import="model.dao.CadastroDAO"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="cadastro.css">
        <title>Cadastro DIO</title>
    </head>
    <body>
     <div class="navbar">
        <h1>DIO.me</h1>
        <div class="navbar-buttons">
            <a href="../index.html">Entrar</a>
            <a href="./index.html">Cadastrar</a>
        </div>
    </div>
        
        
<%
    // Captura os parâmetros de entrada enviados pelo formulário HTML (nome, telefone, email, senha, cpf)
    String nome = request.getParameter("nome");
    String telefone = request.getParameter("telefone");
    String email = request.getParameter("email");
    String senha = request.getParameter("senha");
    String cpf = request.getParameter("cpf");
    
    // Cria uma nova instância da classe Usuario e define os valores capturados nos campos do formulário
    Usuario usuario = new Usuario();
    usuario.setNome(nome);           // Atribui o nome
    usuario.setTelefone(telefone);   // Atribui o telefone
    usuario.setEmail(email);         // Atribui o email
    usuario.setSenha(senha);         // Atribui a senha
    usuario.setCpf(cpf);             // Atribui o CPF
    
    // Cria uma nova instância de CadastroDAO para realizar a operação de inserção no banco
    CadastroDAO cadastroDAO = new CadastroDAO();
    
    // Verifica se o cadastro foi realizado com sucesso
    if(cadastroDAO.consultar(usuario)){
        // Se o cadastro for bem-sucedido, imprime uma mensagem de sucesso
        out.println("<p>Cadastro Realizado com sucesso!</p>");
    }else{
        // Se ocorrer um erro no cadastro, imprime uma mensagem de erro
        out.println("<p>Erro! Cadastro não realizado!!!</p>");
    }
%>

    </body>
</html>
