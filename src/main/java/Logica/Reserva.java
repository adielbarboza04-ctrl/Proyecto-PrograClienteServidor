package Logica;

import Conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class Reserva {
    
    //Attributes
    private int id_reserva;
    private int id_cliente;
    private int id_habitacion;
    private String fecha_entrada;
    private String fecha_salida;
    
    //Builders

    public Reserva() {
    }

    public Reserva(int id_reserva, int id_cliente, int id_habitacion, String fecha_entrada, String fecha_salida) {
        this.id_reserva = id_reserva;
        this.id_cliente = id_cliente;
        this.id_habitacion = id_habitacion;
        this.fecha_entrada = fecha_entrada;
        this.fecha_salida = fecha_salida;
    }
    
    //Methods to access

    public int getId_reserva() {
        return id_reserva;
    }

    public void setId_reserva(int id_reserva) {
        this.id_reserva = id_reserva;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getId_habitacion() {
        return id_habitacion;
    }

    public void setId_habitacion(int id_habitacion) {
        this.id_habitacion = id_habitacion;
    }

    public String getFecha_entrada() {
        return fecha_entrada;
    }

    public void setFecha_entrada(String fecha_entrada) {
        this.fecha_entrada = fecha_entrada;
    }

    public String getFecha_salida() {
        return fecha_salida;
    }

    public void setFecha_salida(String fecha_salida) {
        this.fecha_salida = fecha_salida;
    }
    public int contarRegistros(){
        
        int contador = 0;
        
       try{
          PreparedStatement query = new Conexion().conectar().
            prepareStatement("select * from Reserva"); 
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
        tabla.addColumn("ID RESERVA");
        tabla.addColumn("ID CLIENTE");
        tabla.addColumn("ID HABITACION");
        tabla.addColumn("FECHA ENTRADA");
        tabla.addColumn("FECHA SALIDA");
        tabla.setRowCount(contarRegistros());
            
         try{
             PreparedStatement query = new Conexion().conectar().
            prepareStatement("select * from Reserva"); 
            ResultSet tbl = query.executeQuery();
             
             indice=0; 
            while(tbl.next())
            { 
            tabla.setValueAt(tbl.getInt("id_reserva"),indice,0); 
            tabla.setValueAt(tbl.getInt("id_cliente"),indice,1);
            tabla.setValueAt(tbl.getInt("id_habitacion"), indice, 2);
            tabla.setValueAt(tbl.getString("fecha_entrada"),indice,3);
            tabla.setValueAt(tbl.getString("fecha_salida"),indice,4);
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
           String sql = "INSERT INTO reserva (fecha_entrada, fecha_salida) VALUES (?,?,?)";
           PreparedStatement pstmt = con.conectar().prepareStatement(sql); 
           pstmt.setInt(1, getId_reserva()); 
           pstmt.setInt(2, getId_cliente());
           pstmt.setInt(3, getId_habitacion());
           pstmt.setString(4, getFecha_entrada());
           pstmt.setString(5, getFecha_salida());
           pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Reserva agregada con éxito");
       } 
       catch (SQLException e) 
        {
           JOptionPane.showMessageDialog(null, e.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
        }

     }
    
     public void Actualizar(){
         
         Conexion con = new Conexion();
         
         try {
           String sql = "UPDATE reserva SET fecha_entrada=?, fecha_salida=? WHERE id_reserva=?";
           PreparedStatement pstmt = con.conectar().prepareStatement(sql);
           pstmt.setInt(1, getId_reserva()); 
           pstmt.setInt(2, getId_cliente());
           pstmt.setInt(3, getId_habitacion());
           pstmt.setString(4, getFecha_entrada());
           pstmt.setString(4, getFecha_salida());
           pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Reserva actualizada con exito");
       } 
       catch (SQLException e) 
        {
           JOptionPane.showMessageDialog(null, e.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
        }

     }
     
     public void Eliminar(){
         
         Conexion con = new Conexion();
         
         try {
           String sql = "DELETE FROM Reserva where id_reserva=?";
           PreparedStatement pstmt = con.conectar().prepareStatement(sql); 
            pstmt.setInt(1, getId_reserva());
            pstmt.executeUpdate();
       } 
       catch (SQLException e) 
        {
           JOptionPane.showMessageDialog(null, e.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
        }

     }
}
