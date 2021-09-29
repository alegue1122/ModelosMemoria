
package com.gestionmemoria.utils;

public class Utils {
    
    
    public static long convertMbsaBytes(double Mbs){
        return (long) Math.round((Mbs*1024*1024)-1);
    }
    
    public static String convertDecimaltoHexa(long number){
        return Long.toHexString(number);
    }
}
