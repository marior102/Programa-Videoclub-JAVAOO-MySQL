
package Modelo;

public class Cliente {
    private Integer id;
    private String CI;
    private String nombres;
    private String apellidos;
    private String sexo;
    private String tipo;
    private String direccion;
    private String telefono;    
    private String correo;

    public Cliente(Integer id, String CI, String nombres, String apellidos, String sexo, String tipo, String direccion, String telefono, String correo) {
        this.id = id;
        this.CI = CI;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.sexo = sexo;
        this.tipo = tipo;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
    }

    public Cliente(String dni, String nombres, String apellidos, String sexo, String tipo, String direccion, String telefono, String correo) {
        this.CI = dni;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.sexo = sexo;
        this.tipo = tipo;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
    }

    
    
    
    public Integer getid() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }   
        
    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCI() {
        return CI;
    }

    public void setCI(String CI) {
        this.CI = CI;
    }

  

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    
    
    
    
}
