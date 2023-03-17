package Modelo;

public class DetalleVenta {
    private Integer idDetalleVenta;
    private Integer cantidadLineaDetalleVenta;
    private Double importeLineaDetalleVenta;
    private Venta venta;
    private Ejemplar ejemplar;

    public DetalleVenta(Integer cantidadLineaDetalleVenta, Double importeLineaDetalleVenta, Venta venta, Ejemplar ejemplar) {
        this.cantidadLineaDetalleVenta = cantidadLineaDetalleVenta;
        this.importeLineaDetalleVenta = importeLineaDetalleVenta;
        this.venta = venta;
        this.ejemplar = ejemplar;
    }    
    

    public Integer getCantidadLineaDetalleVenta() {
        return cantidadLineaDetalleVenta;
    }

    public void setCantidadLineaDetalleVenta(Integer cantidadLineaDetalleVenta) {
        this.cantidadLineaDetalleVenta = cantidadLineaDetalleVenta;
    }

    public Ejemplar getEjemplar() {
        return ejemplar;
    }

    public void setEjemplar(Ejemplar ejemplar) {
        this.ejemplar = ejemplar;
    }

    public Integer getIdDetalleVenta() {
        return idDetalleVenta;
    }

    public void setIdDetalleVenta(Integer idDetalleVenta) {
        this.idDetalleVenta = idDetalleVenta;
    }

    public Double getImporteLineaDetalleVenta() {
        return importeLineaDetalleVenta;
    }

    public void setImporteLineaDetalleVenta(Double importeLineaDetalleVenta) {
        this.importeLineaDetalleVenta = importeLineaDetalleVenta;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }
    
    
}
