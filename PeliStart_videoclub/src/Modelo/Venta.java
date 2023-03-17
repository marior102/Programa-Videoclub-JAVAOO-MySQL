package Modelo;

import Modelo.Cliente;


public class Venta {
    private Integer idVenta;
    private String  fechaVenta;
    private String  horaVenta;
    private Double  montoTotalVenta;
    private Cliente cliente;
    private Integer cod_usuario;

    public Venta(String fechaVenta, String horaVenta, Double montoTotalVenta, Cliente cliente, Integer cod_usuario) {
        
        this.fechaVenta = fechaVenta;
        this.horaVenta = horaVenta;
        this.montoTotalVenta = montoTotalVenta;
        this.cliente = cliente;
        this.cod_usuario=cod_usuario;
    }

    public Venta(Integer idVenta, String fechaVenta, String horaVenta, Double montoTotalVenta, Cliente cliente,  Integer cod_usuario) {
        this.idVenta = idVenta;
        this.fechaVenta = fechaVenta;
        this.horaVenta = horaVenta;
        this.montoTotalVenta = montoTotalVenta;
        this.cliente = cliente;
        this.cod_usuario=cod_usuario;
    }

    
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(String fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public Integer getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(Integer idVenta) {
        this.idVenta = idVenta;
    }

    public Double getMontoTotalVenta() {
        return montoTotalVenta;
    }

    public void setMontoTotalVenta(Double montoTotalVenta) {
        this.montoTotalVenta = montoTotalVenta;
    }

    public String getHoraVenta() {
        return horaVenta;
    }

    public void setHoraVenta(String horaVenta) {
        this.horaVenta = horaVenta;
    }
    public int getcodUsuario(){
        return cod_usuario;
    }
    public void setcodUsuario(Integer  cod_usuario){
        this.cod_usuario=cod_usuario;
    }
    
    
    
    
    
    
}
