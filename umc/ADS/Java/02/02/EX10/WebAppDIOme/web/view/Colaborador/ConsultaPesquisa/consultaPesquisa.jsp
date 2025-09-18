<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Pesquisa"%>
<%@page import="model.dao.PesquisaDAO"%>
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
            
        // Instancia um objeto da classe Pesquisa e define o CPF recebido
        Pesquisa pesquisa = new Pesquisa();
        pesquisa.setCpf(cpf);
        
        // Instancia o DAO de Pesquisa para buscar as respostas no banco de dados
        PesquisaDAO pesquisaDAO = new PesquisaDAO();

        // Verifica se a pesquisa foi encontrada no banco de dados
        if (pesquisaDAO.consultaPesquisa(pesquisa) != null) {
            // Caso a pesquisa seja encontrada, exibe os dados
            out.println("<h2>Pesquisa de Satisfação</h2><ul>");
            out.println("<li> Nome: " + pesquisa.getNome() + "</li>");
            out.println("<li> CPF: " + pesquisa.getCpf() + "</li>");
            out.println("<li> Pergunta 1: " + pesquisa.getP1() + "</li>");
            out.println("<li> Pergunta 2: " + pesquisa.getP2() + "</li>");
            out.println("<li> Pergunta 3: " + pesquisa.getP3() + "</li>");
            out.println("<li> Pergunta 4: " + pesquisa.getP4() + "</li>");
            out.println("<li> Pergunta 5: " + pesquisa.getP5() + "</li> <br> ");

            // Exibe a escala de satisfação utilizada nas perguntas
            out.println("<h3>Escala de Satisfação:</h3>");
            out.println("<li>1: 😠 Muito Insatisfeito</li>"); 
            out.println("<li>2: 🙁 Pouco Insatisfeito</li>"); 
            out.println("<li>3: 😐 Neutro</li>"); 
            out.println("<li>4: 🙂 Pouco Satisfeito</li>"); 
            out.println("<li>5: 😍 Muito Satisfeito</li> </ul>"); 
        } else {
            // Caso o CPF não seja encontrado, exibe uma mensagem de erro
            out.println("<h2> CPF não encontrado!!!</h2>");
        }
 %>           
        </div>   
    </body>
</html>
