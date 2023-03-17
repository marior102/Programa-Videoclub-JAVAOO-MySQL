package Modelo;

public class Ejemplar {

    private String id;
    private String formato;
    private Double precioAlquiler;
    private Double precioVenta;
    private String estado;
    private Pelicula pelicula;

    public Ejemplar(String id, String formato, Double precioAlquiler, Double precioVenta, String estado, Pelicula pelicula) {
        this.id = id;
        this.formato = formato;
        this.precioAlquiler = precioAlquiler;
        this.precioVenta = precioVenta;
        this.estado = estado;
        this.pelicula = pelicula;
    }

    public Ejemplar(String id, String formato, Double precioAlquiler,String estado, Pelicula pelicula) {
        this.id = id;
        this.formato = formato;
        this.precioAlquiler = precioAlquiler;        
        this.estado = estado;
        this.pelicula = pelicula;
    }

    public Ejemplar(String formato, Double precioAlquiler, Double precioVenta, String estado, Pelicula pelicula) {
        this.formato = formato;
        this.precioAlquiler = precioAlquiler;
        this.precioVenta = precioVenta;
        this.estado = estado;
        this.pelicula = pelicula;
    }

    public Ejemplar(String formato, Double precioAlquiler, Double precioVenta, Pelicula pelicula) {
        this.formato = formato;
        this.precioAlquiler = precioAlquiler;
        this.precioVenta = precioVenta;
        this.pelicula = pelicula;
    }

    public Ejemplar(String formato, Double precioAlquiler, Pelicula pelicula) {
        this.formato = formato;
        this.precioAlquiler = precioAlquiler;
        this.pelicula = pelicula;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    public Double getPrecioAlquiler() {
        return precioAlquiler;
    }

    public void setPrecioAlquiler(Double precioAlquiler) {
        this.precioAlquiler = precioAlquiler;
    }

    public Double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(Double precioVenta) {
        this.precioVenta = precioVenta;
    }
}
