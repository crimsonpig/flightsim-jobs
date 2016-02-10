package com.crimsonpig.fs.service.generate.flights;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.crimsonpig.fs.domain.route.FullRouteDefinition;

public class SanDiegoToAtlantaTest extends BaseGenerateFlightTest {

	@Override
	protected FullRouteDefinition getRouteDefinition() {
		FullRouteDefinition sanToAtl = new FullRouteDefinition();
		sanToAtl.setAirline("Delta");
		sanToAtl.setAircraftNumber(118);
		sanToAtl.setAircraftTitle("Boeing 767-300 GE Delta Airlines NC");
		sanToAtl.setGroundspeed(480);
		sanToAtl.setLowestFlightLevel(370);
		sanToAtl.setFlightFrequency(8);
		sanToAtl.setOriginTimezone(-7);
		sanToAtl.setOriginAirport("KSAN");
		sanToAtl.setOriginLatitude(0.57130831);
		sanToAtl.setOriginLongitude(-2.04534553);
		sanToAtl.setDestinationAirport("KATL");
		sanToAtl.setDestinationLatitude(0.58713653);
		sanToAtl.setDestinationLongitude(-1.47352817);
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
