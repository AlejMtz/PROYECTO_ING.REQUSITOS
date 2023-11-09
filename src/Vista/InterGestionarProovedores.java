
package Vista;

import Controlador.Ctrl_Proovedores;
import Modelo.Proovedores;
import conexion.conexionBD;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class InterGestionarProovedores extends javax.swing.JInternalFrame {

        public int idProovedor;
   
    public InterGestionarProovedores() {
        initComponents();
        this.setSize(new Dimension(800,400));
        this.setTitle("Gestionar Proovedores");
        
        this.CargarTablaProovedores();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1_proovedores = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        boton_actualizar = new javax.swing.JButton();
        boton_eliminar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txt_telefono_proovedor = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txt_nombre_proovedor = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txt_direccion_proovedor = new javax.swing.JTextField();

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Nombre proovedor:");
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        setBackground(new java.awt.Color(153, 153, 153));
        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("ADMINISTAR PROOVEDORES");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, -1, -1));

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1_proovedores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1_proovedores);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 520, 230));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 540, 250));

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        boton_actualizar.setBackground(new java.awt.Color(153, 255, 153));
        boton_actualizar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        boton_actualizar.setText("ACTUALIZAR");
        boton_actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_actualizarActionPerformed(evt);
            }
        });
        jPanel2.add(boton_actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        boton_eliminar.setBackground(new java.awt.Color(255, 51, 51));
        boton_eliminar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        boton_eliminar.setText("ELIMINAR");
        boton_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_eliminarActionPerformed(evt);
            }
        });
        jPanel2.add(boton_eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 110, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 30, 130, 80));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Teléfono proovedor:");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));

        txt_telefono_proovedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_telefono_proovedorActionPerformed(evt);
            }
        });
        jPanel3.add(txt_telefono_proovedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 170, 30));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 270, 190, 60));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Nombre proovedor:");
        jPanel5.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));
        jPanel5.add(txt_nombre_proovedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 170, 30));

        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 130, 190, 60));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Dirección proovedor:");
        jPanel6.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));
        jPanel6.add(txt_direccion_proovedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 170, 30));

        getContentPane().add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 200, 190, 60));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_telefono_proovedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_telefono_proovedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_telefono_proovedorActionPerformed

    private void boton_actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_actualizarActionPerformed
        if(!txt_nombre_proovedor.getText().isEmpty() && !txt_direccion_proovedor.getText().isEmpty() && !txt_telefono_proovedor.getText().isEmpty()){
            Proovedores proovedores = new Proovedores();
            Ctrl_Proovedores controlProovedores = new Ctrl_Proovedores();
            
            proovedores.setNombreproovedor(txt_nombre_proovedor.getText().trim());
            proovedores.setDireccionproovedor(txt_direccion_proovedor.getText().trim());
            proovedores.setTelefonoproovedor(txt_telefono_proovedor.getText().trim());
            if(controlProovedores.actualizar(proovedores, idProovedor)){
                JOptionPane.showMessageDialog(null, "Proovedor actualizado");
                txt_nombre_proovedor.setText("");
                txt_direccion_proovedor.setText("");
                txt_telefono_proovedor.setText("");
                this.CargarTablaProovedores();
        }else{
                JOptionPane.showMessageDialog(null, "Error al actualizar proovedor");   
               }
        }else{
                JOptionPane.showMessageDialog(null, "Seleccione un proovedor");   
               }
        
        
    }//GEN-LAST:event_boton_actualizarActionPerformed
        
    private void boton_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_eliminarActionPerformed
        if(!txt_nombre_proovedor.getText().isEmpty() && !txt_direccion_proovedor.getText().isEmpty() && !txt_telefono_proovedor.getText().isEmpty()){
            Proovedores proovedores = new Proovedores();
            Ctrl_Proovedores controlProovedores = new Ctrl_Proovedores();
            
            proovedores.setNombreproovedor(txt_nombre_proovedor.getText().trim());
            proovedores.setDireccionproovedor(txt_direccion_proovedor.getText().trim());
            proovedores.setTelefonoproovedor(txt_telefono_proovedor.getText().trim());
            if(!controlProovedores.eliminar(idProovedor)){
                JOptionPane.showMessageDialog(null, "Proovedor eliminado");
                txt_nombre_proovedor.setText("");
                txt_direccion_proovedor.setText("");
                txt_telefono_proovedor.setText("");
                this.CargarTablaProovedores();
        }else{
                JOptionPane.showMessageDialog(null, "Error al eliminar proovedor");   
               }
        }else{
                JOptionPane.showMessageDialog(null, "Seleccione un proovedor");   
               }
    }//GEN-LAST:event_boton_eliminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boton_actualizar;
    private javax.swing.JButton boton_eliminar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    public static javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    public static javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable jTable1_proovedores;
    private javax.swing.JTextField txt_direccion_proovedor;
    private javax.swing.JTextField txt_nombre_proovedor;
    private javax.swing.JTextField txt_telefono_proovedor;
    // End of variables declaration//GEN-END:variables

    
    
    
    //metodo para mostrar todos los proovesdores
    private void CargarTablaProovedores(){
        Connection con = conexionBD.conectar();
        DefaultTableModel model = new DefaultTableModel();
        String sql = "SELECT `id_proovedor`, `nombre_proovedor`, `direccion_proovedor`, `no.telefonico_proovedor`, `estado` FROM `proovedores`";
        Statement st;
        
        try {
            
           st = con.createStatement();
          ResultSet rs = st.executeQuery(sql);
           InterGestionarProovedores.jTable1_proovedores = new JTable(model);
           InterGestionarProovedores.jScrollPane1.setViewportView(InterGestionarProovedores.jTable1_proovedores);
           model.addColumn("id_Proovedor");
           model.addColumn("Nombre_Producto");
           model.addColumn("Dirección");
           model.addColumn("No.Telefónico");
           model.addColumn("Estado");
           
           while(rs.next()){
               Object fila[] = new Object[5];
                for(int i =0; i<5; i++){
                    fila[i] = rs.getObject(i+1);
                }
                model.addRow(fila);
           }
           con.close();
            
        } catch (SQLException e) {
            System.out.println("Error la llenar la tabla de proovedores");
        }
        
        jTable1_proovedores.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                int fila_point =jTable1_proovedores.rowAtPoint(e.getPoint());
                int columna_point =0;
                
                if(fila_point > -1){
                    idProovedor = (int) model.getValueAt(fila_point, columna_point);
                    EnviarDatosProovedorSeleccionado(idProovedor);
                }
            }
        
        });
              
    }
        private void EnviarDatosProovedorSeleccionado(int idProovedor){
            try {
                Connection con = conexionBD.conectar();
                PreparedStatement pst = con.prepareStatement("select * from `proovedores`where `id_proovedor`='"+idProovedor+"'");
                ResultSet rs = pst.executeQuery();
                
                if(rs.next()){
                    txt_nombre_proovedor.setText(rs.getString("nombre_proovedor"));
                    txt_direccion_proovedor.setText(rs.getString("direccion_proovedor"));
                    txt_telefono_proovedor.setText(rs.getString("no.telefonico_proovedor"));
                }
                con.close();
                
            } catch (SQLException e) {
            System.out.println("Error al seleccionar proovedor");
        }
        }


}
