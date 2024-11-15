<%-- 
    Document   : listaUsuarios
    Created on : 28 jun 2024, 13:23:48
    Author     : alberto
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado de Usuarios</title>
    </head>
    <body>
        <%@ page import="com.modelo.Empleado, java.util.ArrayList" %>
        <h2>Los usuarios que están registrados son: </h2>
        <% 
            ArrayList<Empleado> empleados = null;
            empleados = (ArrayList<Empleado>)request.getAttribute("Empleados");
        %>
        <table border="1">
            <tr>
                <th>Id</th>
                <th>Nombre</th>
                <th>Apellido Paterno</th>
                <th>Apellido Materno</th>
                <th>Contraseña</th>
                <th>Cargo</th>
            </tr>
            <%
                for (Empleado empleado: empleados)
                {
            %>
            <tr valign="rigth">
                <td><%=empleado.getId() %></td>
                <td><%=empleado.getNombre() %></td>
                <td><%=empleado.getApellidoPa() %></td>
                <td><%=empleado.getApellidoMa() %></td>
                <td><%=empleado.getContrasenia() %></td>
                <td><%=empleado.getCargo() %></td>
            </tr>
            <% } %>
        </table>
        <br>
        <form action="inicioSistema.jsp" method="post">
            <input type="submit" value="Regresar">
        </form>
    </body>
</html>
