package com.amil.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

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
public class TimeConvertUtil {
	
	/**
	 * 
	 * <p><b>Convert string time to comparable Timestamp.</b></p>
	 * 
	 * @return Timestamp - The desired Timestamp format.
	 * 
	 */
    public static Timestamp convert(String time) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("mm:ss.SSS");
        
        try {
            Date firstParsedDate = dateFormat.parse(time);
            Timestamp firstTimestamp = new Timestamp(firstParsedDate.getTime());
            
            return firstTimestamp;
        } catch (Exception e) {
            e.printStackTrace();
            
            return null;
        }
    }
}
