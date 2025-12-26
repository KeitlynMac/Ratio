package logic;

public class Factura {
    private int id;
    private String noSerie;
    private int idCliente;
    private String fechaVenta;
    private double montoVenta;

    public Factura(int id, String noSerie, int idCliente, String fechaVenta, double montoVenta) {
        this.id = id;
        this.noSerie = noSerie;
        this.idCliente = idCliente;
        this.fechaVenta = fechaVenta;
        this.montoVenta = montoVenta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNoSerie() {
        return noSerie;
    }

    public void setNoSerie(String noSerie) {
        this.noSerie = noSerie;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(String fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public double getMontoVenta() {
        return montoVenta;
    }

    public void setMontoVenta(double montoVenta) {
        this.montoVenta = montoVenta;
    }

}
