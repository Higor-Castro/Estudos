<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<%@page import="java.util.*"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Processar Meta</title>
    <link rel="stylesheet" href="../../css/style.css">
</head>
<body>

    <h2>Resultado do Processo</h2>
<%String msg = (String) request.getAttribute("msg");%>
    <p> <%out.print(msg);%> </p>
    <p> ooasd</p>
    


</body>
</html>
