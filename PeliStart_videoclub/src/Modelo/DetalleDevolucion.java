package Modelo;

public class DetalleDevolucion {

    private Integer id;
    private Integer cantidadLineaDetalle;
    private Ejemplar ejemplar;
    private Integer diasDeMora;
    private Integer deudaLinea;
    private Devolucion devolucion;

    public DetalleDevolucion(Integer cantidadLineaDetalle, Ejemplar ejemplar, Integer diasDeMora, Integer deudaLinea, Devolucion devolucion) {
        this.cantidadLineaDetalle = cantidadLineaDetalle;
        this.ejemplar = ejemplar;
        this.diasDeMora = diasDeMora;
        this.deudaLinea = deudaLinea;
        this.devolucion = devolucion;
    }

   

   

    public Integer getCantidadLineaDetalle() {
        return cantidadLineaDetalle;
    }

    public void setCantidadLineaDetalle(Integer cantidadLineaDetalle) {
        this.cantidadLineaDetalle = cantidadLineaDetalle;
    }

    public Devolucion getDevolucion() {
        return devolucion;
    }

    public void setDevolucion(Devolucion devolucion) {
        this.devolucion = devolucion;
    }

    public Ejemplar getEjemplar() {
        return ejemplar;
    }

    public void setEjemplar(Ejemplar ejemplar) {
        this.ejemplar = ejemplar;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDeudaLinea() {
        return deudaLinea;
    }

    public void setDeudaLinea(Integer deudaLinea) {
        this.deudaLinea = deudaLinea;
    }

    public Integer getDiasDeMora() {
        return diasDeMora;
    }

    public void setDiasDeMora(Integer diasDeMora) {
        this.diasDeMora = diasDeMora;
    }
    
}
