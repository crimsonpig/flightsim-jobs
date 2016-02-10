package com.crimsonpig.fs.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.crimsonpig.fs.domain.airport.Airport;
import com.crimsonpig.fs.domain.airport.ConvertedAirport;
import com.crimsonpig.fs.processors.AirportProcessor;

@RunWith(JUnit4.class)
public class AirportConverterTest {
	
	private final double DOUBLE_ACCEPTANCE_INTERVAL = 0.000000001;
	
	@Test
	public void convertAirportTest(){
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
	public void airportProcessorTest(){
		Airport airport = new Airport();
		airport.setIdentifier("KLAX");
		airport.setLatitude("N33* 56.55220'");
		airport.setLongitude("W118* 24.48450'");
		airport.setElevation(125);
		AirportProcessor processor = new AirportProcessor();
		ConvertedAirport convertedAirport;
		try {
			convertedAirport = processor.process(airport);
			assertEquals(airport.getIdentifier(), convertedAirport.getIdentifier());
			assertEquals(airport.getElevation(), convertedAirport.getElevation());
			assertEquals(0.592409021, convertedAirport.getLatitudeRadians(), DOUBLE_ACCEPTANCE_INTERVAL);
			assertEquals(-2.06661077, convertedAirport.getLongitudeRadians(), DOUBLE_ACCEPTANCE_INTERVAL);		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
