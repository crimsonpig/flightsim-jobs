package com.crimsonpig.fs.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.crimsonpig.fs.domain.aircraft.FlightplanAircraft;
import com.crimsonpig.fs.domain.route.FlightPlanRouteDefinition;
import com.crimsonpig.fs.domain.route.FullRouteDefinition;

public class FlightPlanRouteDefinitionsServiceTest {

	@Test
	public void testFlightPlanRouteDefinitions(){
		
		FullRouteDefinition item = new FullRouteDefinition();
		item.setOriginAirport("KSMF");
		item.setDestinationAirport("KDEN");
		item.setFlightFrequency(8);
		item.setOriginTimezone(-7);
		item.setAircraftNumber(1);
		item.setAircraftTitle("Boeing 737-400 Paint1");
		item.setAirline("American Pacific");
		item.setAircraftModel("B734");
		
		
		FlightPlanRouteDefinitionsService service = new FlightPlanRouteDefinitionsService();
		FlightPlanRouteDefinition fpRouteDefinitions = service.populateFlightPlanRouteDefinition(item);
		
		FlightplanAircraft fpAircraft = new FlightplanAircraft();
		fpAircraft.setAcId(1);
		fpAircraft.setTitle("Boeing 737-400 Paint1");
		fpAircraft.setAirline("American Pacific");
		fpAircraft.setAtcModel("B734");
		
		assertEquals("KSMF", fpRouteDefinitions.getOriginAirport());
		assertEquals("KDEN", fpRouteDefinitions.getDestinationAirport());
		assertEquals(8, fpRouteDefinitions.getFlightFrequency());
		assertEquals(-7, fpRouteDefinitions.getOriginTimezone());
		assertEquals(fpAircraft.getAcId(), fpRouteDefinitions.getAircraftNumber());
		assertEquals(fpAircraft.getTitle(), fpRouteDefinitions.getAircraftTitle());
		assertEquals(fpAircraft.getAtcModel(), fpRouteDefinitions.getAircraftModel());
		assertEquals(fpAircraft.getAirline(), fpRouteDefinitions.getAirline());

	}
	
}
