package com.dao;

import com.controller.Login;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Logger;
import javax.naming.NamingException;
import com.modelo.Empleado;
import com.persistencia.ConexionSQLite;
import java.sql.PreparedStatement;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author alberto
 */
public class EmpleadoDAO 
{
    Logger logger = Logger.getLogger(Login.class.getName());
    Connection conn = null;
    Statement stm=null;
    PreparedStatement creacionTablaSQL;
    PreparedStatement empleadoPrepareStatement;
    ResultSet empleadoResultSet;
    Empleado empleadoHallado;
    int id;
    String nombre, apellidoPa, apellidoMa, contrasenia, cargo;
    private ArrayList<Empleado> listEmpleados;
    

    public EmpleadoDAO() 
    {
        this.listEmpleados = new ArrayList<Empleado>();
    }
    
    public void crearTabla() throws SQLException
    {
        int creacionTabla = 0;
        String createTableSQL = "CREATE TABLE IF NOT EXISTS empleado (" +
                                "idEmpleado INT PRIMARY KEY, " +
                                "nombre VARCHAR(30) NOT NULL, " +
                                "apellidoPa VARCHAR(30) NOT NULL, " +
                                "apellidoMa VARCHAR(30) NOT NULL, " +
                                "contrasenia VARCHAR(30) NOT NULL, " +
                                "cargo VARCHAR(30) NOT NULL)";
        try
        {
            conn = ConexionSQLite.getConnection();
            stm = ConexionSQLite.getStatement();
            creacionTablaSQL = ConexionSQLite.getPreparedStatement(createTableSQL);
            creacionTabla = creacionTablaSQL.executeUpdate();
            //creacionTabla = ConexionSQLite.getResultSet(createTableSQL);
            
            if(creacionTabla != 0)
            {
                logger.info("Tabla Creada Exitosamente!!!!");
            }else
            {
                logger.info("Tabla ya creada");
            }
            
        }catch(ClassNotFoundException | SQLException | NamingException e)
        {
            logger.info(e.getMessage());
            logger.info("Ya se creo la tabla");
            
        }finally
        {
            logger.info("Cerrando conexión!!!");
            ConexionSQLite.Cerrar(conn);
            ConexionSQLite.Cerrar(stm);
        }
        
    }
    
    public boolean agregar(int id, String nombre, String apellidoPa, String apellidoMa, String contrasenia, String cargo) throws SQLException
    {
        int resultUpdate = 0;
        String insertSQL = "INSERT INTO empleado (idEmpleado, nombre, apellidoPa, apellidoMa, contrasenia, cargo) VALUES (?, ?, ?, ?, ?, ?)";
        try{
            this.crearTabla();
            conn = ConexionSQLite.getConnection();
            stm = ConexionSQLite.getStatement();
            empleadoPrepareStatement = ConexionSQLite.getPreparedStatement(insertSQL);
            empleadoPrepareStatement.setInt(1, id);
            empleadoPrepareStatement.setString(2, nombre);
            empleadoPrepareStatement.setString(3, apellidoPa);
            empleadoPrepareStatement.setString(4, apellidoMa);
            empleadoPrepareStatement.setString(5, contrasenia);
            empleadoPrepareStatement.setString(6, cargo);
            resultUpdate = empleadoPrepareStatement.executeUpdate();
            
            if(resultUpdate != 0)
            {
                logger.info("Se registro 1 dato");
                return true;
            }else
            {
                logger.info("No se registro el usuario");
                return false;
            }
            
        }catch(Exception e)
        {
            logger.info(e.getMessage());
            return false;
        }
        finally
        {
            ConexionSQLite.Cerrar(conn);
            ConexionSQLite.Cerrar(stm);
        }
    }
    
    public Empleado consultar(String nombre, String contrasenia) throws SQLException
    {
        int resultUpdate = 0;
        String consultar = "select idEmpleado, nombre, apellidoPa, apellidoMa, contrasenia, cargo from empleado where nombre = '" + nombre + "' and contrasenia = '" + contrasenia + "'";
        
        try
        {
            logger.info(consultar);
            conn = ConexionSQLite.getConnection();
            stm = ConexionSQLite.getStatement();
            empleadoResultSet = ConexionSQLite.getResultSet(consultar);
            
            if(!empleadoResultSet.next())
            {
                logger.info("No se encontro registro");
                return null;
            }else
            {
                logger.info("Se encontro 1 registro");
                this.id = empleadoResultSet.getInt("idEmpleado");
                this.nombre = empleadoResultSet.getString("nombre");
                this.apellidoPa = empleadoResultSet.getString("apellidoPa");
                this.apellidoMa = empleadoResultSet.getString("apellidoMa");
                this.contrasenia = empleadoResultSet.getString("contrasenia");
                this.cargo = empleadoResultSet.getString("cargo");
                empleadoHallado = new Empleado(this.id, this.nombre, this.apellidoPa, this.apellidoMa, this.contrasenia, this.cargo);
                return empleadoHallado;
            }
        }catch(ClassNotFoundException | SQLException | NamingException e)
        {
            logger.info(e.getMessage());
            return null;
        }finally
        {
            ConexionSQLite.Cerrar(conn);
            ConexionSQLite.Cerrar(stm);
            ConexionSQLite.Cerrar(empleadoResultSet);
        }
        
    }
    
    public boolean borrar(String nombre, String contrasenia) throws SQLException
    {
        int resultUpdate = 0;
        Logger logger = Logger.getLogger(Login.class.getName());
        try
        {
            conn = ConexionSQLite.getConnection();
            stm = ConexionSQLite.getStatement();
            resultUpdate = stm.executeUpdate("DELETE FROM empleado WHERE (nombre='" + nombre + "'and contrasenia='"+ contrasenia +"');");
            if(resultUpdate != 0)
            {
                logger.info("Se borro 1 registro");
                return true;
            }else
            {
                logger.info("No se encotraron registros a borrar!!!");
                return false;
            }
        } catch (ClassNotFoundException | SQLException | NamingException e) 
        {
            logger.info(e.getMessage());
            return false;
        }finally
        {
            ConexionSQLite.Cerrar(conn);
            ConexionSQLite.Cerrar(stm);
        }
        
    }
    
    public ArrayList<Empleado> leeTodos() throws SQLException
    {
        Logger logger = Logger.getLogger(Login.class.getName());
        ArrayList<Empleado> empleados = new ArrayList<Empleado>();
        try{
            conn = ConexionSQLite.getConnection();
            stm = conn.createStatement();
            empleadoResultSet = stm.executeQuery("SELECT * FROM empleado");
            if(!empleadoResultSet.next()){
                logger.info("No se encontraron registros");
                ConexionSQLite.Cerrar(conn);
                return null;
            }else{
                do{
                    this.id = empleadoResultSet.getInt("idEmpleado");
                    this.nombre = empleadoResultSet.getString("nombre");
                    this.apellidoPa = empleadoResultSet.getString("apellidoPa");
                    this.apellidoMa = empleadoResultSet.getString("apellidoMa");
                    this.contrasenia = empleadoResultSet.getString("contrasenia");
                    this.cargo = empleadoResultSet.getString("cargo");
                    empleadoHallado = new Empleado(this.id, this.nombre, this.apellidoPa, this.apellidoMa, this.contrasenia, this.cargo);
                    empleados.add(empleadoHallado);
                }while(empleadoResultSet.next());
                    return empleados;
                }
        }catch(Exception e){
            logger.info(e.getMessage());
            return null;
        }finally
        {
            ConexionSQLite.Cerrar(conn);
            ConexionSQLite.Cerrar(stm);
        }
        
    }
    
}
