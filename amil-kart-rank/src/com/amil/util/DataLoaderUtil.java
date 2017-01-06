package com.amil.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import com.amil.vo.CurrentInformationVO;

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
public class DataLoaderUtil {
    public static String fullQualifiedPath = null;

    /**
	 * 
	 * <p><b>Load informations from data file.</b></p>
	 * 
	 * @return List<CurrentInformationVO> - The desired informations.
	 * 
	 */
    public static List<CurrentInformationVO> load() {
        ArrayList<CurrentInformationVO> pilotInformationsList = new ArrayList<CurrentInformationVO>();
        try {
            BufferedReader read = new BufferedReader(new FileReader("E:\\sample-data.csv"));
            String line = null;
            int lineCursor = 0;
            
            while ((line = read.readLine()) != null) {
                if (lineCursor > 0) {
                    StringTokenizer tokens = new StringTokenizer(line);
                    String time = tokens.nextToken();
                    String pilotID = tokens.nextToken();
                    
                    tokens.nextToken(); //Ignore hifen.
                    
                    String pilotName = tokens.nextToken();
                    String lapNumber = tokens.nextToken();
                    String lapTime = tokens.nextToken();
                    String averageLapSpeed = tokens.nextToken();
                    
                    CurrentInformationVO p = new CurrentInformationVO();
                    
                    p.setTime(time);
                    p.setPilotID(pilotID);
                    p.setPilotName(pilotName);
                    p.setLapNumber(lapNumber);
                    p.setLapTime(lapTime);
                    p.setAverageLapSpeed(averageLapSpeed);
                    
                    pilotInformationsList.add(p);
                }
                
                lineCursor++;
            }
            read.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return pilotInformationsList;
    }
}

