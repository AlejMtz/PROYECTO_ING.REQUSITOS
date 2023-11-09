
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class conexionBD {
    
    Connection cn= null;
    
    public static Connection conectar(){
        
        try{
        
       Connection cn=(Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1/veterinariaa","root","")  ;
       return cn;
                
        }catch(SQLException e){
            System.out.println("Error de Conexion"+e);                     
        }     
        return null;
    }
}
