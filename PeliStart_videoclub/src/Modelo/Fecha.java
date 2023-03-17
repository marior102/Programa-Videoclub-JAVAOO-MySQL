/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;
import java.util.Calendar;
import java.util.Date;
/**
 *
 * @author Ruben
 */
public class Fecha {
    String sDia;
    String sMes;
    int sAño;
    String fecha;
    public Fecha(Date unaFecha){
        Calendar cal = Calendar.getInstance();
        cal.setTime(unaFecha);
        int dia = cal.get(Calendar.DAY_OF_MONTH);
        int mes = cal.get(Calendar.MONTH);
        
        if ( dia<10){
            sDia = "0";
            sDia +=dia;
            
        }else {
            sDia= ""+dia;
        }
        if (mes<10){
            sMes= "0";
        }
        sMes += mes;
        sAño = cal.get(Calendar.YEAR);
        fecha = sAño+"-"+sMes+"-"+sDia;
    }
    public String getFecha(){
        return fecha;
    }
    public int getAño(){
        return sAño;
    }
    public int getMes(){
        return Integer.parseInt(sMes);
    }
    public int getDia(){
        return Integer.parseInt(sDia);
    }
}
