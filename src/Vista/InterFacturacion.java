/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.Ctrl_RegistroVenta;
import Controlador.VentaPDF;
import Modelo.CabeceraVenta;
import Modelo.DetalleVenta;
import com.itextpdf.text.BadElementException;
import com.mysql.cj.protocol.Resultset;
import java.awt.Dimension;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class InterFacturacion extends javax.swing.JInternalFrame {
    
    //modelo de datos
    private DefaultTableModel modeloDatosProductos;
    //listapara el deatlle de venta de productos
    ArrayList<DetalleVenta> listaProductos=new ArrayList<>();
    private DetalleVenta producto;
    
    private int idCliente=0; //id cliente seleccionado
    
    
    private int idProducto=0; //cantidad de porodyctos a comprar
    private String nombre=""; //cantidad por precio
    private int cantidadProductoBBDD=0;
    private double precioUnitario=0.0;
    private int porcentajeIva=0;
    
     private int cantidad=0;
        private double subtotal=0.0;
        private double descuento=0.0;
        private double iva=0.0;
        private double totalPagar=0.0;
        
        //variables para calculos globales
        private double subtotalGeneral=0.0;
        private double descuentoGeneral=0.0;
        private double ivaGeneral=0.0;
        private double totalPagarGeneral=0.0;
        //fin de variables calculo globales
        
        private int auxIdDetalle=1; //id del detalle xde la venta

    public InterFacturacion() {
        initComponents();
        this.setSize(new Dimension(800, 630));
        this.setTitle("Facturación");

        //carga los clientes en la lisra
        this.CargarComboClientes();
        
        //carga los clientes en la lisra
        this.CargarComboProductos();
        
        this.inicializarTablaProducto();
        
        txt_efectivo.setEnabled(false);
        boton_calcular_cambio.setEnabled(true);
        
        txt_subtotal.setText("0.0");
        txt_iva.setText("0.0");
        txt_descuento.setText("0.0");
        txt_total_pagar.setText("0.0");
    }
    
   
    //metodo para inicializar tabla de oroductos
    
    private void inicializarTablaProducto(){
        
        modeloDatosProductos=new DefaultTableModel();
        //añadir columnas
        modeloDatosProductos.addColumn("No.");
        modeloDatosProductos.addColumn("Nombre.");
        modeloDatosProductos.addColumn("Cantidad");
        modeloDatosProductos.addColumn("P.Unitario.");
        modeloDatosProductos.addColumn("Subtotal.");
        modeloDatosProductos.addColumn("Descuento");
        modeloDatosProductos.addColumn("IVA.");
        modeloDatosProductos.addColumn("Total a pagar.");
        modeloDatosProductos.addColumn("Accion.");
        //agregara datos del modelo a la tabla
        this.jTable_productos.setModel(modeloDatosProductos);
    }
    
     //metodo para presentar informacion en la tabla
    private void listaTablaProductos(){
        this.modeloDatosProductos.setRowCount(listaProductos.size());
        for(int i=0; i<listaProductos.size(); i++){
            this.modeloDatosProductos.setValueAt(i+1, i, 0);
            this.modeloDatosProductos.setValueAt(listaProductos.get(i).getNombre(), i, 1);
            this.modeloDatosProductos.setValueAt(listaProductos.get(i).getCantidad(), i, 2);
            this.modeloDatosProductos.setValueAt(listaProductos.get(i).getPrecioUnitario(), i, 3);
            this.modeloDatosProductos.setValueAt(listaProductos.get(i).getSubTotal(), i, 4);
            this.modeloDatosProductos.setValueAt(listaProductos.get(i).getDescuento(), i, 5);
            this.modeloDatosProductos.setValueAt(listaProductos.get(i).getIva(), i, 6);
            this.modeloDatosProductos.setValueAt(listaProductos.get(i).getTotalPagar(), i, 7);
            this.modeloDatosProductos.setValueAt("Eliminar", i, 8); //luego agregar un botoonpara eliminar
        }
        
        //añadir al jtabvle
        jTable_productos.setModel(modeloDatosProductos);
    }
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jComboBox_producto = new javax.swing.JComboBox<>();
        jComboBox_cliente = new javax.swing.JComboBox<>();
        txt_cantidad_fac = new javax.swing.JTextField();
        txt_cliente_buscar = new javax.swing.JTextField();
        boton_añadir_producto = new javax.swing.JButton();
        boton_busca_cliente1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_productos = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txt_iva = new javax.swing.JTextField();
        txt_cambio = new javax.swing.JTextField();
        txt_descuento = new javax.swing.JTextField();
        txt_subtotal = new javax.swing.JTextField();
        txt_total_pagar = new javax.swing.JTextField();
        txt_efectivo = new javax.swing.JTextField();
        boton_calcular_cambio = new javax.swing.JButton();
        boton_registrar_venta = new javax.swing.JButton();

        setBackground(new java.awt.Color(160, 126, 227));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Facturación");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 0, -1, 40));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Cliente:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Cantidad:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 110, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Producto:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, -1, -1));

        jComboBox_producto.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jComboBox_producto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione producto:", "Item 2", "Item 3", "Item 4" }));
        jComboBox_producto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_productoActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox_producto, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, 260, 30));

        jComboBox_cliente.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jComboBox_cliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione cliente:", "Item 2", "Item 3", "Item 4" }));
        jComboBox_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_clienteActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox_cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 60, 260, 30));

        txt_cantidad_fac.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(txt_cantidad_fac, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 100, 110, 30));

        txt_cliente_buscar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(txt_cliente_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 60, 150, 30));

        boton_añadir_producto.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        boton_añadir_producto.setText("Añadir Producto");
        boton_añadir_producto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_añadir_productoActionPerformed(evt);
            }
        });
        getContentPane().add(boton_añadir_producto, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 100, -1, 30));

        boton_busca_cliente1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        boton_busca_cliente1.setText("Buscar");
        boton_busca_cliente1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_busca_cliente1ActionPerformed(evt);
            }
        });
        getContentPane().add(boton_busca_cliente1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 60, -1, 30));

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable_productos.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable_productos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_productosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_productos);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 720, 210));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 760, 250));

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Cambio:");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("IVA:");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Descuento:");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Subtotal:");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Efectivo:");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, -1, 10));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Total a pagar:");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, -1));

        txt_iva.setEditable(false);
        jPanel2.add(txt_iva, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, 160, 22));

        txt_cambio.setEditable(false);
        jPanel2.add(txt_cambio, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 160, 140, 22));

        txt_descuento.setEditable(false);
        jPanel2.add(txt_descuento, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, 120, 22));

        txt_subtotal.setEditable(false);
        jPanel2.add(txt_subtotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, 120, 22));

        txt_total_pagar.setEditable(false);
        jPanel2.add(txt_total_pagar, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 110, 22));
        jPanel2.add(txt_efectivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 130, 140, 22));

        boton_calcular_cambio.setBackground(new java.awt.Color(153, 204, 255));
        boton_calcular_cambio.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        boton_calcular_cambio.setText("Calcular cambio");
        boton_calcular_cambio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_calcular_cambioActionPerformed(evt);
            }
        });
        jPanel2.add(boton_calcular_cambio, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 80, 130, 40));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 400, 410, 190));

        boton_registrar_venta.setBackground(new java.awt.Color(153, 204, 255));
        boton_registrar_venta.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        boton_registrar_venta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-impresora-de-etiquetas-48.png"))); // NOI18N
        boton_registrar_venta.setText("Registrar Venta");
        boton_registrar_venta.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        boton_registrar_venta.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        boton_registrar_venta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_registrar_ventaActionPerformed(evt);
            }
        });
        getContentPane().add(boton_registrar_venta, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 420, 170, 100));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boton_busca_cliente1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_busca_cliente1ActionPerformed
        
        String clienteBuscar=txt_cliente_buscar.getText().trim();
        Connection cn=conexion.conexionBD.conectar();
        String sql ="Select nombre_cliente, apellido_cliente from cliente where cedula_cliente='"+clienteBuscar+"'";
        Statement st;
        try {
            st=cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                jComboBox_cliente.setSelectedItem(rs.getString("nombre_cliente") + " " +rs.getString("apellido_cliente"));
            }else{
                jComboBox_cliente.setSelectedItem("Seleccione cliente:");
                JOptionPane.showMessageDialog(null, "Cedula de cliente incorrecta o no encontrada");
            }
             txt_cliente_buscar.setText("");
             cn.close();
        } catch (SQLException e) {
            System.out.println("Error al buscar cliente"+e);
        }
        
        
    }//GEN-LAST:event_boton_busca_cliente1ActionPerformed

    private void boton_añadir_productoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_añadir_productoActionPerformed
        
        String combo=this.jComboBox_producto.getSelectedItem().toString();
        //validar que seleccione un producto
        if(combo.equalsIgnoreCase("Seleccione producto:")){
            JOptionPane.showMessageDialog(null, "Seleccione un producto");
        }else{
            //validar que ingrese cantidad
            if(!txt_cantidad_fac.getText().isEmpty()){
                //validar que no se ingresen caracteres no numericos
                boolean validacion=validar(txt_cantidad_fac.getText());
                if(validacion==true){
                    //validar que la cantidad sea mayor a cero
                    if(Integer.parseInt(txt_cantidad_fac.getText())>0){
                        cantidad=Integer.parseInt(txt_cantidad_fac.getText());
                        //ejecutar el metodo para obtener sdatos del producto
                        
                        this.DatosDelProducto();
                        //validar que la cantidad del producto seleccionado no se mayor al stock de la base de datos
                        if(cantidad<=cantidadProductoBBDD){
                            
                            subtotal=precioUnitario*cantidad;
                            totalPagar=subtotal+iva+descuento;
                            
                            //redondear decimales
                            subtotal=(double) Math.round(subtotal*100)/100;
                            iva=(double) Math.round(iva*100)/100;
                            descuento=(double) Math.round(descuento*100)/100;
                            totalPagar=(double) Math.round(totalPagar*100)/100;
                            
                            //se crea un nuevo producto
                            producto=new DetalleVenta(auxIdDetalle,
                                    1, //iDcabecera
                                    idProducto,
                                    nombre,
                                    Integer.parseInt(txt_cantidad_fac.getText()),
                                    precioUnitario,
                                    subtotal,
                                    descuento,
                                    iva,
                                    totalPagar,
                                    1//estado
                                );
                            //añadir a la lista
                            listaProductos.add(producto);
                           JOptionPane.showMessageDialog(null, "Producto agregado");
                           auxIdDetalle++;
                           txt_cantidad_fac.setText(""); //limpiar el campo
                           //volver a cargar el combo productos
                           this.CargarComboProductos();
                           this.CalcularTotalPagar();
                           txt_efectivo.setEnabled(true);

                        }else{
                            JOptionPane.showMessageDialog(null, "La cantidad supera al stock almacenado");
                        }
                    }else{
                        JOptionPane.showMessageDialog(null, "La cantidad no puede ser menor o igual a cero");
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "No se admiten caracteres no numericos");
                }
            }else{
                JOptionPane.showMessageDialog(null, "Ingrese una cantidad de productos");
            }
        }
        this.listaTablaProductos();
        
    }//GEN-LAST:event_boton_añadir_productoActionPerformed

    private void jComboBox_productoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_productoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox_productoActionPerformed

    private void boton_calcular_cambioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_calcular_cambioActionPerformed
        
        if(!txt_efectivo.getText().isEmpty()){
            //validamos que el usuario no ingrese otros caracteres no numericos
            boolean validacion=validarDouble(txt_efectivo.getText());
            if(validacion==true){
                //validar el efectivo sea mayor a cero
                double efc=Double.parseDouble(txt_efectivo.getText().trim());
                double top=Double.parseDouble(txt_total_pagar.getText().trim());
                
                if(efc<top){
                    JOptionPane.showMessageDialog(null, "El dinero en efectivo no es suficiente");
                }else{
                    double cambio =(efc-top);
                    double cambi=(double) Math.round(cambio*100)/100;
                    String camb=String.valueOf(cambi);
                    txt_cambio.setText(camb);
                }
            }else{
                JOptionPane.showMessageDialog(null, "No se admiten caracteres no numericos");
            }
            
        }else{
          JOptionPane.showMessageDialog(null, "Ingrese dinero efectivo para calcular cambio");
        }
        
    }//GEN-LAST:event_boton_calcular_cambioActionPerformed

    int idArrayList=0;
    
    private void jTable_productosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_productosMouseClicked
       
        int fila_point=jTable_productos.rowAtPoint(evt.getPoint());
        int columna_point=0;
        
        if(fila_point>-1){
            idArrayList=(int) modeloDatosProductos.getValueAt(fila_point, columna_point);
        }
        int opcion=JOptionPane.showConfirmDialog(null, "¿Desea eliminar el producto?");
        //opciones de confirmacion si=0  no=1   cancel=2  close=-1
        switch(opcion){
            case 0:
                listaProductos.remove(idArrayList -1);
                this.CalcularTotalPagar();
                this.listaTablaProductos();
                break;
            case 1:
                break;
            default: //sea lo que oprecione cancle (2) o close (-1)
                break;
        }
        
        
    }//GEN-LAST:event_jTable_productosMouseClicked

    private void boton_registrar_ventaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_registrar_ventaActionPerformed
        
        CabeceraVenta cabeceraVenta=new CabeceraVenta();
        DetalleVenta detalleVenta=new DetalleVenta ();
        Ctrl_RegistroVenta controlVenta=new Ctrl_RegistroVenta();
        
        String fechaActual="";
        Date date=new Date();
        fechaActual=new SimpleDateFormat("yyyy/MM/dd").format(date);
        
        if(!jComboBox_cliente.getSelectedItem().equals("Seleccione cliente:")){
            if(listaProductos.size()>0){
                
                //metodo para obtener el id del cliente
                this.ObtenerIdCliente();
                //regsitrar la cabecera
                cabeceraVenta.setIdCabeceravaneta(0);
                cabeceraVenta.setIdCliente(idCliente);
                cabeceraVenta.setValorPagar(Double.parseDouble(txt_total_pagar.getText()));
                cabeceraVenta.setFechaVenta(fechaActual);
                cabeceraVenta.setEstado(1);
                
                if(controlVenta.guardar(cabeceraVenta)){
                     JOptionPane.showMessageDialog(null, "Venta registrada");
                     
                     //generar la factura de venta
                     VentaPDF pdf= new VentaPDF();
                     pdf.DatosClientes(idCliente);
                    pdf.generarFacturaPDF();
                    
                     
                     //guardar detalle
                     for(DetalleVenta elemento: listaProductos){
                         detalleVenta.setIdDetalleVenta(0);
                         detalleVenta.setIdCabeceraVenta(0);
                         detalleVenta.setIdProducto(elemento.getIdProducto());
                         detalleVenta.setCantidad(elemento.getCantidad());
                         detalleVenta.setPrecioUnitario(elemento.getPrecioUnitario());
                         detalleVenta.setSubTotal(elemento.getSubTotal());
                         detalleVenta.setDescuento(elemento.getDescuento());
                         detalleVenta.setIva(elemento.getIva());
                         detalleVenta.setTotalPagar(elemento.getTotalPagar());
                         detalleVenta.setEstado(1);
                         if(controlVenta.guardarDetalle(detalleVenta)){
                             System.out.println("Detalle de venta registrado");
                             
                             txt_subtotal.setText("0.0");
                             txt_iva.setText("0.0");
                             txt_descuento.setText("0.0");
                             txt_total_pagar.setText("0.0");
                             txt_efectivo.setText("0.0");
                             txt_cambio.setText("0.0");
                             auxIdDetalle=1;
                             
                             this.CargarComboClientes();
                             this.RestarStockProdutos(elemento.getIdProducto(),elemento.getCantidad());
                             
                         }else{
                             JOptionPane.showMessageDialog(null, "Error al guardar detalle de venta");
                         }
                     }
                     //vaciamos la lista
                     listaProductos.clear();
                     listaTablaProductos();
                     
                }else{
                    JOptionPane.showMessageDialog(null, "Error al guardar cabecera"); 
                }
            }else{
                JOptionPane.showMessageDialog(null, "Seleccione un producto");
            }
    }else{
            JOptionPane.showMessageDialog(null, "Seleccione un cliente");
            }
        
    }//GEN-LAST:event_boton_registrar_ventaActionPerformed

    private void jComboBox_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_clienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox_clienteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boton_añadir_producto;
    private javax.swing.JButton boton_busca_cliente1;
    private javax.swing.JButton boton_calcular_cambio;
    private javax.swing.JButton boton_registrar_venta;
    private javax.swing.JComboBox<String> jComboBox_cliente;
    private javax.swing.JComboBox<String> jComboBox_producto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    public static javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable jTable_productos;
    private javax.swing.JTextField txt_cambio;
    private javax.swing.JTextField txt_cantidad_fac;
    private javax.swing.JTextField txt_cliente_buscar;
    private javax.swing.JTextField txt_descuento;
    private javax.swing.JTextField txt_efectivo;
    private javax.swing.JTextField txt_iva;
    private javax.swing.JTextField txt_subtotal;
    public static javax.swing.JTextField txt_total_pagar;
    // End of variables declaration//GEN-END:variables

