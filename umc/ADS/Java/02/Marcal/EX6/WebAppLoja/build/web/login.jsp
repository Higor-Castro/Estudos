<%-- 
    Document   : login
    Created on : 18 de set. de 2024, 21:43:47
    Author     : alunocmc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="control.ControleUsuario"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Login</h1>
        <%
            String login = request.getParameter("login");
            String password = request.getParameter("pw");
            
            ControleUsuario ctrlUsu = new ControleUsuario();
            
            if (ctrlUsu.logar(login, password)){
                out.println("Acesso PERMITIDO!!!" + login);
            }else{
                out.println("Acesso NEGADO!!!");
            }           

        %>
    </body>
</html>
