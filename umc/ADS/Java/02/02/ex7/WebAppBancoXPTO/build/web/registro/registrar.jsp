<%-- 
    Document   : registrar
    Created on : 25 de set. de 2024, 21:20:49
    Author     : alunocmc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Usuario"%>
<%@page import="model.dao.UsuarioDAO"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro</title>
    </head>
    <body>
        <h1>Registro</h1>
        <%
        //Entrada
        String login = request.getParameter("login");
        String fone = request.getParameter("fone");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        
        // Instância e atrib de valor
        Usuario usu = new Usuario();
        usu.setLogin(login);
        usu.setFone(fone);
        usu.setEmail(email);
        usu.setSenha(senha);
        
        UsuarioDAO usuDAO = new UsuarioDAO();
        if(usuDAO.insUsu(usu)){
            out.println("Registro inserido com sucesso!");
        }else{
           out.println("Erro! Registro não inserido!!!");
        }


        %>
    </body>
</html>
