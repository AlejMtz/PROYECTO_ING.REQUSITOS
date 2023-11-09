
package Controlador;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.text.Document;


public class Reportes {
    
    //metodo para crear reportes de los clientes registrados
    
    public void reportesClientes(){
    
        com.itextpdf.text.Document documento = new com.itextpdf.text.Document();
        try {
            String ruta= System.getProperty("user.home");
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/Reportes_Clientes.pdf"));
            Image header= Image.getInstance("src/img/header.jpg");
            header.scaleToFit(650,1000);
            header.setAlignment(Chunk.ALIGN_CENTER);
            
            //formato al texto
            Paragraph parrafo = new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo.add("\nReporte elaborado por Veterinatria Pet´s Life\n\n");
            parrafo.setFont(FontFactory.getFont("Tahoma", 18, Font.BOLD, BaseColor.DARK_GRAY));
            parrafo.add("Reporte de clientes \n\n");
            
            documento.open();
            //agregamos al documento
            documento.add(header);
            documento.add(parrafo);
            
            PdfPTable tabla = new PdfPTable(5);
              tabla.addCell("Código");
              tabla.addCell("Nombres");
              tabla.addCell("Cédula");
              tabla.addCell("Teléfono");
              tabla.addCell("Dirección");
              
              try {
                
                  Connection cn = conexion.conexionBD.conectar();
                  PreparedStatement pst = cn.prepareStatement("select id_cliente, concat(nombre_cliente, ' ',apellido_cliente) as nombres, cedula_cliente, telefono_cliente, direccion_cliente from cliente;");
                  ResultSet rs= pst.executeQuery();
                  if(rs.next()){
                      do{
                          tabla.addCell(rs.getString(1));
                          tabla.addCell(rs.getString(2));
                          tabla.addCell(rs.getString(3));
                          tabla.addCell(rs.getString(4));
                          tabla.addCell(rs.getString(5));
                      }while(rs.next());
                      documento.add(tabla);
                  }
                  
            } catch (SQLException e) {
                  System.out.println("Error 4  en: "+e);
            }
            documento.close();
            JOptionPane.showMessageDialog(null, "Reporte creado");
            
        } catch (DocumentException e) {
            System.out.println("Error 1 en: "+e);
        } catch (FileNotFoundException ex) {
             System.out.println("Error 2 en: "+ex);
            Logger.getLogger(Reportes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
             System.out.println("Error en: "+ex);
            Logger.getLogger(Reportes.class.getName()).log(Level.SEVERE, null, ex);
        }
        documento.close();
        
}
    
    //metodo para crear reportes de los productos registrados
    
    public void reportesProductos(){
    
        com.itextpdf.text.Document documento = new com.itextpdf.text.Document();
        try {
            String ruta= System.getProperty("user.home");
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/Reportes_Productos.pdf"));
            Image header= Image.getInstance("src/img/header.jpg");
            header.scaleToFit(650,1000);
            header.setAlignment(Chunk.ALIGN_CENTER);
            
            //formato al texto
            Paragraph parrafo = new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo.add("\nReporte elaborado por Veterinatria Pet´s Life\n\n");
            parrafo.setFont(FontFactory.getFont("Tahoma", 18, Font.BOLD, BaseColor.DARK_GRAY));
            parrafo.add("Reporte de productos \n\n");
            
            documento.open();
            //agregamos al documento
            documento.add(header);
            documento.add(parrafo);
            float[] columsWidths={3,5,4,5,12,5,6};
            
            PdfPTable tabla = new PdfPTable(7);
              tabla.addCell("Código");
              tabla.addCell("Nombres");
              tabla.addCell("Cantidad");
              tabla.addCell("Precio");
              tabla.addCell("Descrpción");
              tabla.addCell("Por.Iva");
              tabla.addCell("Proovedor");
              
              try {
                
                  Connection cn = conexion.conexionBD.conectar();
                  PreparedStatement pst = cn.prepareStatement("SELECT p.id_producto, p.nombre_producto, p.cantidad, p.precio_producto, p.descripcion_producto, p.porcentaje_iva, c.nombre_proovedor, p.estado FROM productos as p, proovedores as c WHERE p.id_proovedor = c.id_proovedor;");
                  ResultSet rs= pst.executeQuery();
                  if(rs.next()){
                      do{
                          tabla.addCell(rs.getString(1));
                          tabla.addCell(rs.getString(2));
                          tabla.addCell(rs.getString(3));
                          tabla.addCell(rs.getString(4));
                          tabla.addCell(rs.getString(5));
                          tabla.addCell(rs.getString(6));
                          tabla.addCell(rs.getString(7));
                      }while(rs.next());
                      documento.add(tabla);
                  }
                  
            } catch (SQLException e) {
                  System.out.println("Error 4  en: "+e);
            }
            documento.close();
            JOptionPane.showMessageDialog(null, "Reporte creado");
            
        } catch (DocumentException e) {
            System.out.println("Error 1 en: "+e);
        } catch (FileNotFoundException ex) {
             System.out.println("Error 2 en: "+ex);
            Logger.getLogger(Reportes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
             System.out.println("Error en: "+ex);
            Logger.getLogger(Reportes.class.getName()).log(Level.SEVERE, null, ex);
        }
        documento.close();
        
}
    
    
    //metodo para crear reportes de los proovedores registrados
    
    public void reportesProovedores(){
    
        com.itextpdf.text.Document documento = new com.itextpdf.text.Document();
        try {
            String ruta= System.getProperty("user.home");
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/Reportes_Proovedores.pdf"));
            Image header= Image.getInstance("src/img/header.jpg");
            header.scaleToFit(650,1000);
            header.setAlignment(Chunk.ALIGN_CENTER);
            
            //formato al texto
            Paragraph parrafo = new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo.add("\nReporte elaborado por Veterinatria Pet´s Life\n\n");
            parrafo.setFont(FontFactory.getFont("Tahoma", 18, Font.BOLD, BaseColor.DARK_GRAY));
            parrafo.add("Reporte de proovedores \n\n");
            
            documento.open();
            //agregamos al documento
            documento.add(header);
            documento.add(parrafo);
            float[] columsWidths={3,5,4,5,7};
            
            PdfPTable tabla = new PdfPTable(5);
              tabla.addCell("Código");
              tabla.addCell("Nombres");
              tabla.addCell("Dirección");
              tabla.addCell("Teléfono");
              tabla.addCell("Estado");
    
              
              try {
                
                  Connection cn = conexion.conexionBD.conectar();
                  PreparedStatement pst = cn.prepareStatement("SELECT * from proovedores;");
                  ResultSet rs= pst.executeQuery();
                  if(rs.next()){
                      do{
                          tabla.addCell(rs.getString(1));
                          tabla.addCell(rs.getString(2));
                          tabla.addCell(rs.getString(3));
                          tabla.addCell(rs.getString(4));
                          tabla.addCell(rs.getString(5));
                         
                      }while(rs.next());
                      documento.add(tabla);
                  }
                  
            } catch (SQLException e) {
                  System.out.println("Error 4  en: "+e);
            }
            documento.close();
            JOptionPane.showMessageDialog(null, "Reporte creado");
            
        } catch (DocumentException e) {
            System.out.println("Error 1 en: "+e);
        } catch (FileNotFoundException ex) {
             System.out.println("Error 2 en: "+ex);
            Logger.getLogger(Reportes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
             System.out.println("Error en: "+ex);
            Logger.getLogger(Reportes.class.getName()).log(Level.SEVERE, null, ex);
        }
        documento.close();
        
}
    
    
     //metodo para crear reportes de los proovedores registrados
    
    public void reportesVentas(){
    
        com.itextpdf.text.Document documento = new com.itextpdf.text.Document();
        try {
            String ruta= System.getProperty("user.home");
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/Reportes_Ventas.pdf"));
            Image header= Image.getInstance("src/img/header.jpg");
            header.scaleToFit(650,1000);
            header.setAlignment(Chunk.ALIGN_CENTER);
            
            //formato al texto
            Paragraph parrafo = new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo.add("\nReporte elaborado por Veterinatria Pet´s Life\n\n");
            parrafo.setFont(FontFactory.getFont("Tahoma", 18, Font.BOLD, BaseColor.DARK_GRAY));
            parrafo.add("Reporte de ventas \n\n");
            
            documento.open();
            //agregamos al documento
            documento.add(header);
            documento.add(parrafo);
            float[] columsWidths={3,5,4,5,7};
            
            PdfPTable tabla = new PdfPTable(5);
              tabla.addCell("Código");
              tabla.addCell("Cliente");
              tabla.addCell("Total.Pagar");
              tabla.addCell("Fecha.Ventas");
              tabla.addCell("Estado");
    
              
              try {
                
                  Connection cn = conexion.conexionBD.conectar();
                  PreparedStatement pst = cn.prepareStatement("SELECT cv.id_cabeceraventa AS id, concat(c.nombre_cliente, ' ', c.apellido_cliente) AS cliente, cv.valor_pagar AS total, cv.fecha_venta AS fecha, cv.estado FROM cabecera_venta as cv, cliente as c WHERE cv.id_cliente=c.id_cliente;");
                  ResultSet rs= pst.executeQuery();
                  if(rs.next()){
                      do{
                          tabla.addCell(rs.getString(1));
                          tabla.addCell(rs.getString(2));
                          tabla.addCell(rs.getString(3));
                          tabla.addCell(rs.getString(4));
                          tabla.addCell(rs.getString(5));
                         
                      }while(rs.next());
                      documento.add(tabla);
                  }
                  
            } catch (SQLException e) {
                  System.out.println("Error 4  en: "+e);
            }
            documento.close();
            JOptionPane.showMessageDialog(null, "Reporte creado");
            
        } catch (DocumentException e) {
            System.out.println("Error 1 en: "+e);
        } catch (FileNotFoundException ex) {
             System.out.println("Error 2 en: "+ex);
            Logger.getLogger(Reportes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
             System.out.println("Error en: "+ex);
            Logger.getLogger(Reportes.class.getName()).log(Level.SEVERE, null, ex);
        }
        documento.close();
        
}
    
    
}
