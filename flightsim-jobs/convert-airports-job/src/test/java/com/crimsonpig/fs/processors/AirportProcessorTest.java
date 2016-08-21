package com.crimsonpig.fs.processors;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.crimsonpig.fs.domain.airport.FS9Airport;
import com.crimsonpig.fs.domain.airport.ConvertedFS9Airport;

public class AirportProcessorTest {
	
	private final double DOUBLE_ACCEPTANCE_INTERVAL = 0.000000001;
	
	@Test
	public void airportProcessorTest(){
		FS9Airport fS9Airport = new FS9Airport();
		fS9Airport.setIdentifier("KLAX");
		fS9Airport.setLatitude("N33* 56.55220'");
		fS9Airport.setLongitude("W118* 24.48450'");
		fS9Airport.setElevation(125);
		AirportProcessor processor = new AirportProcessor();
		ConvertedFS9Airport convertedFS9Airport;
		try {
			convertedFS9Airport = processor.process(fS9Airport);
			assertEquals(fS9Airport.getIdentifier(), convertedFS9Airport.getIdentifier());
			assertEquals(fS9Airport.getElevation(), convertedFS9Airport.getElevation());
			assertEquals(0.592409021, convertedFS9Airport.getLatitudeRadians(), DOUBLE_ACCEPTANCE_INTERVAL);
			assertEquals(-2.06661077, convertedFS9Airport.getLongitudeRadians(), DOUBLE_ACCEPTANCE_INTERVAL);		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
