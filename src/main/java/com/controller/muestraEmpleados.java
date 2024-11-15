/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.controller;

import com.dao.EmpleadoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.modelo.Empleado;
import java.sql.SQLException;
import java.util.logging.Logger;

/**
 *
 * @author alberto
 */
@WebServlet(name = "muestraEmpleados", urlPatterns = {"/muestraEmpleados"})
public class muestraEmpleados extends HttpServlet
{
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            ArrayList <Empleado> empleados = new ArrayList<Empleado>();
            Empleado empleado;
            EmpleadoDAO empleadoBD = new EmpleadoDAO();

            empleados = empleadoBD.leeTodos();
            if (empleados != null){
                request.setAttribute("Empleados", empleados);
                request.getRequestDispatcher("/listaEmpleados.jsp").forward(request, response);
            }else
                request.getRequestDispatcher("/noHayRegistros.jsp").forward(request, response);
            } finally {
                out.close();
        }
    
    }
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        Logger logger = Logger.getLogger(Login.class.getName());
                
        try {
            this.processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ex.getMessage());
        }
    }
    
}
