<%-- 
    Document   : formeditar
    Created on : 26 de set. de 2024, 20:11:53
    Author     : ptoledo
--%>

<%@page import="model.Produto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulário Editar</title>
    </head>
    <body>
        <h1>Formulário Editar</h1>
        <h2>
            <%Produto prod = (Produto) request.getAttribute("prod");%>

            <%
                if (prod.getDescricao() != null) {
            %>

            <form action="ManterProduto" method="GET">
                ID..............: <input type="text" name="txtid" readonly value="<%out.println(prod.getId());%>"><BR>
                Descrição..:<input type="text" name="txtdescricao" value="<%out.println(prod.getDescricao());%>"><BR>
                Preço.........:<input type="text" name="txtpreco" value="<%out.println(prod.getPreco());%>"><BR>
                Quantidade..............: <input type="text" name="txtQuantidade" readonly value="<%out.println(prod.getQuantidade());%>"><BR>
                <input type="submit" name="btnop" value="ATUALIZAR">
                <%} else {%>
                ID NÃO ENCONTRADO
                <%}%>
            </form>

        </h2>
    </body>
</html>
