<%-- 
    Document   : capturaBorrado.jsp
    Created on : 28 jun 2024, 12:01:15
    Author     : alberto
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Captura para Borrar</title>
    </head>
    <body>
        <%@ page import="com.controller.BorrarUsuario" %>
        <h3> Datos del usuario a borrar</h3>
        <form action="borraUsuario" method="post">
            <table cellspacing="3" cellpadding="3" border="1" >
                <tr>
                    <td align="right"> Nombre: </td>
                    <td><input type="text" name="nombre"></td>
                </tr>
                <tr>
                    <td align="right"> Contraseña: </td>
                    <td><input type="text" name="contrasenia"></td>
                </tr>
            </table>
            <input type="reset" value="Borrar">
            <input type="submit" value="Borrar usuario">
        </form>
        <form action="index.jsp" method="post">
            <input type="submit" value="Regresar">
        </form>
    </body>
</html>
