package com.amil.vo;

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
public class CurrentInformationVO {
	
    private String time;
    private String pilotID;
    private String pilotName;
    private String lapNumber;
    private String lapTime;
    private String averageLapSpeed;
    
	/**
	 * @return the time
	 */
	public String getTime() {
		return time;
	}
	/**
	 * @param time the time to set
	 */
	public void setTime(String time) {
		this.time = time;
	}
	/**
	 * @return the pilotID
	 */
	public String getPilotID() {
		return pilotID;
	}
	/**
	 * @param pilotID the pilotID to set
	 */
	public void setPilotID(String pilotID) {
		this.pilotID = pilotID;
	}
	/**
	 * @return the pilotName
	 */
	public String getPilotName() {
		return pilotName;
	}
	/**
	 * @param pilotName the pilotName to set
	 */
	public void setPilotName(String pilotName) {
		this.pilotName = pilotName;
	}
	/**
	 * @return the lapNumber
	 */
	public String getLapNumber() {
		return lapNumber;
	}
	/**
	 * @param lapNumber the lapNumber to set
	 */
	public void setLapNumber(String lapNumber) {
		this.lapNumber = lapNumber;
	}
	/**
	 * @return the lapTime
	 */
	public String getLapTime() {
		return lapTime;
	}
	/**
	 * @param lapTime the lapTime to set
	 */
	public void setLapTime(String lapTime) {
		this.lapTime = lapTime;
	}
	/**
	 * @return the averageLapSpeed
	 */
	public String getAverageLapSpeed() {
		return averageLapSpeed;
	}
	/**
	 * @param averageLapSpeed the averageLapSpeed to set
	 */
	public void setAverageLapSpeed(String averageLapSpeed) {
		this.averageLapSpeed = averageLapSpeed;
	}
    
}
