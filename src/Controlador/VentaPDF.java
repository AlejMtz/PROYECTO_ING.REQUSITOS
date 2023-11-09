
package Controlador;

import Vista.InterFacturacion;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.awt.Font;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.text.Document;


public class VentaPDF {
    
   private String nombreCliente;
   private String cedulaCliente;
   private String telefonoCliente;
   private String direccionCliente;
   private String fechaActual="";
   private String nombreaArchivoPDFVenta="";
   
   //metodo para cargar datos de los cliente
   public void DatosClientes(int idCliente){
       Connection cn= conexion.conexionBD.conectar();
       String sql="select * from cliente where id_cliente='"+idCliente+"'";
       Statement st;
       try {
           st=cn.createStatement();
           ResultSet rs=st.executeQuery(sql);
           while(rs.next()){
               nombreCliente=rs.getString("nombre_cliente")+" " + rs.getString("apellido_cliente");
               cedulaCliente=rs.getString("cedula_cliente");
               telefonoCliente=rs.getString("telefono_cliente");
               direccionCliente=rs.getString("direccion_cliente");
           }
           cn.close();
       } catch (SQLException e) {
           System.out.println("Error al obtener datos del cliente"+e);
       }
              
   }
   
   //metodo para generar reporte de venta
   public void generarFacturaPDF(){
       try {
           //cargar la fecha
           Date date=new Date();
           fechaActual=new SimpleDateFormat("yyyy/MM/dd").format(date);
           //cambiar el formato de la fecha
           String fechaNueva="";
           for(int i=0; i<fechaActual.length(); i++){
               if(fechaActual.charAt(i)=='/'){
                   fechaNueva=fechaActual.replace("/", "_");
               }
           }
           
           nombreaArchivoPDFVenta="Venta_"+nombreCliente+"_"+fechaNueva+".pdf";
           
           FileOutputStream archivo;
           File file=new File("src/pdf/"+nombreaArchivoPDFVenta);
           archivo=new FileOutputStream(file);
           
           com.itextpdf.text.Document doc=new com.itextpdf.text.Document();
           PdfWriter.getInstance(doc, archivo);
           doc.open();
           
           Image img = Image.getInstance("src/img/venta.png");
           Paragraph fecha=new Paragraph();
           com.itextpdf.text.Font negrita = new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.TIMES_ROMAN,12,Font.BOLD,BaseColor.BLUE);
           fecha.add(Chunk.NEWLINE); //agregar nueva linea
           fecha.add("Factura: 001"+"\nFecha: "+fechaActual + "\n\n");
           
           PdfPTable Encabezado = new PdfPTable(4);
           Encabezado.setWidthPercentage(100);
           Encabezado.getDefaultCell().setBorder(0);//quitar borde de latabla
           //tamaño de las celdas
           float[] ColumnaEncabezado= new float[]{20f,30f,70f,40f};
           Encabezado.setWidths(ColumnaEncabezado);
           Encabezado.setHorizontalAlignment(Element.ALIGN_LEFT);
           //agregar celdas
           Encabezado.addCell(img);
           String ruc="012345678"; //camviar
           String nombre="Veterinaria PET LIFE´S";
           String telefono="84551456";
           String direccion="Toluca,Edomex"; //completar
           
           Encabezado.addCell(""); //celda vacia
           Encabezado.addCell("RUC: "+ ruc + "\nNOMBRE: "+nombre+"\nTELEFONO:" +telefono+ "\nDIRECCION: "+direccion+"\n");
           Encabezado.addCell(fecha);
           doc.add(Encabezado);
           
           //cuerpo
           Paragraph cliente= new Paragraph();
          cliente.add(Chunk.NEWLINE);
          cliente.add("Datos del cliente: \n\n");
          doc.add(cliente);
          //datos del cliente
          PdfPTable tablaCliente=new PdfPTable(4);
          tablaCliente.setWidthPercentage(100);
          tablaCliente.getDefaultCell().setBorder(0);
          //tamaño de las celdas
          float [] columnaCliente=new float []{25f,45f,30f,40f};
          tablaCliente.setWidths(columnaCliente);
          tablaCliente.setHorizontalAlignment(Element.ALIGN_LEFT);
          PdfPCell cliente1 =new PdfPCell(new Phrase("Cedula/RUC: ",negrita));
          PdfPCell cliente2 =new PdfPCell(new Phrase("Nombre: ",negrita));
          PdfPCell cliente3 =new PdfPCell(new Phrase("Telefono: ",negrita));
          PdfPCell cliente4 =new PdfPCell(new Phrase("Direccion: ",negrita));
          
          //quitamos bordes
          cliente1.setBorder(0);
          cliente2.setBorder(0);
          cliente3.setBorder(0);
          cliente4.setBorder(0);
          //agrgamos celda a la tabla
          tablaCliente.addCell(cliente1);
          tablaCliente.addCell(cliente2);
          tablaCliente.addCell(cliente3);
          tablaCliente.addCell(cliente4);
          tablaCliente.addCell(cedulaCliente);
          tablaCliente.addCell(nombreCliente);
          tablaCliente.addCell(telefonoCliente);
          tablaCliente.addCell(direccionCliente);
          //agreganos a la ttabla
          doc.add(tablaCliente);
          //espacio en blanco
           Paragraph espacio= new Paragraph();
           espacio.add(Chunk.NEWLINE);
           espacio.add("");
           espacio.setAlignment(Element.ALIGN_CENTER);
           doc.add(espacio);
            //agrgar productos
            PdfPTable tablaProducto=new PdfPTable(4);
            tablaProducto.setWidthPercentage(100);
            tablaProducto.getDefaultCell().setBorder(0);
               //tamaño de las celdas 
          float [] columnaProducto=new float[]{15f,50f,15f,20f};
          tablaProducto.setWidths(columnaProducto);
          tablaProducto.setHorizontalAlignment(Element.ALIGN_LEFT);
          PdfPCell producto1=new PdfPCell(new Phrase("Cantidad",negrita));  
          PdfPCell producto2=new PdfPCell(new Phrase("Descripción",negrita));  
          PdfPCell producto3=new PdfPCell(new Phrase("Precio Unitario",negrita));  
          PdfPCell producto4=new PdfPCell(new Phrase("Precio Total",negrita));  

           //quitamos bordes
          producto1.setBorder(0);
          producto2.setBorder(0);
          producto3.setBorder(0);
          producto4.setBorder(0);
          //agrgamos color al encabexzado
          producto1.setBackgroundColor(BaseColor.LIGHT_GRAY);
          producto2.setBackgroundColor(BaseColor.LIGHT_GRAY);
          producto3.setBackgroundColor(BaseColor.LIGHT_GRAY);
          producto4 .setBackgroundColor(BaseColor.LIGHT_GRAY);
          //agregar celda a la tabla
          tablaProducto.addCell(producto1);
          tablaProducto.addCell(producto2);
          tablaProducto.addCell(producto3);
          tablaProducto.addCell(producto4);
          
          for(int i=0; i<InterFacturacion.jTable_productos.getRowCount(); i++){
                String producto= InterFacturacion.jTable_productos.getValueAt(i, 1).toString();
                String cantidad= InterFacturacion.jTable_productos.getValueAt(i, 2).toString();
                String precio= InterFacturacion.jTable_productos.getValueAt(i, 3).toString();
                String total= InterFacturacion.jTable_productos.getValueAt(i, 7).toString();
                
                tablaProducto.addCell(cantidad);
                tablaProducto.addCell(producto);
                tablaProducto.addCell(precio);
                tablaProducto.addCell(total);
           
          }
           //agregar al documento
           doc.add(tablaProducto);
           
           //total a pagra
           Paragraph info= new Paragraph();
           info.add(Chunk.NEWLINE);
           info.add("Total a pagar: "+InterFacturacion.txt_total_pagar.getText());
           info.setAlignment(Element.ALIGN_RIGHT);
           doc.add(info);
           
           //firma
           Paragraph firma= new Paragraph();
           firma.add(Chunk.NEWLINE);
           firma.add("Cancelacion/Firma: \n\n");
           firma.add("______________________");
           firma.setAlignment(Element.ALIGN_CENTER);
           doc.add(firma);
           
           //agregar comentario
           Paragraph mensaje= new Paragraph();
           mensaje.add(Chunk.NEWLINE);
           mensaje.add("Gracias por su preferencia \n\n");    
           mensaje.setAlignment(Element.ALIGN_CENTER);
           doc.add(mensaje);
           
           //cerrar documento y archivo
           doc.close();
           archivo.close();
          
           //abrir el documento una vez generado
           Desktop.getDesktop().open(file);
           
           
                   
           
            
            
       } catch (DocumentException | IOException e) {
           System.out.println("Error en: "+e);
       }
   }
   
}
