
package Vista;

import Controlador.Reportes;
import java.awt.Dimension;
import javax.swing.JDesktopPane;


public class ventana_menu extends javax.swing.JFrame {
    
    public static JDesktopPane jDesktopPane_menu;

   
    public ventana_menu() {
        initComponents();
        
        this.setSize(new Dimension(1200,700));
        this.setExtendedState(this.MAXIMIZED_BOTH);
        this.setLocationRelativeTo(null);
        this.setTitle("SISTEMA VETERINARIA PET´S LIFE");
        
        this.setLayout(null);
        jDesktopPane_menu = new JDesktopPane();
        int ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
        int alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
        this.jDesktopPane_menu.setBounds(0, 0, ancho, (alto-110));
        this.add(jDesktopPane_menu);
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu_nuevo_producto = new javax.swing.JMenuItem();
        jMenu_gestiona_productos = new javax.swing.JMenuItem();
        jMenu_actualizar_producto = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenu_nuevo_cliente = new javax.swing.JMenuItem();
        jMenu_gestiona_cliente = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenu_nuevo_proovedor = new javax.swing.JMenuItem();
        jMenu_gestiona_proovedor = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenu_nueva_venta = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenu_reporte_producto = new javax.swing.JMenuItem();
        jMenu_reporte_cliente = new javax.swing.JMenuItem();
        jMenu_reporte_proovedor = new javax.swing.JMenuItem();
        jMenu_reporte_ventas = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        jMenu_cerrar_sesion = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-pills-50.png"))); // NOI18N
        jMenu1.setText("Productos");
        jMenu1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jMenu1.setPreferredSize(new java.awt.Dimension(150, 50));

        jMenu_nuevo_producto.setText("Nuevo producto");
        jMenu_nuevo_producto.setBorder(null);
        jMenu_nuevo_producto.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenu_nuevo_producto.setPreferredSize(new java.awt.Dimension(150, 30));
        jMenu_nuevo_producto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu_nuevo_productoActionPerformed(evt);
            }
        });
        jMenu1.add(jMenu_nuevo_producto);

        jMenu_gestiona_productos.setText("Gestionar produtos");
        jMenu_gestiona_productos.setBorder(null);
        jMenu_gestiona_productos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenu_gestiona_productos.setPreferredSize(new java.awt.Dimension(150, 30));
        jMenu_gestiona_productos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu_gestiona_productosActionPerformed(evt);
            }
        });
        jMenu1.add(jMenu_gestiona_productos);

        jMenu_actualizar_producto.setText("Actualizar Stock");
        jMenu_actualizar_producto.setBorder(null);
        jMenu_actualizar_producto.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenu_actualizar_producto.setPreferredSize(new java.awt.Dimension(150, 30));
        jMenu_actualizar_producto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu_actualizar_productoActionPerformed(evt);
            }
        });
        jMenu1.add(jMenu_actualizar_producto);

        jMenuBar1.add(jMenu1);

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-usuario-masculino-48.png"))); // NOI18N
        jMenu2.setText("Cliente");
        jMenu2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jMenu2.setPreferredSize(new java.awt.Dimension(150, 50));

        jMenu_nuevo_cliente.setText("Nuevo Cliente");
        jMenu_nuevo_cliente.setPreferredSize(new java.awt.Dimension(150, 30));
        jMenu_nuevo_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu_nuevo_clienteActionPerformed(evt);
            }
        });
        jMenu2.add(jMenu_nuevo_cliente);

        jMenu_gestiona_cliente.setText("Gestionar Cliente");
        jMenu_gestiona_cliente.setPreferredSize(new java.awt.Dimension(150, 30));
        jMenu_gestiona_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu_gestiona_clienteActionPerformed(evt);
            }
        });
        jMenu2.add(jMenu_gestiona_cliente);

        jMenuBar1.add(jMenu2);

        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-proveedor-48.png"))); // NOI18N
        jMenu3.setText("Proovedor");
        jMenu3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jMenu3.setPreferredSize(new java.awt.Dimension(150, 50));

        jMenu_nuevo_proovedor.setText("Nuevo proovedor");
        jMenu_nuevo_proovedor.setPreferredSize(new java.awt.Dimension(150, 30));
        jMenu_nuevo_proovedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu_nuevo_proovedorActionPerformed(evt);
            }
        });
        jMenu3.add(jMenu_nuevo_proovedor);

        jMenu_gestiona_proovedor.setText("Gestionar proovedor");
        jMenu_gestiona_proovedor.setPreferredSize(new java.awt.Dimension(150, 30));
        jMenu_gestiona_proovedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu_gestiona_proovedorActionPerformed(evt);
            }
        });
        jMenu3.add(jMenu_gestiona_proovedor);

        jMenuBar1.add(jMenu3);

        jMenu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-factura-48.png"))); // NOI18N
        jMenu4.setText("Facturas");
        jMenu4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jMenu4.setPreferredSize(new java.awt.Dimension(150, 50));

        jMenu_nueva_venta.setText("Nueva venta");
        jMenu_nueva_venta.setPreferredSize(new java.awt.Dimension(150, 30));
        jMenu_nueva_venta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu_nueva_ventaActionPerformed(evt);
            }
        });
        jMenu4.add(jMenu_nueva_venta);

        jMenuBar1.add(jMenu4);

        jMenu5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-reporte-de-negocios-48.png"))); // NOI18N
        jMenu5.setText("Reportes");
        jMenu5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jMenu5.setPreferredSize(new java.awt.Dimension(150, 50));

        jMenu_reporte_producto.setText("Reportes productos");
        jMenu_reporte_producto.setPreferredSize(new java.awt.Dimension(150, 30));
        jMenu_reporte_producto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu_reporte_productoActionPerformed(evt);
            }
        });
        jMenu5.add(jMenu_reporte_producto);

        jMenu_reporte_cliente.setText("Reportes Cliente");
        jMenu_reporte_cliente.setPreferredSize(new java.awt.Dimension(150, 30));
        jMenu_reporte_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu_reporte_clienteActionPerformed(evt);
            }
        });
        jMenu5.add(jMenu_reporte_cliente);

        jMenu_reporte_proovedor.setText("Reportes proovedor");
        jMenu_reporte_proovedor.setPreferredSize(new java.awt.Dimension(150, 30));
        jMenu_reporte_proovedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu_reporte_proovedorActionPerformed(evt);
            }
        });
        jMenu5.add(jMenu_reporte_proovedor);

        jMenu_reporte_ventas.setText("Reportes ventas");
        jMenu_reporte_ventas.setPreferredSize(new java.awt.Dimension(150, 30));
        jMenu_reporte_ventas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu_reporte_ventasActionPerformed(evt);
            }
        });
        jMenu5.add(jMenu_reporte_ventas);

        jMenuBar1.add(jMenu5);

        jMenu7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-salida-48.png"))); // NOI18N
        jMenu7.setText("Salir");

        jMenu_cerrar_sesion.setText("Salir");
        jMenu_cerrar_sesion.setPreferredSize(new java.awt.Dimension(150, 30));
        jMenu_cerrar_sesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu_cerrar_sesionActionPerformed(evt);
            }
        });
        jMenu7.add(jMenu_cerrar_sesion);

        jMenuBar1.add(jMenu7);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenu_actualizar_productoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu_actualizar_productoActionPerformed
        InterActualizarStock interActualizarStock= new InterActualizarStock();
        jDesktopPane_menu.add(interActualizarStock);
        interActualizarStock.setVisible(true);
    }//GEN-LAST:event_jMenu_actualizar_productoActionPerformed

    private void jMenu_nuevo_proovedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu_nuevo_proovedorActionPerformed
        InterProovedores interProovedores = new InterProovedores();
        jDesktopPane_menu.add(interProovedores);
        interProovedores.setVisible(true);
    }//GEN-LAST:event_jMenu_nuevo_proovedorActionPerformed

    private void jMenu_gestiona_proovedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu_gestiona_proovedorActionPerformed
       InterGestionarProovedores interGestionaCategoria = new InterGestionarProovedores();
       jDesktopPane_menu.add(interGestionaCategoria);
       interGestionaCategoria.setVisible(true);
    }//GEN-LAST:event_jMenu_gestiona_proovedorActionPerformed

    private void jMenu_nuevo_productoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu_nuevo_productoActionPerformed
        InterProductos interProductos = new InterProductos();
       jDesktopPane_menu.add(interProductos);
       interProductos.setVisible(true);
    }//GEN-LAST:event_jMenu_nuevo_productoActionPerformed

    private void jMenu_gestiona_productosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu_gestiona_productosActionPerformed
       InterGestionarProductos interGestionarProductos = new InterGestionarProductos();
       jDesktopPane_menu.add(interGestionarProductos);
       interGestionarProductos.setVisible(true);
    }//GEN-LAST:event_jMenu_gestiona_productosActionPerformed

    private void jMenu_nuevo_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu_nuevo_clienteActionPerformed
        InterCliente interCliente = new InterCliente();
       jDesktopPane_menu.add(interCliente);
       interCliente.setVisible(true);

    }//GEN-LAST:event_jMenu_nuevo_clienteActionPerformed

    private void jMenu_gestiona_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu_gestiona_clienteActionPerformed
         InterGestionarCliente interGestionarCliente = new InterGestionarCliente();
       jDesktopPane_menu.add(interGestionarCliente);
       interGestionarCliente.setVisible(true);
    }//GEN-LAST:event_jMenu_gestiona_clienteActionPerformed

    private void jMenu_cerrar_sesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu_cerrar_sesionActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenu_cerrar_sesionActionPerformed

    private void jMenu_nueva_ventaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu_nueva_ventaActionPerformed
        InterFacturacion interFacturacion = new InterFacturacion();
       jDesktopPane_menu.add(interFacturacion);
       interFacturacion.setVisible(true);
    }//GEN-LAST:event_jMenu_nueva_ventaActionPerformed

    private void jMenu_reporte_productoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu_reporte_productoActionPerformed
        
      Reportes reporte= new Reportes();
        reporte.reportesProductos();
        
    }//GEN-LAST:event_jMenu_reporte_productoActionPerformed

    private void jMenu_reporte_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu_reporte_clienteActionPerformed
          Reportes reporte= new Reportes();
        reporte.reportesClientes();
    }//GEN-LAST:event_jMenu_reporte_clienteActionPerformed

    private void jMenu_reporte_proovedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu_reporte_proovedorActionPerformed
        Reportes reporte= new Reportes();
        reporte.reportesProovedores();
        
    }//GEN-LAST:event_jMenu_reporte_proovedorActionPerformed

    private void jMenu_reporte_ventasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu_reporte_ventasActionPerformed
        Reportes reporte= new Reportes();
        reporte.reportesVentas();
    }//GEN-LAST:event_jMenu_reporte_ventasActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ventana_menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ventana_menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ventana_menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ventana_menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ventana_menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenu_actualizar_producto;
    private javax.swing.JMenuItem jMenu_cerrar_sesion;
    private javax.swing.JMenuItem jMenu_gestiona_cliente;
    private javax.swing.JMenuItem jMenu_gestiona_productos;
    private javax.swing.JMenuItem jMenu_gestiona_proovedor;
    private javax.swing.JMenuItem jMenu_nueva_venta;
    private javax.swing.JMenuItem jMenu_nuevo_cliente;
    private javax.swing.JMenuItem jMenu_nuevo_producto;
    private javax.swing.JMenuItem jMenu_nuevo_proovedor;
    private javax.swing.JMenuItem jMenu_reporte_cliente;
    private javax.swing.JMenuItem jMenu_reporte_producto;
    private javax.swing.JMenuItem jMenu_reporte_proovedor;
    private javax.swing.JMenuItem jMenu_reporte_ventas;
    // End of variables declaration//GEN-END:variables
}
