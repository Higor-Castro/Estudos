<%-- 
    Document   : resultadocosultarbyid
    Created on : 22/05/2023, 10:01:24
    Author     : PTOLEDO
--%>

<%@page import="model.Produto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Resultado Cosultar By ID</title>
    </head>
    <body>
        <h1>Resultado Consultar By ID</h1>
        <%Produto p = (Produto) request.getAttribute("p");%>
        <%if (p.getDescricao() != null) {%>
        ID..........: <%=p.getId()%> <BR>
        Descrição...: <%=p.getDescricao()%> <BR>
        Preço.......: <%=p.getPreco()%> <BR>
        <%} else {%>
        <h2>Produto não encontrado.</h2>
        <%}%>
    </body>
</html>
