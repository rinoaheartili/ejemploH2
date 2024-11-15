package com.controller;


import com.dao.EmpleadoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.logging.Logger; 
import com.modelo.Empleado;
import java.sql.SQLException;
import java.util.logging.Level;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author alberto
 */
@WebServlet(name = "login", urlPatterns={"/login"})
public class Login extends HttpServlet
{   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException
    {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String nombre = request.getParameter("nombre");
        String contrasenia = request.getParameter("contrasenia");
        try
        {
            Empleado empleado;
            EmpleadoDAO empleadoDAO = new EmpleadoDAO();
            
            empleado = empleadoDAO.consultar(nombre, contrasenia);
            
            if(empleado != null)
            {
                request.setAttribute("nombre", empleado.getNombre());
                request.getRequestDispatcher("/inicioSistema.jsp").forward(request, response);
            }else
            {
                request.getRequestDispatcher("/noEncontrado.jsp").forward(request, response);
            }
            
        }finally
        {
            out.close();
        }
    }
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        Logger logger = Logger.getLogger(Login.class.getName());
        logger.info("HOLA MUNDO");
        logger.info(request.getParameter("nombre"));
        logger.info(request.getParameter("contrasenia"));
        
        try {
            this.processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ex.getMessage());
        }
    }
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        
    }
    
}
