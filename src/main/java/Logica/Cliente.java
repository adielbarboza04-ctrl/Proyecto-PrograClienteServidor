package Logica;

import Conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class Cliente {
    
    //Attributes
    
    private int id_cliente;
    private String nombreCliente;
    private String telefonoCliente;
    private String correoCliente;
    
    
    //Builders

    public Cliente() {
    }

    public Cliente(int id_cliente, String nombreCliente, String telefonoCliente, String correoCliente) {
        this.id_cliente = id_cliente;
        this.nombreCliente = nombreCliente;
        this.telefonoCliente = telefonoCliente;
        this.correoCliente = correoCliente;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getTelefonoCliente() {
        return telefonoCliente;
    }

    public void setTelefonoCliente(String telefonoCliente) {
        this.telefonoCliente = telefonoCliente;
    }

    public String getCorreoCliente() {
        return correoCliente;
    }

    public void setCorreoCliente(String correoCliente) {
        this.correoCliente = correoCliente;
    }

    

    
    
    public int contarRegistros(){
        
        int contador = 0;
        
       try{
          PreparedStatement query = new Conexion().conectar().
            prepareStatement("select * from Cliente"); 
            ResultSet tbl = query.executeQuery(); 
            
            while(tbl.next())
            { 
            contador++; 
            }
            return contador;
        }
        catch(SQLException e)
        {           
                e.printStackTrace();
                return contador;
       } 
    }
    
    public void listar(JTable tblCurso){
        
        int indice;
        
        DefaultTableModel tabla = new DefaultTableModel();
        tabla.addColumn("ID CLIENTE");
        tabla.addColumn("NOMBRE");
        tabla.addColumn("CORREO");
        tabla.addColumn("TELEFONO");
        tabla.setRowCount(contarRegistros());
            
         try{
             PreparedStatement query = new Conexion().conectar().
            prepareStatement("select * from Cliente"); 
            ResultSet tbl = query.executeQuery();
             
             indice=0; 
            while(tbl.next())
            { 
            tabla.setValueAt(tbl.getInt("id_cliente"),indice,0); 
            tabla.setValueAt(tbl.getString("nombreCliente"),indice,1);
            tabla.setValueAt(tbl.getInt("telefonoCliente"),indice,2);
            tabla.setValueAt(tbl.getInt("correoCliente"),indice,3);
            indice++; 
            }
        }
            catch(SQLException e)
            {
                e.printStackTrace();
            }
     tblCurso.setModel(tabla);
    }
            
     public void Agregar(){
         
         Conexion con = new Conexion();
         
         try {
           String sql = "INSERT INTO cliente (nombre_cliente, telefonoCliente, correoCliente) VALUES (?,?,?)";
           PreparedStatement pstmt = con.conectar().prepareStatement(sql); 
           pstmt.setInt(1, getId_cliente()); 
           pstmt.setString(2, getNombreCliente());
            pstmt.setString(3, getTelefonoCliente());
            pstmt.setString(4, getCorreoCliente());
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cliente agregado con éxito");
       } 
       catch (SQLException e) 
        {
           JOptionPane.showMessageDialog(null, e.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
        }

     }
    
     public void Actualizar(){
         
         Conexion con = new Conexion();
         
         try {
           String sql = "UPDATE cliente SET nombre_cliente =?, telefonoCliente()=?, correoCliente=? WHERE id_cliente=?";
           PreparedStatement pstmt = con.conectar().prepareStatement(sql);
           pstmt.setInt(1, getId_cliente()); 
           pstmt.setString(2, getNombreCliente());
            pstmt.setString(3, getTelefonoCliente());
            pstmt.setString(4, getCorreoCliente());
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cliente actualizado con éxito");
       } 
       catch (SQLException e) 
        {
           JOptionPane.showMessageDialog(null, e.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
        }

     }
     
     public void Eliminar(){
         
         Conexion con = new Conexion();
         
         try {
           String sql = "DELETE FROM Curso where id_cliente=?";
           PreparedStatement pstmt = con.conectar().prepareStatement(sql); 
            pstmt.setInt(1, getId_cliente());
            pstmt.executeUpdate();
       } 
       catch (SQLException e) 
        {
           JOptionPane.showMessageDialog(null, e.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
        }

     }
}
