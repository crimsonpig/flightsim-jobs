package com.crimsonpig.fs.processors;

import static org.junit.Assert.assertEquals;
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
		airportReader.addAirportToRetrieve(ConvertedAirportStubs.getDenAirport());
		airportReader.addAirportToRetrieve(ConvertedAirportStubs.getSmfAirport());
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
		FullRouteDefinition fullRoute = null;
		try {
			fullRoute = processor.process(simpleRoute);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
		assertEquals("B734", fullRoute.getAircraftModel());
		assertEquals("Boeing 737-400 Paint1", fullRoute.getAircraftTitle());
		assertEquals("American Pacific", fullRoute.getAirline());
		assertEquals(1, fullRoute.getAircraftNumber());
		assertEquals(430, fullRoute.getGroundspeed());
		assertEquals(8, fullRoute.getFlightFrequency());
		assertEquals("KSMF", fullRoute.getOriginAirport());
		assertEquals(0.67536243, fullRoute.getOriginLatitude(), 0.00000000001);
		assertEquals(-2.12215942, fullRoute.getOriginLongitude(), 0.00000000001);
		assertEquals(-7, fullRoute.getOriginTimezone());
		assertEquals("KDEN", fullRoute.getDestinationAirport());
		assertEquals(0.69571713, fullRoute.getDestinationLatitude(), 0.00000000001);
		assertEquals(-1.82689160, fullRoute.getDestinationLongitude(), 0.00000000001);

	}
}
