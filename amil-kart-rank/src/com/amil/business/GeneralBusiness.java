package com.amil.business;

import com.amil.util.DataLoaderUtil;
import com.amil.util.NumericUtil;
import com.amil.util.TimeConvertUtil;
import com.amil.vo.CurrentInformationVO;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;

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
public class GeneralBusiness {
	
	/**
	 * 
	 * <p><b>Retrieves the ordered lap times in ascending mode.</b></p>
	 * 
	 * @return LinkedList<CurrentInformationVO> - The ordered lap times in ascending mode.
	 * 
	 */
    public static LinkedList<CurrentInformationVO> orderLapTimesAscending() {
        LinkedList<CurrentInformationVO> orderedList = new LinkedList<CurrentInformationVO>();
        List<CurrentInformationVO> preloadedComparisonList = DataLoaderUtil.load();
        
        for (CurrentInformationVO pilotToCompare : preloadedComparisonList) { //MASSA
            for (CurrentInformationVO currentComparisonPilot : preloadedComparisonList) { //VETTEL
                Timestamp currentComparisonPilotLapTime = TimeConvertUtil.convert(currentComparisonPilot.getLapTime());
                Timestamp pilotToCompareLapTime = TimeConvertUtil.convert(pilotToCompare.getLapTime());
                
                if (pilotToCompareLapTime.after(currentComparisonPilotLapTime)) {
                	orderedList.add(currentComparisonPilot);
                }
                
            }
        }
        
        return orderedList;
    }

    /**
	 * 
	 * <p><b>Retrieves the best lap time by pilot ID.</b></p>
	 * 
	 * @return Timestamp - The desired best lap time by pilot ID.
	 * 
	 */
    public static Timestamp getBestLapTimeByPilotID(String pilotID) {
        Timestamp bestLapTime = null;
        List<CurrentInformationVO> preloadedComparisonList = DataLoaderUtil.load();
        
        for (CurrentInformationVO pilotToCompare : preloadedComparisonList) {
            if (pilotToCompare.getPilotID().equals(pilotID)) {
            	
            	for (CurrentInformationVO currentComparisonPilot : preloadedComparisonList) {
                    Timestamp currentComparisonPilotLapTime = TimeConvertUtil.convert(currentComparisonPilot.getLapTime());
                    Timestamp pilotToCompareLapTime = TimeConvertUtil.convert(pilotToCompare.getLapTime());
                    
                    if (pilotToCompareLapTime.after(currentComparisonPilotLapTime)) {
                    	bestLapTime = pilotToCompareLapTime;
                    }
                    
                }
            	
            }
        }
        
        return bestLapTime;
    }

    /**
	 * 
	 * <p><b>Retrieves the acerage pilot driving speed during the entire race.</b></p>
	 * 
	 * @return Double - The average desired pilot driving speed.
	 * 
	 */
    public static Double getAveragePilotDrivingSpeed(String pilotID) {
        List<CurrentInformationVO> preloadedComparisonList = DataLoaderUtil.load();
        Double lapSpeedBuffer = 0.0d;
        
        for (CurrentInformationVO pilotToCompare : preloadedComparisonList) {
            if (pilotToCompare.getPilotID().equals(pilotID)) {
            	Double currentLapSpeed = NumericUtil.getRealNumber(pilotToCompare.getAverageLapSpeed());
            	
            	lapSpeedBuffer = lapSpeedBuffer + currentLapSpeed;
            }
        }
        
        return lapSpeedBuffer / 4.0d;
    }
}

