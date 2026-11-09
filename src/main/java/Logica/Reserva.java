package Logica;


public class Reserva {
    
    //Attributes
    private String id_reserva;
    private String id_cliente;
    private String id_habitacion;
    private String fecha_entrada;
    private String fecha_salida;
    
    //Builders

    public Reserva() {
    }

    public Reserva(String id_reserva, String id_cliente, String id_habitacion, String fecha_entrada, String fecha_salida) {
        this.id_reserva = id_reserva;
        this.id_cliente = id_cliente;
        this.id_habitacion = id_habitacion;
        this.fecha_entrada = fecha_entrada;
        this.fecha_salida = fecha_salida;
    }
    
    //Methods to access

    public String getId_reserva() {
        return id_reserva;
    }

    public void setId_reserva(String id_reserva) {
        this.id_reserva = id_reserva;
    }

    public String getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(String id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getId_habitacion() {
        return id_habitacion;
    }

    public void setId_habitacion(String id_habitacion) {
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
    
}
