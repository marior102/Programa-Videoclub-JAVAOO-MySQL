
package Modelo;


public class Usuario {
    private String codUsuario;
     private String nombreUsuario;
    private String contrasenia;
    private String nombres;
    private String apellidos;
    private String cargo;

    public Usuario(String codUsu, String nombreUsuario, String cargo) {
        this.codUsuario = codUsu;
        this.nombreUsuario = nombreUsuario;
        this.cargo = cargo;
    }

    public Usuario(String nombreUsuario, String contrasenia, String nombres, String apellidos, String cargo) {
        this.nombreUsuario = nombreUsuario;
        this.contrasenia = contrasenia;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.cargo = cargo;
    }
    

    public String getContrasenia() {
        return contrasenia;
    }
    public String getCodUsuario(){
        return this.codUsuario;
    }
     
    

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getNombreUsuario() {
        return this.nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCargo() {
        return this.cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }
    
    
    
}
