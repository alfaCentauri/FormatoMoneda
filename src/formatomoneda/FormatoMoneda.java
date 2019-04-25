/*
 * FormatoMoneda.java
 * Licencia GNU
 */
package formatomoneda;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

/**
 * Formato de monedas para java. Uso del locale.
 * @author Ricardo Presilla
 * @version 1.0.
 */
public class FormatoMoneda {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        double valor=353.1416;
        String salida="";
        String patron="#,###,##0.00";
        Locale locacion= new Locale("es","VE");
        NumberFormat nf = NumberFormat.getNumberInstance(locacion);
        DecimalFormat df = (DecimalFormat)nf;
        df.applyPattern(patron);
        for(int i=0; i<10;i++){
            salida=df.format(valor);
            valor=valor*(i+1);
            System.out.println("Patron="+patron + " Salida=" + salida + " Locación=" + locacion.toString());
        }
        //******************************
        System.out.println("leyendo los formatos de monedas.");
        int posicion=salida.lastIndexOf(",");
//        System.out.println("La posición es: "+posicion);
        String entero=salida.substring(0, posicion).replace(".", "");
//        System.out.println("La parte entera es: "+entero.replace(".", ""));
//        String cadena1=entero.replace(".", "");
        String decimal=salida.substring(posicion+1,salida.length());
//        System.out.println("La parte entera es: "+decimal);
        double num=Double.valueOf(entero+"."+decimal);
        System.out.println("El número es: "+num);
        num=num/1000;
        System.out.println("El número entre 1000 es: "+num);
    }
}
