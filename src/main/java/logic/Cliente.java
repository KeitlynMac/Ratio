package logic;

public class Cliente {
     private int id;
     private String cedulaRuc;
     private String nombreApellido;
     private String correo;
     private String telefono;
     private String direccion;

    public Cliente(){}

    public Cliente(int id, String cedulaRuc, String nombreApellido, String correo, String telefono, String direccion) {
        this.id = id;
        this.cedulaRuc = cedulaRuc;
        this.nombreApellido = nombreApellido;
        this.correo = correo;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public int getId() {
         return id;
    }

    public void setId(int id) {
         this.id = id;
    }

    public String getCedulaRuc() {
         return cedulaRuc;
    }

    public void setCedulaRuc(String cedulaRuc) {
         this.cedulaRuc = cedulaRuc;
    }

    public String getNombreApellido() {
         return nombreApellido;
    }

    public void setNombreApellido(String nombreApellido) {
         this.nombreApellido = nombreApellido;
    }

    public String getCorreo() {
         return correo;
    }

    public void setCorreo(String correo) {
         this.correo = correo;
    }

    public String getTelefono() {
         return telefono;
    }

    public void setTelefono(String telefono) {
         this.telefono = telefono;
    }

    public String getDireccion() {
         return direccion;
    }

    public void setDireccion(String direccion) {
         this.direccion = direccion;
    }
}
