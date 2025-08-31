<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="model.Produto"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Resultado Produto</title>
        <style>
            table {
                border-collapse: collapse;
                margin-top: 20px;
                width: 50%;
            }
            th, td {
                border: 1px solid #333;
                padding: 8px;
                text-align: left;
            }
            th {
                background-color: #f2f2f2;
            }
            h1 {
                color: #333;
            }
        </style>
    </head>
    <body>
        <% 
            String msg = (String) request.getAttribute("msg");
            Produto produto = (Produto) request.getAttribute("produto");
            List<Produto> lista = (List<Produto>) request.getAttribute("listaProdutos");
        %>

        <h1>Resultado Manter Produto: <%= msg %></h1>

        <%-- Exibe quando for consulta individual --%>
        <%
            if (produto != null) {
        %>
            <h2>Produto encontrado:</h2>
            <p><b>ID:</b> <%= produto.getId() %></p>
            <p><b>Descrição:</b> <%= produto.getDescricao() %></p>
            <p><b>Preço:</b> R$ <%= produto.getPreco() %></p>
        <%
            }
        %>

        <%-- Exibe quando for listagem --%>
        <%
            if (lista != null && !lista.isEmpty()) {
        %>
            <h2>Lista de Produtos:</h2>
            <table>
                <tr>
                    <th>ID</th>
                    <th>Descrição</th>
                    <th>Preço</th>
                </tr>
                <% for (Produto p : lista) { %>
                    <tr>
                        <td><%= p.getId() %></td>
                        <td><%= p.getDescricao() %></td>
                        <td>R$ <%= p.getPreco() %></td>
                    </tr>
                <% } %>
            </table>
        <%
            }
        %>
    </body>
</html>
