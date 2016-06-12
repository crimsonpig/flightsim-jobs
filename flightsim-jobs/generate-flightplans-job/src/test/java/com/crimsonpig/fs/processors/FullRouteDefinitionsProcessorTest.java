package com.crimsonpig.fs.processors;

import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import com.crimsonpig.fs.domain.route.*;
import com.crimsonpig.fs.service.retrieve.*;
import com.crimsonpig.fs.stubs.ConvertedAirportStubs;
import com.crimsonpig.fs.stubs.FlightplanAircraftStubs;
import com.crimsonpig.fs.stubs.SimpleRouteDefinitionStubs;
import com.crimsonpig.fs.stubs.readers.*;

public class FullRouteDefinitionsProcessorTest {

	private FullRouteDefinitionsProcessor processor;
	
	@Before
	public void setUp(){
		processor = new FullRouteDefinitionsProcessor();
		
		RetrieveAirportService airportService = new RetrieveAirportService();
		StubConvertedAirportReader airportReader = new StubConvertedAirportReader();
		airportReader.addAirportToRetrieve(ConvertedAirportStubs.getSmfAirport());
		airportReader.addAirportToRetrieve(ConvertedAirportStubs.getDenAirport());
		airportService.setDatabaseReader(airportReader);
		processor.setAirportService(airportService);
		
		RetrieveFlightplanAircraftService aircraftService = new RetrieveFlightplanAircraftService();
		StubFlightplanAircraftReader aircraftReader = new StubFlightplanAircraftReader();
		aircraftReader.addAircraftToList(FlightplanAircraftStubs.getGeneric737400());
		aircraftService.setDatabaseReader(aircraftReader);
		processor.setAircraftService(aircraftService);
	}
	
	@Test
	public void testProcessRouteDefinition(){
		
		SimpleRouteDefinition simpleRoute = SimpleRouteDefinitionStubs.getSmfToDen();
		try {
			FullRouteDefinition fullRoute = processor.process(simpleRoute);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
}
