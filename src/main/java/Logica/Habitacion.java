package Logica;


public class Habitacion {
    
    //Attributes
    private String id_habitacion;
    private String tipoHabitacion;
    private int precio_noche;
    private String estadoHabitacion;
    
    //Builders

    public Habitacion() {
    }

    public Habitacion(String id_habitacion, String tipoHabitacion, int precio_noche, String estadoHabitacion) {
        this.id_habitacion = id_habitacion;
        this.tipoHabitacion = tipoHabitacion;
        this.precio_noche = precio_noche;
        this.estadoHabitacion = estadoHabitacion;
    }
    
    //Methods to access

    public String getId_habitacion() {
        return id_habitacion;
    }

    public void setId_habitacion(String id_habitacion) {
        this.id_habitacion = id_habitacion;
    }

    public String getTipoHabitacion() {
        return tipoHabitacion;
    }

    public void setTipoHabitacion(String tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
    }

    public int getPrecio_noche() {
        return precio_noche;
    }

    public void setPrecio_noche(int precio_noche) {
        this.precio_noche = precio_noche;
    }

    public String getEstadoHabitacion() {
        return estadoHabitacion;
    }

    public void setEstadoHabitacion(String estadoHabitacion) {
        this.estadoHabitacion = estadoHabitacion;
    }
    
}
