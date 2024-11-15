<%-- 
    Document   : registroGuardado
    Created on : 28 jun 2024, 12:48:05
    Author     : alberto
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro Guardado</title>
    </head>
    <body>
        <%@ page import="com.modelo.Empleado" %>
        <%
            String id = request.getParameter("id");
            String nombre = request.getParameter("nombre");
            String apellidoPa = request.getParameter("apePaterno");
            String apellidoMa = request.getParameter("apeMaterno");
            String contrasenia = request.getParameter("contrasenia");
            String cargo = request.getParameter("cargo");
        %>
        <h1>Registro exitoso en la base de datos</h1>
        <p>Se guardaron los siguientes datos: </p>
        <table cellspacing="3" cellpadding="3" border="1" >
            <tr>
                <td align="right"> Id: </td>
                <td> <%= id %> </td>
            </tr>
            <tr>
                <td align="right"> Nombre: </td>
                <td> <%= nombre %> </td>
            </tr>
            <tr>
                <td align="right"> Apellido Paterno: </td>
                <td> <%= apellidoPa %> </td>
            </tr>
            <tr>
                <td align="right"> Apellido Materno: </td>
                <td> <%= apellidoMa %> </td>
            </tr>
            <tr>
                <td align="right"> Contrasenia: </td>
                <td> <%= contrasenia %> </td>
            </tr>
            <tr>
                <td align="right"> Cargo: </td>
                <td> <%= cargo %> </td>
            </tr>
        </table>
        <form action="index.jsp" method="post">
            <input type="submit" value="Regresar">
        </form>
    </body>
</html>
