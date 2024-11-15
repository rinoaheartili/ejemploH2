<%-- 
    Document   : index
    Created on : 26 jun 2024, 9:18:55
    Author     : alberto
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%String context = request.getContextPath(); %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ingreso al sistema</title>
    </head>
    <body>
        <h1>Bienvenido al sistema login</h1>
        <%@ page import="com.controller.Login" %>
        <form name="login" method="post" action="<%=context %>/login">
            Username: <input type="text" name="nombre"/> <br/>
            Password: <input type="password" name="contrasenia"/> <br/>
            <input type="reset" value="Borrar"/>
            <input type="submit" value="Ingresar"/>
            <!--<input type="submit" value="Registrar">-->
        </form>
        
        <form action="llenaRegistro.jsp" method="post">
            <input type="submit" value="Registrar">
        </form>
        
    </body>
</html>