//metodo cargar clientes en el combo box
    private void CargarComboClientes() {
        Connection cn = conexion.conexionBD.conectar();
        String sql = "select * from cliente";
        Statement st;

        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            jComboBox_cliente.removeAllItems();
            jComboBox_cliente.addItem("Seleccione cliente:");
            while (rs.next()) {
                jComboBox_cliente.addItem(rs.getString("nombre_cliente") + " " + rs.getString("apellido_cliente"));
            }
            cn.close();

        } catch (SQLException e) {
            System.out.println("Error al cargar clientes" + e);
        }
    }

//metodo cargar clientes en el combo box
    
    private void CargarComboProductos(){
        Connection cn = conexion.conexionBD.conectar();
        String sql = "select * from productos";
        Statement st;

        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            jComboBox_producto.removeAllItems();
            jComboBox_producto.addItem("Seleccione producto:");
            while (rs.next()) {
                jComboBox_producto.addItem(rs.getString("nombre_producto"));
            }
            cn.close();

        } catch (SQLException e) {
            System.out.println("Error al cargar productos" + e);
        }
    }
    
    //metodo para validar que el usuario no ingrese caracteres no numericos
    private boolean validar(String valor){
        try {
            int num = Integer.parseInt(valor);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
//metodo para validar que el usuario no ingrese caracteres no numericos
    private boolean validarDouble(String valor){
        try {
            double num = Double.parseDouble(valor);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    
    //metodo para mostrar los datos del producto
    private void DatosDelProducto(){
        try {
            String sql="select * from productos where nombre_producto= '"+this.jComboBox_producto.getSelectedItem() +"'";
             Connection cn=conexion.conexionBD.conectar();
             Statement st;
             st=cn.createStatement();
             ResultSet rs=st.executeQuery(sql);
             while(rs.next()){
                 idProducto=rs.getInt("id_producto");
                 nombre=rs.getString("nombre_producto");
                 cantidadProductoBBDD=rs.getInt("cantidad");
                 precioUnitario=rs.getDouble("precio_producto");
                 porcentajeIva=rs.getInt("porcentaje_iva");
                 this.CalcularIva(precioUnitario,porcentajeIva); //calcula y retorna el iva
             }
            
        } catch (SQLException e) {
            System.out.println("Error al obtener datos del producto" +e);
        }
    }
    
    //metodo para calcular iva
    private double CalcularIva(double precio, int porcentajeIva){
     int p_iva=porcentajeIva;
     
     switch(p_iva){
         case 0:
             iva=0.0;
             break;
         case 16:
             iva=(precio*cantidad)*0.16;
             break;
         default:
             break;
     }
     return iva;
    }
    //metodo para calcular total a pagar todos los productos agregados
    private void CalcularTotalPagar(){
        subtotalGeneral=0;
        descuentoGeneral=0;
        ivaGeneral=0;
        totalPagarGeneral=0;
        
        for(DetalleVenta elemento : listaProductos){
            subtotalGeneral+=elemento.getSubTotal();
            descuentoGeneral+=elemento.getDescuento();
            ivaGeneral+=elemento.getIva();
            totalPagarGeneral+=elemento.getTotalPagar();
        }
        
        //redonder decimal
        subtotalGeneral=(double) Math.round(subtotalGeneral*100)/100;
        ivaGeneral=(double) Math.round(ivaGeneral*100)/100;
        descuentoGeneral=(double) Math.round(descuentoGeneral*100)/100;
        totalPagarGeneral=(double) Math.round(totalPagarGeneral*100)/100;
        
        //enviar datos a vista
        txt_subtotal.setText(String.valueOf(subtotalGeneral));
        txt_iva.setText(String.valueOf(ivaGeneral));
        txt_descuento.setText(String.valueOf(descuentoGeneral));
        txt_total_pagar.setText(String.valueOf(totalPagarGeneral));
    }
    //metodo para obtener id cliente
    private void ObtenerIdCliente(){
        try {
            String sql="select * from cliente where concat(nombre_cliente,' ', apellido_cliente)='"+this.jComboBox_cliente.getSelectedItem()+"'";
            Connection cn = conexion.conexionBD.conectar();
            Statement st;
            st=cn.createStatement();
            ResultSet rs=st.executeQuery(sql);
            while(rs.next()){
                idCliente=rs.getInt("id_cliente");
            }
                   
                   
        } catch (SQLException e) {
            System.out.println("Error al obtener id del cliente");
        }
    }
    //metodo para restar cantidad al stock
    private void RestarStockProdutos(int idProducto, int cantidad){
        int cantidadProductosBaseDeDatos=0;
        try {
            Connection cn = conexion.conexionBD.conectar();
            String sql="Select `id_producto`,`cantidad` from `productos` where `id_producto`='"+idProducto+"'";
            Statement st;
            st= cn.createStatement();
            ResultSet rs=st.executeQuery(sql);
            while(rs.next()){
                cantidadProductosBaseDeDatos=rs.getInt("cantidad");
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al restar cantidad 1"+e);
        }
        try {
            Connection cn=conexion.conexionBD.conectar();
            PreparedStatement consulta=cn.prepareStatement("update `productos` set `cantidad`=? where `id_producto`='"+idProducto+"'");
            int cantidadNueva=cantidadProductosBaseDeDatos-cantidad;
            consulta.setInt(1, cantidadNueva);
            if(consulta.executeUpdate()>0){
                System.out.println("Todo bien");
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al restar cantidad 2"+e);
        }
    }
    
}
