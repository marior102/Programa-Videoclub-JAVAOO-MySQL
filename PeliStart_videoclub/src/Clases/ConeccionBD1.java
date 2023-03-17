package Clases;
import Modelo.*;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.*;


public class ConeccionBD1 {
    public Usuario usuario;

    private Pelicula pelicula;
    private ArrayList<Pelicula> listaPeliculas;
    String cod;
    public final String CONTROLADOR_JDBC = "com.mysql.jdbc.Driver";
    //public final String CONTROLADOR_JDBC = "org.postgresql.Driver";
    /** La conexion con la base de datos */
    private Connection conexion;
    Statement stmt;
    Statement stmt2;
    ResultSet rs;
    ResultSet rs2;
    public static String CodUsuSt;
    public static String UsuaSt;
    public static String cargoSt;
    String codigo, fecha;
    private Cliente cliente;
     private Ejemplar ejemplar;
    private ArrayList<Ejemplar> listaEjemplares;
    private Genero genero;
    private Alquiler alquiler;
    private ArrayList<Alquiler> listaAlquileres;
    private DetalleAlquiler detalleAlquiler;
    private ArrayList<DetalleAlquiler> listaDetalleAlquiler;
    private Devolucion devolucion;
    private Venta venta;
    private ArrayList<Venta> listaVenta;
    /** Creates a new instance of ConeccionBD */
    public ConeccionBD1() {
        this.conexion = null;
        listaPeliculas = new ArrayList<Pelicula>();
        listaEjemplares=new ArrayList<Ejemplar>();
        listaAlquileres = new ArrayList<Alquiler>();
        listaVenta = new ArrayList<Venta>();
        listaDetalleAlquiler = new ArrayList<DetalleAlquiler>();
    }
    public boolean estaConectado() {

        if (conexion != null) {
            return true;
        }
        try {
            // Se registra el Driver de MySQL

             DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            Class.forName(CONTROLADOR_JDBC);
// Se obtiene una conexi�n con la base de datos. Hay que
// cambiar el usuario "usuario" y la clave "" por las
// adecuadas a la base de datos que estemos usando.
     // conexion  = DriverManager.getConnection("jdbc:postgresql://localhost/compras", "postgres", "123");
//para conectar a mysql
            conexion = DriverManager.getConnection(
            "jdbc:mysql://localhost/video_club", "root", "1234");
            //"jdbc:mysql://localhost/rrhh","root","");
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public Connection conectar(){
        try {
              Class.forName(CONTROLADOR_JDBC);
        conexion = DriverManager.getConnection("jdbc:mysql://localhost/video_club", "root", "1234");
 //  conexion  = DriverManager.getConnection("jdbc:postgresql://localhost/compras", "postgres", "123");
        } catch (Exception e) {
        }
      return conexion;
    }




    public boolean borrarRegistro(String tabla, String condicion) {
        int resultado;
        try {
            // Se crea un Statement, para realizar la consulta
            Statement s = conexion.createStatement();
            // Se realiza la consulta. 
            JOptionPane optionPane = new JOptionPane();
            Object[] opciones = {"S�", "No"};
            //Dialogo modal SI_NO
            int ret = optionPane.showOptionDialog(null, "Desea Borrar? ", "Pregunta", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
            //Si la opcion escogida es Si
            if (ret == JOptionPane.YES_OPTION) {
                resultado = s.executeUpdate("delete from " + tabla + " where " + condicion);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Ocurrio Un error", "Atencion",
                    JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
        return true;
    }

    public boolean borrarRegistroSinPreguntar(String tabla, String condicion) {
        int resultado;
        try {
            // Se crea un Statement, para realizar la consulta
            Statement s = conexion.createStatement();
            resultado = s.executeUpdate("delete from " + tabla + " where " + condicion);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean insertarRegistro(String tabla, String campos, String valores) {
        int resultado;
        conectar();
        try {
            // Se crea un Statement, para realizar la consulta
            Statement s = conexion.createStatement();
            // Se realiza la consulta. 
            resultado = s.executeUpdate("insert into " + tabla + " (" + campos + ") values (" + valores + ")");
           // JOptionPane.showMessageDialog(null, "Grabado con exito");

        } catch (Exception e) {
            //e.printStackTrace();
           JOptionPane.showMessageDialog(null, "Ocurrio Un error\n" + e.getMessage(), "Atencion",
                   JOptionPane.INFORMATION_MESSAGE);
            System.out.println("insert into " + tabla + " (" + campos + ") values (" + valores + ")");
            return false;
        }
        return true;
    }

    public boolean actualizarRegistro(String tabla, String campos, String criterio) {
        int resultado;
        conectar();
        try {
            // Se crea un Statement, para realizar la consulta
            Statement s = conexion.createStatement();
            // Se realiza la consulta. 
            resultado = s.executeUpdate("update " + tabla + " set " + campos + " where " + criterio);
        } catch (Exception e) {
            //e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Ocurrio Un error\n" + e.getMessage(), "Atencion",
                    JOptionPane.INFORMATION_MESSAGE);
           System.out.println("update " + tabla + " set " + campos + " where " + criterio);
            return false;
        }
        return true;
    }

    public ResultSet dameLista(String campos, String tabla, String condicion) {
        ResultSet rs = null;
        conectar();
        try {
            // Se crea un Statement, para realizar la consulta
            Statement s = conexion.createStatement();

            // Se realiza la consulta. Los resultados se guardan en el
            // ResultSet rs
            rs = s.executeQuery("select " + campos + " from " + tabla + " " + condicion);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Ocurrio Un error", "Atencion",
                    JOptionPane.INFORMATION_MESSAGE);
            System.out.println("select " + campos + " from " + tabla + " " + condicion);
        }
        return rs;
    }

    public ResultSet dameLista(String sql) {
        ResultSet rs = null;
        try {
            // Se crea un Statement, para realizar la consulta
            Statement s = conexion.createStatement();

            // Se realiza la consulta. Los resultados se guardan en el
            // ResultSet rs
            rs = s.executeQuery(sql);

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Ocurrio Un error", "Atencion",
                    JOptionPane.INFORMATION_MESSAGE);
            System.out.println(sql);
        }
        return rs;
    }

    public void cargarCombo(String sql, JComboBox combo) {
        ResultSet rs = null;
        int contar = 0;
        try {
            Statement s = conexion.createStatement();
            rs = s.executeQuery(sql);
            while (rs.next()) {
                String columnas[] = new String[2];
                columnas[0] = rs.getString(1);
                columnas[1] = rs.getString(2);
                
                combo.addItem(columnas);
                System.out.println(rs.getString(1) + "-" + rs.getString(2));
                contar++;
            }
        } catch (Exception e) {
            //e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Ocurrio Un error: " + e.toString(), "Atencion",
                    JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        if (contar > 0) {
            combo.setRenderer(new DefaultListCellRenderer() {

                public java.awt.Component getListCellRendererComponent(
                        JList l, Object o, int i, boolean s, boolean f) {
                    try {
                        return new JLabel(((String[]) o)[1]);
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Ocurrio Un error", "Atencion",
                                JOptionPane.INFORMATION_MESSAGE);
                        return null;
                    }
                }
            });
        }
        return;
    }
public boolean existeUsuarioClave(String codUsu, String usu, String clave) {

        rs = null;
        rs2 = null;
        
        try {


            stmt = conexion.createStatement();
            stmt2 = conexion.createStatement();
            rs = stmt.executeQuery("select count(1) from usuario where Login = '" + usu + "' and Contrasena = '" + clave + "' and cod_usuario = '" + codUsu + "'");
            rs2 = stmt2.executeQuery("select cargo from usuario where cod_usuario = '" + codUsu + "'");
       
            CodUsuSt = codUsu;
            UsuaSt = usu;
            
            System.out.println(codUsu + " " + usu + " " + cargoSt);
            //usuario = new Usuario(codUsu, usu, cargo);
            
            JOptionPane.showMessageDialog(null, "Conectado " + usu, "Bienvenidos",
                    JOptionPane.INFORMATION_MESSAGE);
           // JOptionPane.showMessageDialog(null, codUsu, usu,cargo);
            //rs = s.executeQuery("select count(1) from usuario where usuario = 'usu' and clave = 'clave'");

            rs.next();
            int cantidad = rs.getInt(1);
            rs2.next();
            cargoSt = rs2.getString(1);
            if (cantidad == 0) {
                return false;
            } else {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    /**
     *
     * @return
     */
    
    
public String traerfecha(){
     try {
            stmt = conexion.createStatement();
            String consultaSQL = ("select current_date() as fecha");
            rs = stmt.executeQuery(consultaSQL);
            while (rs.next()) {
                fecha = rs.getString("fecha");
            }
        } catch (Exception ex) {
            javax.swing.JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return fecha;
    }

public boolean existeCedulaCliente(String CI) {
        boolean existe = false;
        Connection conn = null;
        try {
            try {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
            } catch (InstantiationException ex) {
            } catch (IllegalAccessException ex) {
            }
            conn = DriverManager.getConnection("jdbc:mysql://localhost/video_club", "root", "1234");
            if (conn != null) {
                Statement stmt = conn.createStatement();
                ResultSet res = stmt.executeQuery("SELECT * FROM clientes");

                while (res.next()) {
                    String dni_bd = res.getString("CIclientes");
                    if (CI.equals(dni_bd)) {
                        existe = true;
                    }
                }
                res.close();
                stmt.close();
                conn.close();
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        }
        return existe;
    }


public Cliente obtenerClientePorCI(String CI) {
        
        Connection conn = null;
        try {
           try {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
            } catch (InstantiationException ex) {
            } catch (IllegalAccessException ex) {
            }
            conn = DriverManager.getConnection("jdbc:mysql://localhost/video_club", "root", "1234");
            if (conn != null) {
                Statement stmt = conn.createStatement();

                ResultSet res = stmt.executeQuery("SELECT * FROM clientes where CIclientes='" + CI + "';");

                while (res.next()) {

                    Integer id = res.getInt("idClientes");
                    String nombres = res.getString("NombreCliente");
                    String apellidos = res.getString("ApellidoCliente");
                    String sexo = res.getString("sexocliente");
                    String tipo = res.getString("tipocliente");
                    String direccion = res.getString("DireccionCliente");
                    String telefono = res.getString("TelefonoCliente");
                    String correo = res.getString("CorreoCliente");
                    cliente = new Cliente(id, CI, nombres, apellidos,sexo,tipo, direccion, telefono, correo);

                }
                res.close();
                stmt.close();
                conn.close();
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        }
        return cliente;
    }

 public boolean existeTituloPelicula(String titulo) {
        boolean existe = false;
        Connection conn= null;
       
        try {
            try {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
            } catch (InstantiationException ex) {
            } catch (IllegalAccessException ex) {
            }
            conn = DriverManager.getConnection("jdbc:mysql://localhost/video_club", "root", "1234");
            if (conn != null) {
                Statement stmt = conn.createStatement();
                ResultSet res = stmt.executeQuery("SELECT titulopelicula FROM pelicula");

                while (res.next()) {
                    String titulo_bd = res.getString("tituloPelicula");
                    if (titulo.equals(titulo_bd)) {
                        existe = true;
                    }
                }
                res.close();
                stmt.close();
                conn.close();
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        }
        return existe;
    }
public Pelicula obtenerPeliculaPorTitulo(String titulo) {
        Connection conn = null;
        try {
            try {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
            } catch (InstantiationException ex) {
            } catch (IllegalAccessException ex) {
            }
            conn = DriverManager.getConnection("jdbc:mysql://localhost/video_club", "root", "1234");
            if (conn != null) {
                Statement stmt = conn.createStatement();

                ResultSet res = stmt.executeQuery("SELECT * FROM pelicula where tituloPelicula='" + titulo + "';");

                while (res.next()) {
                    String id = res.getString("idPelicula");
                    String duracion = res.getString("duracionPelicula");
                    String pais = res.getString("PaisPelicula");
                    String director = res.getString("directorPelicula");
                    String actores = res.getString("actoresPelicula");
                    String sinopsis = res.getString("sinopsisPelicula");
                    Integer idGenero = res.getInt("idGenero");
                    Integer stock = res.getInt("Stock_Pelicula");

                    Genero genero = this.buscarGenero(idGenero);
                    pelicula = new Pelicula(id, titulo, duracion, pais, director, actores, sinopsis, genero,stock);
                }
                res.close();
                stmt.close();
                conn.close();
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        }
        return pelicula;
    }

public Genero buscarGenero(Integer idGenero) {

        return obtenerGeneroPorId(idGenero);
    }

   public ArrayList<Pelicula> obtenerPeliculasDeTodosLosGeneros() {
        listaPeliculas.clear();
        Connection conn = null;
        int i = 0;
        try {
           try {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
            } catch (InstantiationException ex) {
            } catch (IllegalAccessException ex) {
            }
            conn = DriverManager.getConnection("jdbc:mysql://localhost/video_club", "root", "1234");
            if (conn != null) {
                Statement stmt = conn.createStatement();
                ResultSet res = stmt.executeQuery("SELECT * FROM pelicula");

                while (res.next()) {
                    String id = res.getString("idPelicula");
                    String titulo = res.getString("tituloPelicula");
                    String duracion = res.getString("duracionPelicula");
                    String pais = res.getString("paisPelicula");
                    String director = res.getString("directorPelicula");
                    String actores = res.getString("actoresPelicula");
                    String sinopsis = res.getString("sinopsisPelicula");
                    Integer idGenero = res.getInt("idGenero");
                    Integer stock = res.getInt("Stock_Pelicula");

                    Genero genero = this.buscarGenero(idGenero);
                    pelicula = new Pelicula(id,titulo, duracion, pais, director, actores, sinopsis, genero,stock);
                    
                    listaPeliculas.add(i, pelicula);
                    i++;
                }
                res.close();
                stmt.close();
                conn.close();
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        }
        return listaPeliculas;
    }

    

    

    public ArrayList<Pelicula> getPeliculasPorGenero(Genero genero) {
        listaPeliculas.clear();
        Connection conn = null;
        int i = 0;
        try {
           try {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
            } catch (InstantiationException ex) {
            } catch (IllegalAccessException ex) {
            }
            conn = DriverManager.getConnection("jdbc:mysql://localhost/video_club", "root", "1234");
            if (conn != null) {
                Statement stmt = conn.createStatement();
                ResultSet res = stmt.executeQuery("SELECT * FROM pelicula WHERE idGenero="+genero.getId());

                while (res.next()) {
                    String id = res.getString("idPelicula");
                    String titulo = res.getString("tituloPelicula");
                    String duracion = res.getString("duracionPelicula");
                    String pais = res.getString("paisPelicula");
                    String director = res.getString("directorPelicula");
                    String actores = res.getString("actoresPelicula");
                    String sinopsis = res.getString("sinopsisPelicula");
                    Integer stock = res.getInt("Stock_Pelicula");
                                        
                    pelicula = new Pelicula(id,titulo, duracion, pais, director, actores, sinopsis, genero,stock);
                    
                    listaPeliculas.add(i, pelicula);
                    i++;
                }
                res.close();
                stmt.close();
                conn.close();
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        }
        return listaPeliculas;
    }
public ArrayList<Ejemplar> obtenerEjemplaresPorPelicula(Pelicula pelicula) {
        Connection conn = null;

        int i = 0;
        try {
            try {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
            } catch (InstantiationException ex) {
            } catch (IllegalAccessException ex) {
            }
            conn = DriverManager.getConnection("jdbc:mysql://localhost/video_club", "root", "1234");
            if (conn != null) {
                Statement stmt = conn.createStatement();
                ResultSet res = stmt.executeQuery("SELECT * FROM ejemplar where idpelicula='"+pelicula.getId()+"';");


                while (res.next()) {
                    String idEjemplar = res.getString("idejemplar");
                    String formato = res.getString("formatoejemplar");
                    Double precioAlquiler = res.getDouble("precioalquilerejemplar");
                    Double precioVenta = res.getDouble("precioventaejemplar");
                    String estado = res.getString("estadoejemplar");
                    ejemplar = new Ejemplar(idEjemplar, formato, precioAlquiler, precioVenta, estado, pelicula);
                    
                    listaEjemplares.add(i, ejemplar);
                    i++;
                    
                }
                res.close();
                stmt.close();
                conn.close();
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        }
        return listaEjemplares;
    }

    public Ejemplar obtenerEjemplarPorId(String idEjemplar) {
        Connection conn = null;
         try {
            try {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
            } catch (InstantiationException ex) {
            } catch (IllegalAccessException ex) {
            }
            conn = DriverManager.getConnection("jdbc:mysql://localhost/video_club", "root", "1234");
            if (conn != null) {
                Statement stmt = conn.createStatement();

                ResultSet res = stmt.executeQuery("SELECT * FROM ejemplar where idejemplar='"+idEjemplar+"';");

                while (res.next()) {
                    String idPelicula = res.getString("idpelicula");                    
                    String formato = res.getString("formatoejemplar");
                    Double precioAlquiler = res.getDouble("precioalquilerejemplar");
                    Double precioVenta = res.getDouble("precioventaejemplar");
                    String estado = res.getString("estadoejemplar");
                    
                    Pelicula pelicula = buscarPelicula(idPelicula);
                    ejemplar = new Ejemplar(idEjemplar,formato,precioAlquiler,precioVenta,estado,pelicula);
                }
                res.close();
                stmt.close();
                conn.close();
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        }
        return ejemplar;
    }

    private Pelicula buscarPelicula(String idPelicula) {
        

        return obtenerPeliculaPorId(idPelicula);
    }

    public void actualizarEstadoEjemplar(Ejemplar ej) {
        Connection conn = null;
        try {
             try {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
            } catch (InstantiationException ex) {
            } catch (IllegalAccessException ex) {
            }
            conn = DriverManager.getConnection("jdbc:mysql://localhost/video_club", "root", "1234");
            if (conn != null) {
                Statement stmt = conn.createStatement();

                String update = "UPDATE ejemplar " + "SET "
                        + "estadoejemplar='alquilado' "                        
                        + "WHERE idejemplar='"+ej.getId()+"';";

                stmt.executeUpdate(update);
                stmt.close();
                conn.close();
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        }
        
    }

     public ArrayList<Ejemplar> obtenerEjemplaresPorPeliculaConEstadoLibre(Pelicula pelicula) {
        Connection conn = null;

        int i = 0;
        try {
            try {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
            } catch (InstantiationException ex) {
            } catch (IllegalAccessException ex) {
            }
            conn = DriverManager.getConnection("jdbc:mysql://localhost/video_club", "root", "1234");
            if (conn != null) {
                Statement stmt = conn.createStatement();
                ResultSet res = stmt.executeQuery("SELECT * FROM ejemplar where idpelicula='"+pelicula.getId()+"' "
                                                 +"and estadoejemplar='libre'");


                while (res.next()) {
                    String idEjemplar = res.getString("idejemplar");
                    String formato = res.getString("formatoejemplar");
                    Double precioAlquiler = res.getDouble("precioalquilerejemplar");
                    Double precioVenta = res.getDouble("precioventaejemplar");
                    String estado = res.getString("estadoejemplar");
                    ejemplar = new Ejemplar(idEjemplar, formato, precioAlquiler, precioVenta, estado, pelicula);
                    
                    listaEjemplares.add(i, ejemplar);
                    i++;
                    
                }
                res.close();
                stmt.close();
                conn.close();
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        }
        return listaEjemplares;
    }

    

    public void actualizarEstadoEjemplarComoLibre(Ejemplar ej) {
       conectar();
        try {
            
                Statement stmt = conexion.createStatement();

                String update = "UPDATE ejemplar " + "SET "
                        + "estadoejemplar='libre' "                        
                        + "WHERE idejemplar='"+ej.getId()+"';";

                stmt.executeUpdate(update);
                stmt.close();
                conexion.close();
            
        } catch (SQLException ex) {
            System.out.println(ex);
        
        }
        
    }

    

    public void actualizarEstadoEjemplarComoVendido(Ejemplar ej) {
         conectar();
        try {
            
                Statement stmt = conexion.createStatement();

                String update = "UPDATE ejemplar " + "SET "
                        + "estadoejemplar='Vendido' "                        
                        + "WHERE idejemplar='"+ej.getId()+"';";

                stmt.executeUpdate(update);
                stmt.close();
                conexion.close();
            
        } catch (SQLException ex) {
            System.out.println(ex);
        
        }
    }
    
    public static int convertirCadenaEntero(String cadena) {
        int dato = 999;
        try {
            dato = Integer.parseInt(cadena);
        } catch (Exception e) {
            mostrar("Error al convertir la Cadena - " + cadena + " - a Entero.");
        }
        return dato;
    }
     public static void mostrar(String texto) {
        System.out.println(texto);
    }
     
      Genero obtenerGeneroPorId(Integer idGenero) {
        Connection conn = null;
        try {
             try {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
            } catch (InstantiationException ex) {
            } catch (IllegalAccessException ex) {
            }
            conn = DriverManager.getConnection("jdbc:mysql://localhost/video_club", "root", "1234");
            if (conn != null) {
                Statement stmt = conn.createStatement();
                ResultSet res = stmt.executeQuery("SELECT * FROM genero where idGenero=" + idGenero);

                while (res.next()) {
                    Integer id = res.getInt("idGenero");
                    String descripcion = res.getString("descripciongenero");


                    genero = new Genero(id, descripcion);
                }
                res.close();
                stmt.close();
                conn.close();
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        }
        return genero;
    }
 public Genero getGeneroPorDescripcion(String descripcion) {
        Connection conn = null;        
        try {
           try {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
            } catch (InstantiationException ex) {
            } catch (IllegalAccessException ex) {
            }
            conn = DriverManager.getConnection("jdbc:mysql://localhost/video_club", "root", "1234");
            if (conn != null) {
                Statement stmt = conn.createStatement();
                ResultSet res = stmt.executeQuery("SELECT * FROM genero where descripciongenero='"+descripcion+"'");
                while (res.next()) {
                    Integer id = res.getInt("idgenero");
                    genero=new Genero(id,descripcion);                    
                }
                res.close();
                stmt.close();
                conn.close();
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        }
        return genero;
        
    }
    

   public int getIdGeneroPorDescripcion(String descripcion) {
        Connection conn = null;
        Integer id = null;
        try {
            try {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
            } catch (InstantiationException ex) {
            } catch (IllegalAccessException ex) {
            }
            conn = DriverManager.getConnection("jdbc:mysql://localhost/video_club", "root", "1234");
            if (conn != null) {
                Statement stmt = conn.createStatement();
                ResultSet res = stmt.executeQuery("SELECT idgenero FROM genero where descripciongenero='" + descripcion + "'");
                while (res.next()) {
                    id = res.getInt("idgenero");
                }

                res.close();
                stmt.close();
                conn.close();
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        }
        return id;
    }
    Pelicula obtenerPeliculaPorId(String idPelicula) {
        Connection conn = null;
        try {
            try {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
            } catch (InstantiationException ex) {
            } catch (IllegalAccessException ex) {
            }
            conn = DriverManager.getConnection("jdbc:mysql://localhost/video_club", "root", "1234");
            if (conn != null) {
                Statement stmt = conn.createStatement();
                ResultSet res = stmt.executeQuery("SELECT * FROM pelicula where idPelicula='"+idPelicula+"'");

                while (res.next()) {
                    String id = res.getString("idPelicula");
                    String titulo = res.getString("titulopelicula");
                    String duracion = res.getString("duracionpelicula");
                    String pais = res.getString("PaisPelicula");
                    String director = res.getString("directorpelicula");
                    String actores = res.getString("actorespelicula");
                    String sinopsis = res.getString("sinopsispelicula");
                    Integer idGenero = res.getInt("idGenero");
                    Integer stock = res.getInt("Stock_Pelicula");

                    Genero genero = this.buscarGenero(idGenero);
                    pelicula = new Pelicula(id,titulo, duracion, pais, director, actores, sinopsis, genero,stock);
                }
                res.close();
                stmt.close();
                conn.close();
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        }
        return pelicula;

    }
    
    public Alquiler obtenerAlquiler() {
        Connection conn = null;
        try {
            try {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
            } catch (InstantiationException ex) {
            } catch (IllegalAccessException ex) {
            }
            conn = DriverManager.getConnection("jdbc:mysql://localhost/video_club", "root", "1234");
            if (conn != null) {
                Statement stmt = conn.createStatement();
                ResultSet res = stmt.executeQuery("SELECT * FROM alquiler");

                while (res.next()) {
                    Integer id = res.getInt("idalquiler");
                    String fechaInicio = res.getString("fechainicioalquiler");
                    String horaInicio = res.getString("horainicioalquiler");
                    String fechaFin = res.getString("fechafinalquiler");
                    Double montoTotal = res.getDouble("montototalalquiler");
                    Integer cantidadEjemplares = res.getInt("cantidadejemplaresalquilados");
                    Integer idCliente = res.getInt("idclientes");

                    Cliente cliente = buscarCliente(idCliente);
                    alquiler = new Alquiler(id, fechaInicio, horaInicio, fechaFin, montoTotal, cantidadEjemplares, cliente);
                }
                res.close();
                stmt.close();
                conn.close();
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        }
        return alquiler;
    }

    private Cliente buscarCliente(Integer idCliente) {
        ConeccionBD1 cdao = new ConeccionBD1();

        return cdao.obtenerClientePorId(idCliente);
    }
Cliente obtenerClientePorId(Integer idCliente) {
        Connection conn = null;
        try {
           try {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
            } catch (InstantiationException ex) {
            } catch (IllegalAccessException ex) {
            }
            conn = DriverManager.getConnection("jdbc:mysql://localhost/video_club", "root", "1234");
            if (conn != null) {
                Statement stmt = conn.createStatement();
                ResultSet res = stmt.executeQuery("SELECT * FROM clientes where idClientes=" + idCliente);

                while (res.next()) {                    
                    String CI = res.getString("CIclientes");
                    String nombres = res.getString("NombreCliente");
                    String apellidos = res.getString("ApellidoCliente");
                    String sexo = res.getString("sexoCliente");
                    String tipo = res.getString("tipoCliente");
                    String direccion = res.getString("DireccionCliente");
                    String telefono = res.getString("TelefonoCliente");
                    String correo = res.getString("CorreoCliente");
                    cliente = new Cliente(idCliente, CI, nombres, apellidos,sexo,tipo, direccion, telefono, correo);                                                                                                            
                }
                res.close();
                stmt.close();
                conn.close();
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        }
        return cliente;
    }
    public ArrayList<Alquiler> obtenerAlquileresPorCliente(Cliente cliente) {
        Connection conn = null;

        int i = 0;
        try {
            try {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
            } catch (InstantiationException ex) {
            } catch (IllegalAccessException ex) {
            }
            conn = DriverManager.getConnection("jdbc:mysql://localhost/video_club", "root", "1234");
            if (conn != null) {
                Statement stmt = conn.createStatement();
                ResultSet res = stmt.executeQuery("SELECT * FROM alquiler where idclientes="+cliente.getid());


                while (res.next()) {
                    Integer id = res.getInt("idalquiler");
                    String fechaInicio = res.getString("fechainicioalquiler");
                    String horaInicio = res.getString("horainicioalquiler");
                    String fechaFin = res.getString("fechafinalquiler");
                    Double montoTotal = res.getDouble("montototalalquiler");
                    Integer cantidadEjemplares = res.getInt("cantidadejemplaresalquilados");
                    alquiler = new Alquiler(id, fechaInicio, horaInicio, fechaFin, montoTotal, cantidadEjemplares, cliente);
                    
                    listaAlquileres.add(i, alquiler);
                    i++;

                }
                res.close();
                stmt.close();
                conn.close();
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        }
        return listaAlquileres;
    }
 public void insertarAlquiler(Alquiler alq) {
        Connection conexion = null;
        try {
            try {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
            } catch (InstantiationException ex) {
            } catch (IllegalAccessException ex) {
            }
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/video_club", "root", "1234");
            String insert = "insert into alquiler (fechainicioalquiler,horainicioalquiler,fechafinalquiler,montototalalquiler,cantidadejemplaresalquilados,idclientes) values (?,?,?,?,?,?)";
            if (conexion != null) {
                PreparedStatement stmt = (PreparedStatement) conexion.prepareStatement(insert);
                stmt.setString(1, alq.getFechaInicioAlquiler());
                stmt.setString(2, alq.getHoraInicioAlquiler());
                stmt.setString(3, alq.getFechaFinAlquiler());
                stmt.setDouble(4, alq.getPrecioTotalAlquiler());
                stmt.setDouble(5, alq.getCantidadPeliculasAlquiladas());
                stmt.setInt(6, alq.getCliente().getid());
                stmt.executeUpdate();
                System.out.println("inserto con exito");
            }
        } catch (Exception e) {
            System.out.println("" + e.getMessage());
        }
    }
 public void insertarDetalleAlquiler(DetalleAlquiler da) {
        Connection conexion = null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/video_club", "root", "1234");
            String insert = "insert into detallesalquiler (cantidadlineadetallealquiler,importelineadetallealquiler,idalquiler,idejemplar) values (?,?,?,?)";
            if (conexion != null) {
                PreparedStatement stmt = (PreparedStatement) conexion.prepareStatement(insert);
                stmt.setInt(1, da.getCantidadLineaDetalleAlquiler());
                stmt.setDouble(2, da.getImporteLineaDetalleAlquiler());
                stmt.setInt(3, da.getAlquiler().getIdAlquiler());
                stmt.setString(4, da.getEjemplar().getId());
                stmt.executeUpdate();
            }
        } catch (Exception e) {
            System.out.println("" + e.getMessage());
        }
    }

    public ArrayList<DetalleAlquiler> obtenerTodosLosDetallesPorAlquiler(Alquiler alquiler) {
        Connection conn = null;

        int i = 0;
        try {
            try {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
            } catch (InstantiationException ex) {
            } catch (IllegalAccessException ex) {
            }
            conn = DriverManager.getConnection("jdbc:mysql://localhost/video_club", "root", "1234");
            if (conn != null) {
                Statement stmt = conn.createStatement();
                ResultSet res = stmt.executeQuery("SELECT * FROM detallesalquiler where idalquiler=" + alquiler.getIdAlquiler());


                while (res.next()) {
                    Integer idDetalleAlquiler = res.getInt("iddetallealquiler");
                    Integer cantidadlineadetallealquiler = res.getInt("cantidadlineadetallealquiler");
                    Double importelineadetallealquiler = res.getDouble("importelineadetallealquiler");
                    String idEjemplar = res.getString("idejemplar");

                    Ejemplar ejemplar = buscarEjemplar(idEjemplar);

                    detalleAlquiler = new DetalleAlquiler(idDetalleAlquiler, cantidadlineadetallealquiler, importelineadetallealquiler, alquiler, ejemplar);

                    listaDetalleAlquiler.add(i, detalleAlquiler);
                    i++;

                }
                res.close();
                stmt.close();
                conn.close();
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        }
        return listaDetalleAlquiler;

    }

    private Ejemplar buscarEjemplar(String idEjemplar) {
        ConeccionBD1 edao = new ConeccionBD1();

        return edao.obtenerEjemplarPorId(idEjemplar);
    }
    
    public void insertarDevolucion(Devolucion devol) {
         Connection conexion = null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/video_club", "root", "1234");
            String insert = "insert into devolucion (fechadevolucion,horadevolucion,cantidadejemplaresdevueltos ,diasdemoradevolucion,deudatotaldevolucion,idclientes) values (?,?,?,?,?,?)";
            if (conexion != null) {
                PreparedStatement stmt = (PreparedStatement) conexion.prepareStatement(insert);
                stmt.setString(1, devol.getFecha());
                stmt.setString(2, devol.getHora());
                stmt.setInt(3, devol.getCantidadEjemplaresDevueltos());
                stmt.setInt(4, devol.getDiasDeMora());
                stmt.setDouble(5, devol.getDeudaDotal());
                stmt.setInt(6, devol.getCliente().getid());
                stmt.executeUpdate();
                System.out.println("inserto con exito");
            }
        } catch (Exception e) {
            System.out.println("" + e.getMessage());
            System.out.println("entro a la excepcion...");
        }
    }

    public Devolucion obtenerDevolucion() {
         Connection conn = null;
        try {
            try {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
            } catch (InstantiationException ex) {
            } catch (IllegalAccessException ex) {
            }
            conn = DriverManager.getConnection("jdbc:mysql://localhost/video_club", "root", "1234");
            if (conn != null) {
                Statement stmt = conn.createStatement();
                ResultSet res = stmt.executeQuery("SELECT * FROM devolucion");

                while (res.next()) {
                    Integer id = res.getInt("iddevolucion");
                    String fechadevolucion = res.getString("fechadevolucion");
                    String horadevolucion = res.getString("horadevolucion");
                    Integer cantidadejemplaresdevueltos = res.getInt("cantidadejemplaresdevueltos");
                    Integer diasdemoradevolucion = res.getInt("diasdemoradevolucion");
                    Integer deudatotaldevolucion = res.getInt("deudatotaldevolucion");
                    Integer idCliente = res.getInt("idclientes");

                    Cliente cliente = buscarCliente(idCliente);
                    devolucion = new Devolucion(id, fechadevolucion, horadevolucion, cantidadejemplaresdevueltos, diasdemoradevolucion,deudatotaldevolucion, cliente);
                }
                res.close();
                stmt.close();
                conn.close();
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        }
        return devolucion;
    }
    public void insertarDetalleDevolucion(DetalleDevolucion dv) {
        Connection conexion = null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/video_club", "root", "1234");
            String insert = "insert into detalledevolucion (cantidadlineadetalledevolucion,idejemplar, diasdemora,deudalinea,iddevolucion) values (?,?,?,?,?)";
            if (conexion != null) {
                PreparedStatement stmt = (PreparedStatement) conexion.prepareStatement(insert);
                stmt.setInt(1, dv.getCantidadLineaDetalle());
                stmt.setString(2, dv.getEjemplar().getId());
                stmt.setInt(3, dv.getDiasDeMora());
                stmt.setInt(4, dv.getDeudaLinea());
                stmt.setInt(5, dv.getDevolucion().getId());
                stmt.executeUpdate();
            }
        } catch (Exception e) {
            System.out.println("" + e.getMessage());
        }
    }
     public void insertarVenta(Venta v) {
         Connection conexion = null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/video_club", "root", "1234");
            String insert = "insert into venta (idVenta,fechaventa,horaventa,montototalventa,idclientes, cod_usuario) values (?,?,?,?,?,?)";
            if (conexion != null) {
                PreparedStatement stmt = (PreparedStatement) conexion.prepareStatement(insert);
                stmt.setInt(1, v.getIdVenta());
                stmt.setString(2, v.getFechaVenta());
                stmt.setString(3, v.getHoraVenta());
                stmt.setDouble(4, v.getMontoTotalVenta());                
                stmt.setInt(5, v.getCliente().getid());
                stmt.setInt(6, v.getcodUsuario());
                
                stmt.executeUpdate();
                System.out.println("inserto con exito");
            }
        } catch (Exception e) {
            System.out.println("" + e.getMessage());
        }
    }

    public Venta obtenerVenta() {
        Connection conn = null;
        try {
            try {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
            } catch (InstantiationException ex) {
            } catch (IllegalAccessException ex) {
            }
            conn = DriverManager.getConnection("jdbc:mysql://localhost/video_club", "root", "1234");
            if (conn != null) {
                Statement stmt = conn.createStatement();
                ResultSet res = stmt.executeQuery("SELECT * FROM venta");

                while (res.next()) {
                    Integer id = res.getInt("idventa");
                    String fecha = res.getString("fechaventa");
                    String hora = res.getString("horaventa");                    
                    Double montoTotal = res.getDouble("montototalventa");                    
                    Integer idCliente = res.getInt("idclientes");
                    Integer Funcionario = res.getInt("cod_usuario");

                    Cliente cliente = buscarCliente(idCliente);
                    venta = new Venta(id, fecha, hora, montoTotal, cliente,Funcionario);
                }
                res.close();
                stmt.close();
                conn.close();
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        }
        return venta;
    }
    public void insertarDetalleVenta(DetalleVenta dv) {
        Connection conexion = null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/video_club", "root", "1234");
            String insert = "insert into detalleventa (cantidadlineadetalleventa,importedetalleventa,idventa,idejemplar) values (?,?,?,?)";
            if (conexion != null) {
                PreparedStatement stmt = (PreparedStatement) conexion.prepareStatement(insert);
                stmt.setInt(1, dv.getCantidadLineaDetalleVenta());
                stmt.setDouble(2, dv.getImporteLineaDetalleVenta());
                stmt.setInt(3, dv.getVenta().getIdVenta());
                stmt.setString(4, dv.getEjemplar().getId());
                stmt.executeUpdate();
            }
        } catch (Exception e) {
            System.out.println("" + e.getMessage());
        }
        
    }

    
    /** Cierra la conexi�n con la base de datos */
    public void cierraConexion() {
        try {
            conexion.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

   

   
    

   
}
