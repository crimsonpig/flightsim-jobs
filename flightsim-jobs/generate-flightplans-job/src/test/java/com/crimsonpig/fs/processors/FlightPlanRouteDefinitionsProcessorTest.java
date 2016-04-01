package com.crimsonpig.fs.processors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import com.crimsonpig.fs.domain.route.FlightPlanRouteDefinition;
import com.crimsonpig.fs.domain.route.FullRouteDefinition;
import com.crimsonpig.fs.service.*;

public class FlightPlanRouteDefinitionsProcessorTest {

	@Test
	public void buildFlightPlanRouteDefinitions(){
		
		FlightPlanRouteDefinitionsProcessor processor = new FlightPlanRouteDefinitionsProcessor();
		processor.setDistanceAndHeading(new DistanceAndHeadingService());
		processor.setFlightLevelService(new FlightLevelService());
		processor.setRouteDefinitionsService(new FlightPlanRouteDefinitionsService());
		processor.setRouteTimesService(new RouteTimesService());
		
		FullRouteDefinition smfToDen = new FullRouteDefinition();
		smfToDen.setAircraftNumber(1);
		smfToDen.setAircraftTitle("Boeing 737-400 Paint1");
		smfToDen.setAircraftModel("B734");
		smfToDen.setAirline("American Pacific");
		smfToDen.setGroundspeed(430);
		smfToDen.setOriginAirport("KSMF");
		smfToDen.setOriginLatitude(0.67536243);
		smfToDen.setOriginLongitude(-2.12215942);
		smfToDen.setOriginTimezone(-7);
		smfToDen.setDestinationAirport("KDEN");
		smfToDen.setDestinationLatitude(0.69571713);
		smfToDen.setDestinationLongitude(-1.82689160);
		smfToDen.setFlightFrequency(8);
		smfToDen.setLowestFlightLevel(370);
		
		FlightPlanRouteDefinition flightPlanRoute = null;
		try {
			flightPlanRoute = processor.process(smfToDen);
		} catch (Exception e) {
			fail();
		}
		assertEquals("B734", flightPlanRoute.getAircraftModel());
		assertEquals("Boeing 737-400 Paint1", flightPlanRoute.getAircraftTitle());
		assertEquals("American Pacific", flightPlanRoute.getAirline());
		assertEquals(1, flightPlanRoute.getAircraftNumber());
		assertEquals(430, flightPlanRoute.getGroundspeed());
		assertEquals(8, flightPlanRoute.getFlightFrequency());
		assertEquals("KSMF", flightPlanRoute.getOriginAirport());
		assertEquals(-7, flightPlanRoute.getOriginTimezone());
		assertEquals(370, flightPlanRoute.getOutboundFlightLevel());
		assertEquals("KDEN", flightPlanRoute.getDestinationAirport());
		assertEquals(380, flightPlanRoute.getReturnFlightLevel());
		assertEquals(788, flightPlanRoute.getDistance(), 0.5);
		assertEquals(7500, flightPlanRoute.getRouteTime(), 10);

	}
	
}
