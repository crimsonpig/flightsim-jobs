package com.crimsonpig.fs.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.crimsonpig.fs.domain.airport.FS9Airport;
import com.crimsonpig.fs.domain.airport.ConvertedFS9Airport;

@RunWith(JUnit4.class)
public class AirportConverterTest {
	
	private final double DOUBLE_ACCEPTANCE_INTERVAL = 0.000000001;
	
	@Test
	public void convertAmericanAirportTest(){
		FS9Airport fS9Airport = new FS9Airport();
		fS9Airport.setIdentifier("KLAX");
		fS9Airport.setLatitude("N33* 56.55220'");
		fS9Airport.setLongitude("W118* 24.48450'");
		fS9Airport.setElevation(125);
		AirportConverter converter = new AirportConverter();
		ConvertedFS9Airport convertedFS9Airport = converter.convertAirport(fS9Airport);
		assertEquals("KLAX", convertedFS9Airport.getIdentifier());
		assertEquals(125, convertedFS9Airport.getElevation());
		assertEquals(0.592409021, convertedFS9Airport.getLatitudeRadians(), DOUBLE_ACCEPTANCE_INTERVAL);
		assertEquals(-2.06661077, convertedFS9Airport.getLongitudeRadians(), DOUBLE_ACCEPTANCE_INTERVAL);
	}

	@Test
	public void convertEuropeanAirportTest(){
		FS9Airport fS9Airport = new FS9Airport();
		fS9Airport.setIdentifier("EDDF");
		fS9Airport.setLatitude("N50* 01.99830'");
		fS9Airport.setLongitude("E08* 34.22730'");
		fS9Airport.setElevation(364);
		AirportConverter converter = new AirportConverter();
		ConvertedFS9Airport convertedFS9Airport = converter.convertAirport(fS9Airport);
		assertEquals("EDDF", convertedFS9Airport.getIdentifier());
		assertEquals(364, convertedFS9Airport.getElevation());
		assertEquals(0.873245908, convertedFS9Airport.getLatitudeRadians(), DOUBLE_ACCEPTANCE_INTERVAL);
		assertEquals(0.149582658, convertedFS9Airport.getLongitudeRadians(), DOUBLE_ACCEPTANCE_INTERVAL);
	}

	
	@Test
	public void convertPacificAirportTest(){
		FS9Airport fS9Airport = new FS9Airport();
		fS9Airport.setIdentifier("NZAA");
		fS9Airport.setLatitude("S37* 00.48330'");
		fS9Airport.setLongitude("E174* 47.50000'");
		fS9Airport.setElevation(23);
		AirportConverter converter = new AirportConverter();
		ConvertedFS9Airport convertedFS9Airport = converter.convertAirport(fS9Airport);
		assertEquals("NZAA", convertedFS9Airport.getIdentifier());
		assertEquals(23, convertedFS9Airport.getElevation());
		assertEquals(-0.64591241, convertedFS9Airport.getLatitudeRadians(), DOUBLE_ACCEPTANCE_INTERVAL);
		assertEquals(3.050690088, convertedFS9Airport.getLongitudeRadians(), DOUBLE_ACCEPTANCE_INTERVAL);
	}
}
