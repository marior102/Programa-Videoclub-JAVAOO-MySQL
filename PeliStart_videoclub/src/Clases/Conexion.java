/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Clases;
import java.sql.*;
/**
 *
 * @author edgar
 */
public class Conexion {
    
    Connection con;
    Statement  stm;
    ResultSet  rs;
   // String url = "jdbc:postgresql://localhost:5432/stock1";
     String url = "jdbc:mysql://localhost:3306/video_club";
    String user = "root";
    String password = "1234";
    
    public Conexion(){}
    
    public void conectar(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    public boolean ejecurarConsulta(String query){
        try{
            stm = con.createStatement();
            rs = stm.executeQuery(query);
            return true;
        }catch(Exception ex){
            ex.printStackTrace();
            return false;
        }    
        
    }
    public boolean ejecurarActualizacion(String query){
        try{
            stm = con.createStatement();
            int flag =  stm.executeUpdate(query);
            //Se agrego esto por que el executeUpdate devuelve la cantidad de registros afectados
            return true;
            // Idem del comentario anterior
            /*
            if(flag == 1)
                return true;
            else
                return false;
             */
        }catch(Exception ex){
            ex.printStackTrace();
            return false;
        }    
        
    }
    public void desconectar(){
        try{
            if(rs != null)
                rs.close(); 
            if(stm != null)
                stm.close();
            if(con != null)
                con.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }    
    }
    

}
