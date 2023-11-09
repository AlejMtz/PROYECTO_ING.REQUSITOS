/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;


public class Cliente {
    //atributos
    
    private int idCliente;
    private String nombre;
    private String apellio;
    private String cedula;
    private String telefono;
    private String direccion;
    private int estado;
    
    //constructor
    
    public Cliente(){
        this.idCliente=0;
        this.nombre="";
        this.apellio="";
        this.cedula="";
        this.telefono="";
        this.direccion="";
        this.estado=0;
    }
    
    //constructor sobrecargado

    public Cliente(int idCliente, String nombre, String apellio, String cedula, String telefono, String direccion, int estado) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.apellio = apellio;
        this.cedula = cedula;
        this.telefono = telefono;
        this.direccion = direccion;
        this.estado = estado;
    }
    
    //sett and gett

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellio() {
        return apellio;
    }

    public void setApellio(String apellio) {
        this.apellio = apellio;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
      
    
    
}
