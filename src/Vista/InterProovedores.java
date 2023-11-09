package Vista;

import Controlador.Ctrl_Proovedores;
import Modelo.Proovedores;
import java.awt.Dimension;
import javax.swing.JOptionPane;

public class InterProovedores extends javax.swing.JInternalFrame {

    public InterProovedores() {
        initComponents();

        this.setSize(new Dimension(400, 250));
        this.setTitle("Nuevo Proovedor");

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_nombre = new javax.swing.JTextField();
        boton_guadar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txt_direccion = new javax.swing.JTextField();
        txt_telefono = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Telefono proovedor:");

        setBackground(new java.awt.Color(204, 204, 255));
        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("NUEVO PROOVEDOOR");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 0, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Nombre proovedor: ");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        txt_nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nombreActionPerformed(evt);
            }
        });
        getContentPane().add(txt_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 30, 200, 30));

        boton_guadar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        boton_guadar.setText("GUARDAR");
        boton_guadar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_guadarActionPerformed(evt);
            }
        });
        getContentPane().add(boton_guadar, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 180, 100, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Teléfono proovedor:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, -1, -1));
        getContentPane().add(txt_direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 80, 200, 30));
        getContentPane().add(txt_telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 130, 200, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Dirección proovedor:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boton_guadarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_guadarActionPerformed
        Proovedores proovedores = new Proovedores();
        Ctrl_Proovedores controlProovedores = new Ctrl_Proovedores();

        //validamos campos vacios
        if (txt_nombre.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Llene todos los campos");
        } else {
            
            if (!controlProovedores.existeProovedor(txt_nombre.getText().trim())) {
            proovedores.setNombreproovedor(txt_nombre.getText().trim());
            proovedores.setDireccionproovedor(txt_direccion.getText().trim());
            proovedores.setTelefonoproovedor(txt_telefono.getText().trim());
            proovedores.setEstado(1);
            if (controlProovedores.guardar(proovedores)) {
                JOptionPane.showMessageDialog(null, "Registro guardado");
            }else{
                JOptionPane.showMessageDialog(null, "Error al guardar");   
               }
            }else{
                JOptionPane.showMessageDialog(null, "Proovedor ya existente");
            } 
           
        }
        //limpiar campos
        txt_nombre.setText("");
        txt_direccion.setText("");
        txt_telefono.setText("");
    }//GEN-LAST:event_boton_guadarActionPerformed

    private void txt_nombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nombreActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boton_guadar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField txt_direccion;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_telefono;
    // End of variables declaration//GEN-END:variables
}