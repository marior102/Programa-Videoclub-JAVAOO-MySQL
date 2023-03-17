package Modelo;

import Modelo.Cliente;


public class Alquiler {
    private Integer idAlquiler;
    private String  fechaInicioAlquiler;
    private String  horaInicioAlquiler;
    private String  fechaFinAlquiler;
    private Double  precioTotalAlquiler;
    private Integer cantidadPeliculasAlquiladas;
    private Cliente cliente;

    public Alquiler(String fechaInicioAlquiler, String  horaInicioAlquiler,String fechaFinAlquiler, Double precioTotalAlquiler, Integer cantidadPeliculasAlquiladas, Cliente cliente) {
        this.fechaInicioAlquiler = fechaInicioAlquiler;
        this.horaInicioAlquiler = horaInicioAlquiler;
        this.fechaFinAlquiler = fechaFinAlquiler;
        this.precioTotalAlquiler = precioTotalAlquiler;
        this.cantidadPeliculasAlquiladas = cantidadPeliculasAlquiladas;
        this.cliente = cliente;
    }

    public Alquiler(Integer idAlquiler, String fechaInicioAlquiler, String  horaInicioAlquiler, String fechaFinAlquiler, Double precioTotalAlquiler, Integer cantidadPeliculasAlquiladas, Cliente cliente) {
        this.idAlquiler = idAlquiler;
        this.fechaInicioAlquiler = fechaInicioAlquiler;
        this.horaInicioAlquiler = horaInicioAlquiler;
        this.fechaFinAlquiler = fechaFinAlquiler;
        this.precioTotalAlquiler = precioTotalAlquiler;
        this.cantidadPeliculasAlquiladas = cantidadPeliculasAlquiladas;
        this.cliente = cliente;
    }
    

    public Integer getCantidadPeliculasAlquiladas() {
        return cantidadPeliculasAlquiladas;
    }

    public void setCantidadPeliculasAlquiladas(Integer cantidadPeliculasAlquiladas) {
        this.cantidadPeliculasAlquiladas = cantidadPeliculasAlquiladas;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getFechaFinAlquiler() {
        return fechaFinAlquiler;
    }

    public void setFechaFinAlquiler(String fechaFinAlquiler) {
        this.fechaFinAlquiler = fechaFinAlquiler;
    }

    public String getFechaInicioAlquiler() {
        return fechaInicioAlquiler;
    }

    public void setFechaInicioAlquiler(String fechaInicioAlquiler) {
        this.fechaInicioAlquiler = fechaInicioAlquiler;
    }

    public Integer getIdAlquiler() {
        return idAlquiler;
    }

    public void setIdAlquiler(Integer idAlquiler) {
        this.idAlquiler = idAlquiler;
    }

    public Double getPrecioTotalAlquiler() {
        return precioTotalAlquiler;
    }

    public void setPrecioTotalAlquiler(Double precioTotalAlquiler) {
        this.precioTotalAlquiler = precioTotalAlquiler;
    }

    public String getHoraInicioAlquiler() {
        return horaInicioAlquiler;
    }

    public void setHoraInicioAlquiler(String horaInicioAlquiler) {
        this.horaInicioAlquiler = horaInicioAlquiler;
    }
    
    
    
}
