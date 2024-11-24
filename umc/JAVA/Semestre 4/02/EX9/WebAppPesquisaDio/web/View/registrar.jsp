<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Cadastro"%>
<%@page import="modelDAO.PesquisaDao"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Resultado da Pesquisa</title>
</head>
<body>
    <h1>Resultado da Pesquisa</h1>
    <%
        // Captura as respostas como inteiros
        int satisfeito = Integer.parseInt(request.getParameter("satisfeito"));
        int recomendaria = Integer.parseInt(request.getParameter("recomendaria"));
        int informacoes = Integer.parseInt(request.getParameter("informacoes"));
        int seguro = Integer.parseInt(request.getParameter("seguro"));
        int novosRecursos = Integer.parseInt(request.getParameter("novos_recurso"));

        // Cria uma nova instância da classe Cadastro e define os valores
        Cadastro cadastro = new Cadastro();
        cadastro.setSatisfeito(satisfeito);
        cadastro.setRecomendaria(recomendaria);
        cadastro.setInformacoes(informacoes);
        cadastro.setSeguro(seguro);
        cadastro.setNovos_recursos(novosRecursos);

        // Cria uma nova instância de PesquisaDao para realizar a operação de inserção no banco
        PesquisaDao pesquisaDao = new PesquisaDao();

        // Verifica se o cadastro foi realizado com sucesso
        if(pesquisaDao.consultar(cadastro)){
            // Se o cadastro for bem-sucedido, imprime uma mensagem de sucesso
            out.println("<p>Pesquisa realizada com sucesso!</p>");
        } else {
            // Se ocorrer um erro no cadastro, imprime uma mensagem de erro
            out.println("<p>Erro! Pesquisa não realizada!!!</p>");
        }
    
    %>
</body>
</html>
