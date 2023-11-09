
package Controlador;

import Modelo.Proovedores;
import com.mysql.cj.xdevapi.PreparableStatement;
import conexion.conexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class Ctrl_Proovedores {
    
    public boolean guardar(Proovedores objeto){
        //,etodo para registar proovedor
        
        boolean respuesta = false;
        Connection cn = conexion.conexionBD.conectar();
        
        try {
            PreparedStatement consulta = cn.prepareStatement("insert into proovedores values(?,?,?,?,?)");
            consulta.setInt(1, 0);
            consulta.setString(2, objeto.getNombreproovedor());
            consulta.setString(3, objeto.getDireccionproovedor());
            consulta.setString(4, objeto.getTelefonoproovedor());
            consulta.setInt(5, objeto.getEstado());
            
            if(consulta.executeUpdate()>0){
                respuesta = true;
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al guardar proovedor"+e);
        }
        return respuesta;
    }
    //metodo para consultar si existe el proovedor
    public boolean existeProovedor(String proovedores){
        boolean respuesta = false;
        String sql = "SELECT `nombre_proovedor` FROM `proovedores` WHERE `nombre_proovedor` = '"+proovedores+"';";
        Statement st;
      
        try {
            Connection cn = conexionBD.conectar();
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                respuesta = true; 
            }
            
            
        } catch (SQLException e) {
            System.out.println("Error al guardar proovedor"+e);
        }
        return respuesta;
    }
    
    //metodo para actualizar proovedor
    public boolean actualizar(Proovedores objeto, int idProovedores){
        
        boolean respuesta = false;
        Connection cn = conexion.conexionBD.conectar();
        
        try {
            PreparedStatement consulta = cn.prepareStatement("update `proovedores` set `nombre_proovedor`=?,`direccion_proovedor`=?,`no.telefonico_proovedor`=? WHERE `id_proovedor` = '"+idProovedores+"'");
            consulta.setString(1, objeto.getNombreproovedor());
            consulta.setString(2, objeto.getDireccionproovedor());
            consulta.setString(3, objeto.getTelefonoproovedor());
            
            
            if(consulta.executeUpdate()>0){
                respuesta = true;
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al actualizar proovedor"+e);
        }
        return respuesta;
    }
     //metodo para eliminar proovedor
    public boolean eliminar(int idProovedores){
        
        boolean respuesta = false;
        Connection cn = conexion.conexionBD.conectar();
        
        try {
            PreparedStatement consulta = cn.prepareStatement("DELETE FROM `proovedores` where `id_proovedor` = '"+idProovedores+"'");
           consulta.executeUpdate();
            
            
            if(consulta.executeUpdate()>0){
                respuesta = true;
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al eliminar proovedor"+e);
        }
        return respuesta;
    }
}
