
package Modelo;

public class DetalleAlquiler {
    private Integer  idDetalleAlquiler;
    private Integer  cantidadLineaDetalleAlquiler;
    private Double   importeLineaDetalleAlquiler;
    private Alquiler alquiler;
    private Ejemplar ejemplar;

    public DetalleAlquiler(Integer cantidadLineaDetalleAlquiler, Double importeLineaDetalleAlquiler, Alquiler alquiler, Ejemplar ejemplar) {
        this.cantidadLineaDetalleAlquiler = cantidadLineaDetalleAlquiler;
        this.importeLineaDetalleAlquiler = importeLineaDetalleAlquiler;
        this.alquiler = alquiler;
        this.ejemplar = ejemplar;
    }

    public DetalleAlquiler(Integer idDetalleAlquiler, Integer cantidadLineaDetalleAlquiler, Double importeLineaDetalleAlquiler, Alquiler alquiler, Ejemplar ejemplar) {
        this.idDetalleAlquiler = idDetalleAlquiler;
        this.cantidadLineaDetalleAlquiler = cantidadLineaDetalleAlquiler;
        this.importeLineaDetalleAlquiler = importeLineaDetalleAlquiler;
        this.alquiler = alquiler;
        this.ejemplar = ejemplar;
    }    
    

    public Alquiler getAlquiler() {
        return alquiler;
    }

    public void setAlquiler(Alquiler alquiler) {
        this.alquiler = alquiler;
    }

    public Integer getCantidadLineaDetalleAlquiler() {
        return cantidadLineaDetalleAlquiler;
    }

    public void setCantidadLineaDetalleAlquiler(Integer cantidadLineaDetalleAlquiler) {
        this.cantidadLineaDetalleAlquiler = cantidadLineaDetalleAlquiler;
    }

    public Ejemplar getEjemplar() {
        return ejemplar;
    }

    public void setEjemplar(Ejemplar ejemplar) {
        this.ejemplar = ejemplar;
    }

    public Integer getIdDetalleAlquiler() {
        return idDetalleAlquiler;
    }

    public void setIdDetalleAlquiler(Integer idDetalleAlquiler) {
        this.idDetalleAlquiler = idDetalleAlquiler;
    }

    public Double getImporteLineaDetalleAlquiler() {
        return importeLineaDetalleAlquiler;
    }

    public void setImporteLineaDetalleAlquiler(Double importeLineaDetalleAlquiler) {
        this.importeLineaDetalleAlquiler = importeLineaDetalleAlquiler;
    }
    
    
    
}
