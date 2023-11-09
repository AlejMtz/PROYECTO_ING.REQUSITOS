package Controlador;

import Modelo.Productos;
import Modelo.Proovedores;
import conexion.conexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ctrl_Productos {

//metodo para registar producto
    public boolean guardar(Productos objeto) {

        boolean respuesta = false;
        Connection cn = conexion.conexionBD.conectar();

        try {
            PreparedStatement consulta = cn.prepareStatement("insert into productos values(?,?,?,?,?,?,?,?)");
            consulta.setInt(1, 0); //id
            consulta.setString(2, objeto.getNombreProducto());
            consulta.setInt(3, objeto.getCantidadProducto());
            consulta.setDouble(4, objeto.getPrecioProducto());
            consulta.setString(5, objeto.getDescripcionProducto());
            consulta.setInt(6, objeto.getPorcentajeIVA());
            consulta.setInt(7, objeto.getIdProovedor());
            consulta.setInt(8, objeto.getEstado());

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close();
        } catch (Exception e) {
            System.out.println("Error al guardar producto" + e);
        }
        return respuesta;
    }

    //metodo para consultar si existe el producto
    public boolean existeProducto(String producto) {
        boolean respuesta = false;
        String sql = "SELECT `nombre_producto` FROM `productos` WHERE `nombre_producto` = '" + producto + "';";
        Statement st;

        try {
            Connection cn = conexionBD.conectar();
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                respuesta = true;
            }

        } catch (SQLException e) {
            System.out.println("Error al guardar producto" + e);
        }
        return respuesta;
    }

    public boolean actualizar(Productos objeto, int idProductos) {

        boolean respuesta = false;
        Connection cn = conexion.conexionBD.conectar();

        try {
            PreparedStatement consulta = cn.prepareStatement("update productos set nombre_producto=?, cantidad=?, precio_producto=?, descripcion_producto=?, porcentaje_iva=?, id_proovedor=?, estado=? WHERE `id_producto` = '" + idProductos + "'");
            consulta.setString(1, objeto.getNombreProducto());
            consulta.setInt(2, objeto.getCantidadProducto());
            consulta.setDouble(3, objeto.getPrecioProducto());
            consulta.setString(4, objeto.getDescripcionProducto());
            consulta.setInt(5, objeto.getPorcentajeIVA());
            consulta.setInt(6, objeto.getIdProovedor());
            consulta.setInt(7, objeto.getEstado());

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al actualizar producto" + e);
        }
        return respuesta;
    }
    //metodo para eliminar prooducto

    public boolean eliminar(int idProducto) {

        boolean respuesta = false;
        Connection cn = conexion.conexionBD.conectar();

        try {
            PreparedStatement consulta = cn.prepareStatement("DELETE FROM `productos` where `id_producto` = '" + idProducto + "'");
            consulta.executeUpdate();

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close();
        } catch (Exception e) {
            System.out.println("Error al eliminar producto" + e);
        }
        return respuesta;
    }

    //metodo para actualizar stock del producto
    public boolean actualizarStock(Productos object, int idProducto) {

        boolean respuesta = false;
        Connection cn = conexion.conexionBD.conectar();

        try {
            PreparedStatement consulta = cn.prepareStatement("update`productos` set cantidad=? where `id_producto` = '" + idProducto + "'");
            consulta.setInt(1, object.getCantidadProducto());

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close();
        } catch (Exception e) {
            System.out.println("Error al actualizar stock del producto" + e);
        }
        return respuesta;
    }

}
