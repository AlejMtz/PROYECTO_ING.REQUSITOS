/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.Ctrl_Cliente;
import Controlador.Ctrl_Productos;
import Modelo.Cliente;
import Modelo.Productos;
import com.oracle.jrockit.jfr.Producer;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.scene.paint.Color;
import javax.sound.midi.SysexMessage;
import javax.swing.JOptionPane;

/**
 *
 * @author LENOVO
 */
public class InterCliente extends javax.swing.JInternalFrame {

    public InterCliente() {
        initComponents();
        this.setSize(400, 320);
        this.setTitle("Nuevo Cliente");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_nombre_cliente = new javax.swing.JTextField();
        txt_apellido_cliente = new javax.swing.JTextField();
        txt_cedula_cliente = new javax.swing.JTextField();
        txt_direccion_cliente = new javax.swing.JTextField();
        boton_guardar = new javax.swing.JButton();
        txt_telefono_cliente = new javax.swing.JTextField();

        setBackground(new java.awt.Color(153, 255, 153));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Nueva Cliente");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Nombre Cliente:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Apellido Cliente:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 100, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Cédula");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Teléfono:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 80, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Dirección:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, -1, -1));
        getContentPane().add(txt_nombre_cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, 260, 23));
        getContentPane().add(txt_apellido_cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 90, 260, 23));
        getContentPane().add(txt_cedula_cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, 260, 23));
        getContentPane().add(txt_direccion_cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 180, 260, 23));

        boton_guardar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        boton_guardar.setText("GUARDAR");
        boton_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_guardarActionPerformed(evt);
            }
        });
        getContentPane().add(boton_guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 250, -1, -1));
        getContentPane().add(txt_telefono_cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 150, 260, 23));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boton_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_guardarActionPerformed

        Cliente cliente = new Cliente();
        Ctrl_Cliente controlCliente = new Ctrl_Cliente();
        if (!txt_nombre_cliente.getText().isEmpty() && !txt_apellido_cliente.getText().isEmpty() && !txt_cedula_cliente.getText().isEmpty()) {
//            JOptionPane.showMessageDialog(null, "Correcto");

            if (!controlCliente.existeCliente(txt_cedula_cliente.getText().trim())) {
                cliente.setNombre(txt_nombre_cliente.getText().trim());
                cliente.setApellio(txt_apellido_cliente.getText().trim());
                cliente.setCedula(txt_cedula_cliente.getText().trim());
                cliente.setTelefono(txt_telefono_cliente.getText().trim());
                cliente.setDireccion(txt_direccion_cliente.getText().trim());
                cliente.setEstado(1);
                if (controlCliente.guardar(cliente)) {

                    JOptionPane.showMessageDialog(null, "Registro guardado");
                    txt_nombre_cliente.setBackground(java.awt.Color.green);
                    txt_nombre_cliente.setBackground(java.awt.Color.green);
                    txt_nombre_cliente.setBackground(java.awt.Color.green);
                    txt_nombre_cliente.setBackground(java.awt.Color.green);
                    txt_nombre_cliente.setBackground(java.awt.Color.green);

                } else {
                    JOptionPane.showMessageDialog(null, "Error al guardado");
                }

            } else {
                JOptionPane.showMessageDialog(null, "Cliente ya esta registrado");
                txt_nombre_cliente.setBackground(java.awt.Color.white);
                txt_apellido_cliente.setBackground(java.awt.Color.white);
                txt_cedula_cliente.setBackground(java.awt.Color.white);
                txt_telefono_cliente.setBackground(java.awt.Color.white);
                txt_direccion_cliente.setBackground(java.awt.Color.white);

            }
        } else {
            JOptionPane.showMessageDialog(null, "Completa todos los campos");
                 txt_nombre_cliente.setBackground(java.awt.Color.red);
                 txt_apellido_cliente.setBackground(java.awt.Color.red);
                 txt_cedula_cliente.setBackground(java.awt.Color.red);
                 txt_telefono_cliente.setBackground(java.awt.Color.red);
                 txt_direccion_cliente.setBackground(java.awt.Color.red);
        }
        //,etodo de limpiar
        this.Limpiar();
        


    }//GEN-LAST:event_boton_guardarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boton_guardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField txt_apellido_cliente;
    private javax.swing.JTextField txt_cedula_cliente;
    private javax.swing.JTextField txt_direccion_cliente;
    private javax.swing.JTextField txt_nombre_cliente;
    private javax.swing.JTextField txt_telefono_cliente;
    // End of variables declaration//GEN-END:variables

//metodo para limpiar campos
    private void Limpiar() {
        txt_nombre_cliente.setText("");
        txt_apellido_cliente.setText("");
        txt_cedula_cliente.setText("");
        txt_telefono_cliente.setText("");
        txt_direccion_cliente.setText("");
    }

//metodo para cargar los proovedores
}