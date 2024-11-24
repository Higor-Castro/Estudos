<%-- 
    Document   : cadastro de equipamento
    Created on : 20 de ago. de 2024, 20:50:29
    Author     : Henrique e Higor 
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%//Entrada 
            int id= Integer.parseInt(request.getParameter("id"));
            String equip= request.getParameter("eq");
            String marca = request.getParameter("mar");
            float valor = Float.parseFloat(request.getParameter("vr"));
            
            //Processamento
            float parcelas = valor/10;
            if (valor >= 5000){
            out.println("<br> Equipametno com valor especial");
            }
            else{
            out.println("<br> Equipametno com desconto!");
            }
            
            //Saida
            out.println("<br> <b>Indentificador:</b>"+id);
            out.println("<br> <b>Equipamento:</b>"+equip);
            out.println("<br> <b>Marca:</b>"+marca);
            out.println("<br> <b>valor:</b>"+valor);
            
            %>
            
    </body>
</html>
