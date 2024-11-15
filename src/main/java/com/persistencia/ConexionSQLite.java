/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.naming.NamingException;

/**
 *
 * @author alberto
 */
public class ConexionSQLite 
{
    public static Connection getConnection() throws ClassNotFoundException, SQLException, NamingException
    {
        String JDBC_DRIVER = "org.h2.Driver";   
        String DB_URL = "jdbc:h2:~/dbPrueba";  

        //  Database credentials 
        String USER = "dbPruebas"; 
        String PASS = "Z91047682z/"; 
        Class.forName(JDBC_DRIVER);
        Connection conn = null;
        conn = DriverManager.getConnection(DB_URL, USER, PASS);
        
        return conn;
    }

    public static Statement getStatement() throws ClassNotFoundException, SQLException, NamingException
    {
        Statement estado = null;
        estado = ConexionSQLite.getConnection().createStatement();
        return estado;
    }
    
    public static PreparedStatement getPreparedStatement(String sql) throws ClassNotFoundException, SQLException, NamingException
    {
        PreparedStatement estado = ConexionSQLite.getConnection().prepareStatement(sql);
        return estado;
    }
    
    public static ResultSet getResultSet(String consulta) throws ClassNotFoundException, SQLException, NamingException
    {
        ResultSet query = null;
        query = ConexionSQLite.getStatement().executeQuery(consulta);
        return query;
    }
    
    public static void Cerrar(Connection conexion) throws SQLException
    {
        conexion.close();
    }
    
    public static void Cerrar(Statement estado) throws SQLException
    {
        estado.close();
    }
    
    public static void Cerrar(PreparedStatement estado) throws SQLException
    {
        estado.close();
    }
    
    public static void Cerrar(ResultSet resultado) throws SQLException
    {
        resultado.close();
    }
    
}
