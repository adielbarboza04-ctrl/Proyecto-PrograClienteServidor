package Conexion;

//Librerias
import java.sql.*;
import javax.swing.JOptionPane;
public class Conexion {
    
    String url="jdbc:mysql://localhost:3306/sistema_facturacion";
    String user="root";
    String password="";

    public Conexion() { //Constructor por defecto
        }
    
    public Connection conectar(){
        //Inicia el metodo conectar
       Connection con=null;
        
        try{//inicio del try para intentar hacer la conexion
            con=DriverManager.getConnection(url, user, password);
            return con;
            
        }//Fin del try
        catch(SQLException ex){
            
            JOptionPane.showMessageDialog(null, "Error: "+ ex.getMessage()+"ERROR" + JOptionPane.ERROR_MESSAGE);
            return con;
        }   
    } //Fin metodo conectar
    
}

