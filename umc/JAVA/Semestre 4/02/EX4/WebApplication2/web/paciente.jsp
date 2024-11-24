<%-- 
    Document   : Controle paciente
    Created on : 28 de ago. de 2024, 20:16:23
    Author     : Rikizin higuinho   
--%>

<%@page contentType="text/html" import="java.lang.*,java.text.*,java.util.*" pageEncoding="UTF-8"%>
<%@page import="Marcal.Pacientes" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Control de Pacientes </title>
    </head>
    <body>
        <h1>Pacientes</h1>
        <%
            //instacia do objeto
            Pacientes pac = new Pacientes();
            
            //Entrada
            pac.setId(Integer.parseInt (request.getParameter("id")));
            pac.setNome (request.getParameter("nome"));
            pac.setMens(Float.parseFloat(request.getParameter("mens")));
            
            //Processo
            float desconto = pac.getMens() * 10/100;
            
            
            //Saida 
            
            out.println("<br> <b> Identificador:</b>" + pac.getId());
            out.println("<br> <b> Nome.........:</b>" + pac.getNome());
            out.println("<br> <b> Mensalidade:</b>" + pac.getMens());
            out.println("<br> <b> Desconto:</b>" + desconto);
            out.println("<br> <b> Valor total com desconto:</b>" + (pac.getMens()-desconto));
        %>
    </body>
    
</html>
