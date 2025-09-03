<%-- 
    Document   : resultadoconsultartodos
    Created on : 22/05/2023, 10:40:19
    Author     : PTOLEDO
--%>

<%@page import="java.util.List"%>
<%@page import="model.Produto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Resultado Consultar Todos</title>
    </head>
    <body>
        <h1>Todos os Produtos</h1>
        <%List<Produto> lprod = (List<Produto>) request.getAttribute("lprod");%>
        <table border="1">
            <tr>
                <th>ID</th>
                <th>Descrição</th>
                <th>Preço</th>
                <th>Remover</th>
                <th>Editar</th>
            </tr>
            <%for (Produto p : lprod) {%>
            <tr>                
                <td><%=p.getId()%></td>
                <td><%=p.getDescricao()%></td>
                <td><%=p.getPreco()%></td>
                <td align="center"><a href="controle_produto?op=DELETAR&txtid=<%=p.getId()%>"><img src="images/lixeira01.png" width="25" height="25"></a></td>
                <td align="center"><a href="controle_produto?txtid=<%=p.getId()%>&txtdescricao=<%=p.getDescricao()%>&txtpreco=<%=p.getPreco()%>&op=ATUALIZAR" ><img src="images/editar01.png" width="25" height="25"></a></td>
            </tr>
            <%}%>
        </table>
    </body>
</html>
