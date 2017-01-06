package com.amil.junit.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.amil.util.DataLoaderUtil;

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
public class DataLoaderUtilTest {
	
	@Test
	public void testLoading() {
		Boolean expected = (DataLoaderUtil.load().size() > 0);
		
		assertEquals(expected, true);
	}
	
}