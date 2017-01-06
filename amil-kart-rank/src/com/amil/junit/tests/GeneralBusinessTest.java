package com.amil.junit.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.amil.business.GeneralBusiness;
import com.amil.util.DataLoaderUtil;

/**
 * 
 * <p><b>Tailored for Amil Corporation.</b></p>
 * 
 * NOTA: POUCAS COISAS PUDERAM SER TESTADAS VIA JUNIT POIS UTILIZEI SWING PARA DESENVOLVER ESTA APP.
 * 
 * Requested by: Paulo Souza
 * Company: CUBO TECNOLOGIA
 * 
 * @author Dimitri Martins
 *
 */
public class GeneralBusinessTest {
	
	@Test
	public void testAscendingLapTimesLoading() {
		DataLoaderUtil.fullQualifiedPath = "E:\\sample-data.csv";
		
		Boolean expected = (GeneralBusiness.orderLapTimesAscending() != null);
		
		assertEquals(expected, true);
	}
	
	@Test
	public void getBestLapTimeByPilotID() {
		DataLoaderUtil.fullQualifiedPath = "E:\\sample-data.csv";
		
		Boolean expected = (GeneralBusiness.getBestLapTimeByPilotID("038") != null);
		
		assertEquals(expected, true);
	}
	
	@Test
	public void getAveragePilotDrivingSpeed() {
		DataLoaderUtil.fullQualifiedPath = "E:\\sample-data.csv";
		
		Boolean expected = (GeneralBusiness.getAveragePilotDrivingSpeed("038") != null);
		
		assertEquals(expected, true);
	}
	
}