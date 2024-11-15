/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author alberto
 */
@Entity
@Table(name = "empleado")
@NamedQueries({
    @NamedQuery(name = "Empleado.findAll", query = "SELECT e FROM Empleado e"),
    @NamedQuery(name = "Empleado.findByNombre", query = "SELECT e FROM Empleado e WHERE e.nombre = :nombre"),
    @NamedQuery(name = "Empleado.findByApellidoPaterno", query = "SELECT e FROM Empleado e WHERE e.apellidoPa = :apellidoPaterno")
})
public class Empleado implements Serializable
{
    @Id
    @Column(name = "id")
    private int id;
    
    @Column(name = "nombre")
    private String nombre;
    
    @Column(name = "apellidoPaterno")
    private String apellidoPa;
    
    @Column(name = "apellidoMaterno")
    private String apellidoMa;
    
    @Column(name = "contrasenia")
    private String contrasenia;
    
    @Column(name = "cargo")
    private String cargo;

    public Empleado(int id, String nombre, String apellidoPa, String apellidoMa, String contrasenia, String cargo) 
    {
        this.id = id;
        this.nombre = nombre;
        this.apellidoPa = apellidoPa;
        this.apellidoMa = apellidoMa;
        this.contrasenia = contrasenia;
        this.cargo = cargo;
    }

    public int getId() 
    {
        return id;
    }

    public void setId(int id) 
    {
        this.id = id;
    }

    public String getNombre() 
    {
        return nombre;
    }

    public void setNombre(String nombre) 
    {
        this.nombre = nombre;
    }

    public String getApellidoPa() 
    {
        return apellidoPa;
    }

    public void setApellidoPa(String apellidoPa) 
    {
        this.apellidoPa = apellidoPa;
    }

    public String getApellidoMa() 
    {
        return apellidoMa;
    }

    public void setApellidoMa(String apellidoMa) 
    {
        this.apellidoMa = apellidoMa;
    }

    public String getContrasenia() 
    {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) 
    {
        this.contrasenia = contrasenia;
    }

    public String getCargo() 
    {
        return cargo;
    }

    public void setCargo(String cargo) 
    {
        this.cargo = cargo;
    }

    @Override
    public String toString() {
        return "Id: \n" + id + "Nombre: \n" + nombre + "Apellido Paterno: \n" + apellidoPa + "Apellido Materno: \n" + apellidoMa + "Contrasenia: \n" + contrasenia + "Cargo: " + cargo;
    }
    
}
