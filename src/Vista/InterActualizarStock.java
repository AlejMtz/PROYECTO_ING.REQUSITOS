/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.Ctrl_Cliente;
import Controlador.Ctrl_Productos;
import Modelo.Productos;
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author LENOVO
 */
public class InterActualizarStock extends javax.swing.JInternalFrame {

    int idProducto = 0;
    int cantidad = 0;

    public InterActualizarStock() {
        initComponents();
        setTitle("Actualizar Stock de productos");
        setSize(new Dimension(400, 300));
        this.CargarComboProductos();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_stock_nuevo = new javax.swing.JTextField();
        txt_stock_actual = new javax.swing.JTextField();
        jComboBox_producto = new javax.swing.JComboBox<>();
        jButton1_actualizar = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 153));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Actualiza Stock ");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Producto:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Stock Actual");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Stock Nuevo:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, -1));
        getContentPane().add(txt_stock_nuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 130, 240, 30));

        txt_stock_actual.setEnabled(false);
        getContentPane().add(txt_stock_actual, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 90, 240, 30));

        jComboBox_producto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione producto:", "Item 2", "Item 3", "Item 4" }));
        jComboBox_producto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_productoActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox_producto, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, 240, -1));

        jButton1_actualizar.setBackground(new java.awt.Color(153, 255, 153));
        jButton1_actualizar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1_actualizar.setText("Actualizar Stock");
        jButton1_actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1_actualizarActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1_actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 190, 150, 40));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox_productoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_productoActionPerformed
        this.MostrarStock();
    }//GEN-LAST:event_jComboBox_productoActionPerformed

    private void jButton1_actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1_actualizarActionPerformed
//validamos seleccion de producto
        if (!jComboBox_producto.getSelectedItem().equals("Seleccione producto:")) {
            //validamos campo vacio
            if (!txt_stock_nuevo.getText().isEmpty()) {
                //validamos que el usuario nop ingrese otros caracteres numericos
                boolean validacion = validar(txt_stock_nuevo.getText().trim());
                if (validacion = true) {
                    //validamos la cantidad que sea mayor a 0
                    if (Integer.parseInt(txt_stock_nuevo.getText()) > 0) {
                        Productos productos = new Productos();
                        Ctrl_Productos controlProductos = new Ctrl_Productos();
                        int stockActual = Integer.parseInt(txt_stock_actual.getText().trim());
                        int stockNuevo = Integer.parseInt(txt_stock_nuevo.getText().trim());

                        stockNuevo = stockActual + stockNuevo;
                        productos.setCantidadProducto(stockNuevo);
                        if (controlProductos.actualizarStock(productos, idProducto)) {
                            JOptionPane.showMessageDialog(null, "Stock actualizado");
                            jComboBox_producto.setSelectedItem("Seleccione producto:");
                            txt_stock_actual.setText("");
                            txt_stock_nuevo.setText("");
                            this.CargarComboProductos();
                        } else {
                            JOptionPane.showMessageDialog(null, "Error al actualizar");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "La cantidad no es mayor a cero");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "No se admiten caractericos no numericos");

                }

            } else {
                JOptionPane.showMessageDialog(null, "Ingeresa la nueva cantidad nueva para sumar al stock del producto");

            }
        }else{
             JOptionPane.showMessageDialog(null, "Seleccione un producto");
        }
    }//GEN-LAST:event_jButton1_actualizarActionPerformed
    
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1_actualizar;
    private javax.swing.JComboBox<String> jComboBox_producto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField txt_stock_actual;
    private javax.swing.JTextField txt_stock_nuevo;
    // End of variables declaration//GEN-END:variables

//Metodso para cargar productos en combobox
    private void CargarComboProductos() {
        Connection cn = conexion.conexionBD.conectar();
        String sql = "Select * from productos";
        Statement st;
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            jComboBox_producto.removeAllItems();
            jComboBox_producto.addItem("Seleccione produuto:");
            while (rs.next()) {
                jComboBox_producto.addItem(rs.getString("nombre_producto"));
            }
        } catch (SQLException e) {
            System.err.println("Error al cargar los productos en:" + e);
        }
    }

    //metodo para mostar stock del producto seleccionado
    private void MostrarStock() {
        try {
            Connection cn = conexion.conexionBD.conectar();
            String sql = "Select * from productos where nombre_producto='" + this.jComboBox_producto.getSelectedItem() + "'";
            Statement st;
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {
                idProducto = rs.getInt("id_producto");
                cantidad = rs.getInt("cantidad");
                txt_stock_actual.setText(String.valueOf(cantidad));

            } else {
                txt_stock_actual.setText("");
            }
        } catch (SQLException e) {
            System.err.println("Error obtener producto en:" + e);
        }
    }

    //metodo de validacion de caracteres no numericos
    private boolean validar(String valor) {
        int num;
        try {
            num = Integer.parseInt(valor);
        } catch (NumberFormatException e) {
        }
        return false;
    }

}
