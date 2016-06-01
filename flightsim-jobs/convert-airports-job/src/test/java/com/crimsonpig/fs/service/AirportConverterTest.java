package com.crimsonpig.fs.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.crimsonpig.fs.domain.airport.Airport;
import com.crimsonpig.fs.domain.airport.ConvertedAirport;

@RunWith(JUnit4.class)
public class AirportConverterTest {
	
	private final double DOUBLE_ACCEPTANCE_INTERVAL = 0.000000001;
	
	@Test
	public void convertAmericanAirportTest(){
		Airport airport = new Airport();
		airport.setIdentifier("KLAX");
		airport.setLatitude("N33* 56.55220'");
		airport.setLongitude("W118* 24.48450'");
		airport.setElevation(125);
		AirportConverter converter = new AirportConverter();
		ConvertedAirport convertedAirport = converter.convertAirport(airport);
		assertEquals(airport.getIdentifier(), convertedAirport.getIdentifier());
		assertEquals(airport.getElevation(), convertedAirport.getElevation());
		assertEquals(0.592409021, convertedAirport.getLatitudeRadians(), DOUBLE_ACCEPTANCE_INTERVAL);
		assertEquals(-2.06661077, convertedAirport.getLongitudeRadians(), DOUBLE_ACCEPTANCE_INTERVAL);
	}

	@Test
	public void convertEuropeanAirportTest(){
		Airport airport = new Airport();
		airport.setIdentifier("EDDF");
		airport.setLatitude("N50* 01.99830'");
		airport.setLongitude("E08* 34.22730'");
		airport.setElevation(364);
		AirportConverter converter = new AirportConverter();
		ConvertedAirport convertedAirport = converter.convertAirport(airport);
		assertEquals(airport.getIdentifier(), convertedAirport.getIdentifier());
		assertEquals(airport.getElevation(), convertedAirport.getElevation());
		assertEquals(0.873245908, convertedAirport.getLatitudeRadians(), DOUBLE_ACCEPTANCE_INTERVAL);
		assertEquals(-0.149582658, convertedAirport.getLongitudeRadians(), DOUBLE_ACCEPTANCE_INTERVAL);
	}

}
