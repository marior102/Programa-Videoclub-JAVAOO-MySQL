package Clases;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.GregorianCalendar;

public class Base {
    //con este metodo capturamos la fecha actual

    public static String getFecha() {
        String fechaActual = null;
        //La clase GregorianCalendar es una subclase de 
        //Calendar y maneja el calendario estandar usado en el mundo
        GregorianCalendar fecha = new GregorianCalendar();
        int dia = fecha.get(fecha.DAY_OF_MONTH);
        int mes = (fecha.get(fecha.MONTH)) + 1;
        int anio = fecha.get(fecha.YEAR);
        fechaActual = "" + dia + "/" + mes + "/" + anio;

        return fechaActual;
    }
        //es este metodo capturamos la hora actual
    public static String getHora() {
        String horaActual = null;
        GregorianCalendar fecha = new GregorianCalendar();
        int segundo = fecha.get(fecha.SECOND);
        int minuto = fecha.get(fecha.MINUTE);
        int hora = fecha.get(fecha.HOUR);

        horaActual = "" + hora + ":" + minuto + ":" + segundo;
        return horaActual;

    }

    public static void mostrar(String texto) {
        System.out.println(texto);
    }

    public static String leerDato() {
        String dato = "inicio";
        try {
            BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
            dato = teclado.readLine();
        } catch (Exception e) {
            mostrar("Error en el ingreso de datos por consola...");
        }
        return dato;
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

    public static double convertirCadenaReal(String cadena) {
        double dato = 999;
        try {
            dato = Double.parseDouble(cadena);
        } catch (Exception e) {
            mostrar("Error al convertir Cadena - " + cadena + " - a Real.");
        }
        return dato;
    }

    public static String getFechaEnLetra() {
        String dato;
        dato = getDia() + " de " + getMesEnLetra(convertirCadenaEntero(getMes())) + " del " + getAnio();
        return dato;
    }

    public static String getDia() {
        GregorianCalendar calendario = new GregorianCalendar();
        String dato = "" + calendario.get(calendario.DAY_OF_MONTH);
        return dato;
    }

    public static String getMes() {
        GregorianCalendar calendario = new GregorianCalendar();
        String dato = "" + ((calendario.get(calendario.MONTH)) + 1);
        return dato;
    }

    public static String getMesEnLetra(int mes) {
        String dato = "";
        switch (mes) {
            case 1:
                dato = "Enero";
                break;
            case 2:
                dato = "Febrero";
                break;
            case 3:
                dato = "Marzo";
                break;
            case 4:
                dato = "Abril";
                break;
            case 5:
                dato = "Mayo";
                break;
            case 6:
                dato = "Junio";
                break;
            case 7:
                dato = "Julio";
                break;
            case 8:
                dato = "Agosto";
                break;
            case 9:
                dato = "Setiembre";
                break;
            case 10:
                dato = "Octubre";
                break;
            case 11:
                dato = "Noviembre";
                break;
            case 12:
                dato = "Diciembre";
                break;
        }
        return dato;
    }

    public static String getAnio() {
        GregorianCalendar calendario = new GregorianCalendar();
        String dato = "" + calendario.get(calendario.YEAR);
        return dato;
    }

    public static String getDiaEnLetra() {
        GregorianCalendar calendario = new GregorianCalendar();
        int dia = calendario.get(calendario.DAY_OF_WEEK);
        String dato = "";

        switch (dia) {
            case 1:
                dato = "Domingo";
                break;
            case 2:
                dato = "Lunes";
                break;
            case 3:
                dato = "Martes";
                break;
            case 4:
                dato = "Miercoles";
                break;
            case 5:
                dato = "Jueves";
                break;
            case 6:
                dato = "Viernes";
                break;
            case 7:
                dato = "Sábado";
                break;
        }
        return dato;
    }
}