<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>Resultado do Processo</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <h2>Resultado do Processo</h2>
    <p><%= request.getAttribute("msg") %></p>
</body>
</html>
