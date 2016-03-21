package com.crimsonpig.fs.service.generate.flights;

import static org.junit.Assert.*;

import java.time.LocalTime;
import java.util.List;

import org.junit.Test;

import com.crimsonpig.fs.domain.flightplan.Leg;
import com.crimsonpig.fs.domain.route.FlightPlanRouteDefinition;

public class SacramentoToEugeneTest extends BaseGenerateFlightTest {

	protected FlightPlanRouteDefinition getRouteDefinition(){
		FlightPlanRouteDefinition smfToEug = new FlightPlanRouteDefinition();
		smfToEug.setAircraftNumber(1);
		smfToEug.setAircraftTitle("Boeing 737-400 Paint1");
		smfToEug.setAirline("American Pacific");
		smfToEug.setGroundspeed(430);
		smfToEug.setOriginAirport("KSMF");
		smfToEug.setOutboundFlightLevel(380);
		smfToEug.setOriginTimezone(-7);
		smfToEug.setDestinationAirport("KEUG");
		smfToEug.setReturnFlightLevel(370);
		smfToEug.setFlightFrequency(3);
		smfToEug.setDistance(334);
		smfToEug.setRouteTime(3697);
		return smfToEug;
	}
	
	@Test
	public void legsTest(){
		assertEquals(1, getFlightPlans().size());
		List<Leg> flightPlanLegs = getFlightPlans().get(0).getLegs();
		
		assertEquals(6, flightPlanLegs.size());
		Leg firstLeg = flightPlanLegs.get(0);
		Leg secondLeg = flightPlanLegs.get(1);

		//Remember, all times are in GMT so 6:00 local time at KSMF is 13:00 GMT.
		assertLeg(firstLeg, LocalTime.of(13, 0, 0), LocalTime.of(14, 1, 34));
		assertEquals(380, firstLeg.getFlightLevel());
		assertEquals(370, secondLeg.getFlightLevel());
		assertLeg(secondLeg, LocalTime.of(15, 1, 34), LocalTime.of(16, 3, 8));
	}

	@Test
	public void flightPlansTest(){
		assertEquals(1, getFlightPlans().size());
	}
	
	@Test
	public void repetitionTest(){
		getFlightPlans().forEach(flightPlan -> assertEquals("8Hr", flightPlan.getRepetition()));
	}
}

