package Logica;


public class Cliente {
    
    //Attributes
    
    private String id_cliente;
    private String nombreCliente;
    private String correoCliente;
    private String telefonoCliente;
    
    //Builders

    public Cliente() {
    }

    public Cliente(String id_cliente, String nombreCliente, String correoCliente, String telefonoCliente) {
        this.id_cliente = id_cliente;
        this.nombreCliente = nombreCliente;
        this.correoCliente = correoCliente;
        this.telefonoCliente = telefonoCliente;
    }
    
    //Methods to access

    public String getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(String id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getCorreoCliente() {
        return correoCliente;
    }

    public void setCorreoCliente(String correoCliente) {
        this.correoCliente = correoCliente;
    }

    public String getTelefonoCliente() {
        return telefonoCliente;
    }

    public void setTelefonoCliente(String telefonoCliente) {
        this.telefonoCliente = telefonoCliente;
    }
    
}
