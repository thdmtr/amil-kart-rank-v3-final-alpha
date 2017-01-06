package com.amil.util;

/**
 * 
 * <p><b>Tailored for Amil Corporation.</b></p>
 * 
 * Requested by: Paulo Souza
 * Company: CUBO TECNOLOGIA
 * 
 * @author Dimitri Martins
 *
 */
public class NumericUtil {
	
	
    public static Double getRealNumber(String numberRepresentation) {
        Double d = Double.parseDouble(numberRepresentation.replace(",", "."));
        
        return d;
    }
}

