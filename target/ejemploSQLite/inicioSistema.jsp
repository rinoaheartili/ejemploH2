<%-- 
    Document   : inicioSistema
    Created on : 28 jun 2024, 12:58:22
    Author     : alberto
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inicio Sistema</title>
    </head>
    <body>
        <%@ page import="com.controller.Registro" %>
        <% String nombre = (String) request.getAttribute("nombre"); %>
        <h1> Hola <%= nombre %> bienvenido al sistema! </h1>
        <br>
        <form action="muestraEmpleados" method="post">
            <input type="submit" value="Consultar Usuarios">
        </form>
        <br>
        <form action="llenaRegistro.jsp" method="post">
            <input type="submit" value="Agregar un Usuario">
        </form>
        <br>
        <form action="capturaBorrado.jsp" method="post">
            <input type="submit" value="Borrar un usuario">
        </form>
        <br>
        <form action="index.jsp" method="post">
            <input type="submit" value="Salir">
        </form>
    </body>
</html>
