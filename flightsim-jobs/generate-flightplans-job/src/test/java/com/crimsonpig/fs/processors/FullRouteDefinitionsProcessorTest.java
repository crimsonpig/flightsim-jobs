package com.crimsonpig.fs.processors;

import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import com.crimsonpig.fs.config.readers.*;
import com.crimsonpig.fs.domain.route.*;
import com.crimsonpig.fs.service.retrieve.*;

public class FullRouteDefinitionsProcessorTest {

	private FullRouteDefinitionsProcessor processor;
	
	@Before
	public void setUp(){
		processor = new FullRouteDefinitionsProcessor();
		
		RetrieveAirportService airportService = new RetrieveAirportService();
		airportService.setDatabaseReader(new SingleConvertedAirportReader());
		processor.setAirportService(airportService);
		
		RetrieveFlightplanAircraftService aircraftService = new RetrieveFlightplanAircraftService();
		aircraftService.setDatabaseReader(new SingleFlightplanAircraftReader());
		processor.setAircraftService(aircraftService);
	}
	
	@Test
	public void testProcessRouteDefinition(){
		
		SimpleRouteDefinition simpleRoute = new SimpleRouteDefinition();
		try {
			FullRouteDefinition fullRoute = processor.process(simpleRoute);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
}
