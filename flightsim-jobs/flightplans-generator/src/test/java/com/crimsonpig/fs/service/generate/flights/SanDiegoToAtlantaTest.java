package com.crimsonpig.fs.service.generate.flights;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.crimsonpig.fs.domain.route.FlightPlanRouteDefinition;

public class SanDiegoToAtlantaTest extends BaseGenerateFlightTest {

	@Override
	protected FlightPlanRouteDefinition getRouteDefinition() {
		FlightPlanRouteDefinition sanToAtl = new FlightPlanRouteDefinition();
		sanToAtl.setAirline("Delta");
		sanToAtl.setAircraftNumber(118);
		sanToAtl.setAircraftTitle("Boeing 767-300 GE Delta Airlines NC");
		sanToAtl.setGroundspeed(480);
		sanToAtl.setFlightFrequency(8);
		sanToAtl.setOriginTimezone(-7);
		sanToAtl.setOriginAirport("KSAN");
		sanToAtl.setOutboundFlightLevel(370);
		sanToAtl.setDestinationAirport("KATL");
		sanToAtl.setReturnFlightLevel(380);
		sanToAtl.setDistance(1639);
		sanToAtl.setRouteTime(13196);
		return sanToAtl;
	}
	
	@Test
	public void flightPlansTest(){
		assertEquals(4, getFlightPlans().size());
	}
	
	@Test
	public void repetitionTest(){
		getFlightPlans().forEach(flightPlan -> 
			assertEquals("12Hr", flightPlan.getRepetition()));
	}
}
