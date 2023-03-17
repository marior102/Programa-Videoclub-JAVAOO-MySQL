package Modelo;

import Modelo.Cliente;


public class Devolucion {
    private Integer id;
    private String  fecha;
    private String  hora;
    private Integer cantidadEjemplaresDevueltos;
    private Integer diasDeMora;
    private Integer deudaDotal;
    private Cliente cliente;

    public Devolucion(String fecha,String hora, Integer cantidadEjemplaresDevueltos, Integer diasDeMora, Integer deudaDotal, Cliente cliente) {
        this.fecha = fecha;
        this.hora = hora;
        this.cantidadEjemplaresDevueltos = cantidadEjemplaresDevueltos;
        this.diasDeMora = diasDeMora;
        this.deudaDotal = deudaDotal;
        this.cliente = cliente;
    }

    public Devolucion(Integer id, String fecha, String hora, Integer cantidadEjemplaresDevueltos, Integer diasDeMora, Integer deudaDotal, Cliente cliente) {
        this.id = id;
        this.fecha = fecha;
        this.hora = hora;
        this.cantidadEjemplaresDevueltos = cantidadEjemplaresDevueltos;
        this.diasDeMora = diasDeMora;
        this.deudaDotal = deudaDotal;
        this.cliente = cliente;
    }
    

    public Integer getCantidadEjemplaresDevueltos() {
        return cantidadEjemplaresDevueltos;
    }

    public void setCantidadEjemplaresDevueltos(Integer cantidadEjemplaresDevueltos) {
        this.cantidadEjemplaresDevueltos = cantidadEjemplaresDevueltos;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Integer getDeudaDotal() {
        return deudaDotal;
    }

    public void setDeudaDotal(Integer deudaDotal) {
        this.deudaDotal = deudaDotal;
    }

    public Integer getDiasDeMora() {
        return diasDeMora;
    }

    public void setDiasDeMora(Integer diasDeMora) {
        this.diasDeMora = diasDeMora;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
    
    
    
    
    
}
