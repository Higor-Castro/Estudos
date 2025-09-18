<%-- 
    Document   : resultadoconsultarbyid
    Created on : 19 de set. de 2024, 21:13:57
    Author     : ptoledo
--%>

<%@page import="model.Produto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Resultado Consultar By Id</title>
    </head>
    <body>
        <h1>Resultado Consultar By Id</h1>
        <h2>
            <%Produto prod = (Produto) request.getAttribute("prod");%>

            <%
                if (prod.getDescricao() != null) {
            %>
            ID..............: <%out.println(prod.getId());%><BR>
            Descrição..: <%out.println(prod.getDescricao());%><BR>
            Preço.........: <%out.println(prod.getPreco());%><BR>
            <%} else {%>
            ID NÃO ENCONTRADO
            <%}%>
        </h2>
    </body>
</html>
