package Logica;

import Conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class Habitacion {
    
    //Attributes
    private int id_habitacion;
    private String tipoHabitacion;
    private double precio_noche;
    private String estadoHabitacion;
    
    //Builders

    public Habitacion() {
    }

    public Habitacion(int id_habitacion, String tipoHabitacion, int precio_noche, String estadoHabitacion) {
        this.id_habitacion = id_habitacion;
        this.tipoHabitacion = tipoHabitacion;
        this.precio_noche = precio_noche;
        this.estadoHabitacion = estadoHabitacion;
    }
    
    //Methods to access

    public int getId_habitacion() {
        return id_habitacion;
    }

    public void setId_habitacion(int id_habitacion) {
        this.id_habitacion = id_habitacion;
    }

    public String getTipoHabitacion() {
        return tipoHabitacion;
    }

    public void setTipoHabitacion(String tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
    }

    public double getPrecio_noche() {
        return precio_noche;
    }

    public void setPrecio_noche(double precio_noche) {
        this.precio_noche = precio_noche;
    }

    public String getEstadoHabitacion() {
        return estadoHabitacion;
    }

    public void setEstadoHabitacion(String estadoHabitacion) {
        this.estadoHabitacion = estadoHabitacion;
    }
    
    public int contarRegistros(){
        
        int contador = 0;
        
       try{
          PreparedStatement query = new Conexion().conectar().
            prepareStatement("select * from Habitacion"); 
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
        tabla.addColumn("ID HABITACION");
        tabla.addColumn("TIPO");
        tabla.addColumn("PRECIO");
        tabla.addColumn("ESTADO");
        tabla.setRowCount(contarRegistros());
            
         try{
             PreparedStatement query = new Conexion().conectar().
            prepareStatement("select * from Habitacion"); 
            ResultSet tbl = query.executeQuery();
             
             indice=0; 
            while(tbl.next())
            { 
            tabla.setValueAt(tbl.getInt("id_habitacion"),indice,0); 
            tabla.setValueAt(tbl.getString("tipoHabitacion"),indice,1);
            tabla.setValueAt(String.valueOf(tbl.getDouble("precio_noche")), indice, 2);
            tabla.setValueAt(tbl.getInt("estadoHabitacion"),indice,3);
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
           String sql = "INSERT INTO habitacion (tipoHabitacion, precio_noche, estadoHabitacion) VALUES (?,?,?)";
           PreparedStatement pstmt = con.conectar().prepareStatement(sql); 
           pstmt.setInt(1, getId_habitacion()); 
           pstmt.setString(2, getTipoHabitacion());
            pstmt.setDouble(3, getPrecio_noche());
            pstmt.setString(4, getEstadoHabitacion());
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Habitacion agregada con éxito");
       } 
       catch (SQLException e) 
        {
           JOptionPane.showMessageDialog(null, e.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
        }

     }
    
     public void Actualizar(){
         
         Conexion con = new Conexion();
         
         try {
           String sql = "UPDATE cliente SET tipoHabitacion=?, precio_noche=?, estadoHabitacion=? WHERE id_cliente=?";
           PreparedStatement pstmt = con.conectar().prepareStatement(sql);
           pstmt.setInt(1, getId_habitacion()); 
           pstmt.setString(2, getTipoHabitacion());
            pstmt.setDouble(3, getPrecio_noche());
            pstmt.setString(4, getEstadoHabitacion());
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Habitacion actualizada con éxito");
       } 
       catch (SQLException e) 
        {
           JOptionPane.showMessageDialog(null, e.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
        }

     }
     
     public void Eliminar(){
         
         Conexion con = new Conexion();
         
         try {
           String sql = "DELETE FROM Curso where id_habitacion=?";
           PreparedStatement pstmt = con.conectar().prepareStatement(sql); 
            pstmt.setInt(1, getId_habitacion());
            pstmt.executeUpdate();
       } 
       catch (SQLException e) 
        {
           JOptionPane.showMessageDialog(null, e.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
        }

     }
    
}
