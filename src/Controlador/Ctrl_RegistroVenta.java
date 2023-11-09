
package Controlador;

import Modelo.CabeceraVenta;
import Modelo.Cliente;
import Modelo.DetalleVenta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Ctrl_RegistroVenta {
    //ultimo id de la cabecera
    public static int idCabeceraRegistrada;
    java.math.BigDecimal iDColVar;
    
    
    //guaradar cabecera
    public boolean guardar(CabeceraVenta objeto) {

        boolean respuesta = false;
        Connection cn = conexion.conexionBD.conectar();

        try {
            PreparedStatement consulta = cn.prepareStatement("insert into cabecera_venta values(?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
            consulta.setInt(1, 0); //id
            consulta.setInt(2, objeto.getIdCliente());
            consulta.setDouble(3, objeto.getValorPagar());
            consulta.setString(4, objeto.getFechaVenta());
            consulta.setInt(5, objeto.getEstado());

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
            
            ResultSet rs=consulta.getGeneratedKeys();
            while(rs.next()){
                iDColVar=rs.getBigDecimal(1);
                idCabeceraRegistrada=iDColVar.intValue();
            }
            
            cn.close();
        } catch (Exception e) {
            System.out.println("Error al guardar cabecera" + e);
        }
        return respuesta;
    }
    //guaradar cliente
    public boolean guardarDetalle(DetalleVenta objeto) {

        boolean respuesta = false;
        Connection cn = conexion.conexionBD.conectar();

        try {
            PreparedStatement consulta = cn.prepareStatement("insert into detalle_venta values(?,?,?,?,?,?,?,?,?,?)");
            consulta.setInt(1, 0); //id
            consulta.setInt(2, idCabeceraRegistrada());
            consulta.setInt(3, objeto.getIdProducto());
            consulta.setInt(4, objeto.getCantidad());
            consulta.setDouble(5, objeto.getPrecioUnitario());
            consulta.setDouble(6, objeto.getSubTotal());
            consulta.setDouble(7, objeto.getDescuento());
            consulta.setDouble(8, objeto.getIva());
            consulta.setDouble(9, objeto.getTotalPagar());
            consulta.setInt(10, (int) objeto.getEstado());

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al guardar Detalle de venta" + e);
        }
        return respuesta;
    }

    private int idCabeceraRegistrada() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
