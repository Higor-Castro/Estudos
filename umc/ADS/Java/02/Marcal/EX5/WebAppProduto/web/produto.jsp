<%-- 
    Document   :Controle dos Produtod
    Created on : 4 de set. de 2024, 20:08:45
    Author     : Que se dane 
--%>

<%@page contentType="text/html" import ="java.util.*,java.lang.*, java.text.*" pageEncoding="UTF-8"%>
<%@page import="dados.Produtos"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Controle dos Produtos</title>
    </head>
    <body>
        <h1>Produtos</h1>
        <%
        //Instacia do objeto
        Produtos prod = new Produtos();
        //Atributo de valor
        prod.setId(Integer.parseInt(request.getParameter("id")));
        prod.setNome(request.getParameter("pr"));
        prod.setValor(Float.parseFloat(request.getParameter("vr")));
        
        //Processamento
        //float desconto = prod.getValor() * 10/100;  
        //Saida
        out.println("<br> <b>Indentificador: </b>"+prod.getId());
        out.println("<br> <b>Produto...........: </b>"+prod.getNome());
        out.println("<br> <b>Valor.............: </b>"+prod.getValor());
        
        out.println("<br> <b>Desconto.............: </b>"+ prod.calcDesc(prod.getValor()));
        out.println("<br> <b>Com Desconto.............: </b>"+ (prod.getValor()- prod.calcDesc(prod.getValor())));
        out.println("<br> <b>Juros.............: </b>"+ prod.calcJuros(prod.getValor()));
         out.println("<br> <b>Com Desconto.............: </b>"+ (prod.getValor()+ prod.calcDesc(prod.getValor())));
       
        %>
       
        
    </body>
</html>
