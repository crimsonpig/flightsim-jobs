package com.crimsonpig.fs.domain;


import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.crimsonpig.fs.domain.airport.FS9Airport;
import com.crimsonpig.fs.domain.airport.ConvertedFS9Airport;

@RunWith(JUnit4.class)
public class PojoTest {
	
	@Test
	public void airportTest(){
		FS9Airport ap = new FS9Airport();
		ap.setIdentifier("KLAX");
		ap.setLatitude("N33* 56.55220'");
		ap.setLongitude("W118* 24.48450'");
		ap.setElevation(125);
		assertEquals("KLAX", ap.getIdentifier());
		assertEquals("N33* 56.55220'", ap.getLatitude());
		assertEquals("W118* 24.48450'", ap.getLongitude());
		assertEquals(125, ap.getElevation());
	}
	
	@Test
	public void convertedAirportTest(){
		ConvertedFS9Airport ap = new ConvertedFS9Airport();
		ap.setIdentifier("KLAX");
		ap.setLatitudeRadians(0.592409021);
		ap.setLongitudeRadians(-2.06661077);
		ap.setElevation(125);
		assertEquals("KLAX", ap.getIdentifier());
		assertEquals(0.592409021, ap.getLatitudeRadians(), 0.000000001);
		assertEquals(-2.06661077, ap.getLongitudeRadians(), 0.000000001);
		assertEquals(125, ap.getElevation());
	}
}
