/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Cliente;
import Modelo.Productos;
import conexion.conexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ctrl_Cliente {

    //guaradar cliente
    public boolean guardar(Cliente objeto) {

        boolean respuesta = false;
        Connection cn = conexion.conexionBD.conectar();

        try {
            PreparedStatement consulta = cn.prepareStatement("insert into cliente values(?,?,?,?,?,?,?)");
            consulta.setInt(1, 0); //id
            consulta.setString(2, objeto.getNombre());
            consulta.setString(3, objeto.getApellio());
            consulta.setString(4, objeto.getCedula());
            consulta.setString(5, objeto.getTelefono());
            consulta.setString(6, objeto.getDireccion());
            consulta.setInt(7, objeto.getEstado());

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close();
        } catch (Exception e) {
            System.out.println("Error al guardar cita" + e);
        }
        return respuesta;
    }

    //metodo para consultar si existe el cliente
    public boolean existeCliente(String cedula) {
        boolean respuesta = false;
        String sql = "SELECT `cedula_cliente` FROM `cliente` WHERE `cedula_cliente` = '" + cedula + "';";
        Statement st;

        try {
            Connection cn = conexionBD.conectar();
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                respuesta = true;
            }

        } catch (SQLException e) {
            System.out.println("Error al guardar cita" + e);
        }
        return respuesta;
    }
        //actualizar cliente
     public boolean actualizar(Cliente objeto, int idCliente){
        
        boolean respuesta = false;
        Connection cn = conexion.conexionBD.conectar();
        
        try {
            PreparedStatement consulta = cn.prepareStatement("update cliente set nombre_cliente=?, apellido_cliente=?, cedula_cliente=?, telefono_cliente=?, direccion_cliente=?, estado_cliente=? WHERE `id_cliente` = '"+idCliente+"'");
            consulta.setString(1, objeto.getNombre());
            consulta.setString(2, objeto.getApellio());
            consulta.setString(3, objeto.getCedula());
            consulta.setString(4, objeto.getTelefono());
            consulta.setString(5, objeto.getDireccion());
            consulta.setInt(6, objeto.getEstado());
            
            
            if(consulta.executeUpdate()>0){
                respuesta = true;
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al actualizar cita"+e);
        }
        return respuesta;
    }
     //metodo para eliminar cliente
    public boolean eliminar(int idCliente){
        
        boolean respuesta = false;
        Connection cn = conexion.conexionBD.conectar();
        
        try {
            PreparedStatement consulta = cn.prepareStatement("DELETE FROM `cliente` where `id_cliente` = '"+idCliente+"'");
           consulta.executeUpdate();
            
            
            if(consulta.executeUpdate()>0){
                respuesta = true;
            }
            cn.close();
        } catch (Exception e) {
            System.out.println("Error al eliminar cita"+e);
        }
        return respuesta;
    }
    
}
