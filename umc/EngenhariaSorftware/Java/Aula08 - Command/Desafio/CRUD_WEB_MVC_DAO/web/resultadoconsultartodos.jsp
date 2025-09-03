<%-- 
    Document   : resultadoconsultartodos
    Created on : 26 de set. de 2024, 21:38:17
    Author     : ptoledo
--%>

<%@page import="java.util.List"%>
<%@page import="model.Produto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Consultar Todos</title>
    </head>
    <h1>Resultado Consultar Todos</h1>
    <h2>
        <%List<Produto> lprod = (List<Produto>) request.getAttribute("lprod");%>

        <%
            for (Produto prod : lprod) {
        %>
        ID..............: <%out.println(prod.getId());%><BR>
        Descrição..: <%out.println(prod.getDescricao());%><BR>
        Preço.........: <%out.println(prod.getPreco());%><BR>
        Quantidade..............: <%out.println(prod.getQuantidade());%><BR>
        <%}%>
    </h2>
</html>
