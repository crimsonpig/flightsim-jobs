package com.crimsonpig.fs.service.generate.flights;

import static org.junit.Assert.*;

import java.time.LocalTime;
import java.util.List;

import org.junit.Test;

import com.crimsonpig.fs.domain.flightplan.Leg;
import com.crimsonpig.fs.domain.route.FullRouteDefinition;

public class SacramentoToEugeneTest extends BaseGenerateFlightTest {

	protected FullRouteDefinition getRouteDefinition(){
		FullRouteDefinition smfToEug = new FullRouteDefinition();
		smfToEug.setAircraftNumber(1);
		smfToEug.setAircraftTitle("Boeing 737-400 Paint1");
		smfToEug.setAirline("American Pacific");
		smfToEug.setGroundspeed(430);
		smfToEug.setOriginAirport("KSMF");
		smfToEug.setOriginLatitude(0.67536243);
		smfToEug.setOriginLongitude(-2.12215942);
		smfToEug.setOriginTimezone(-7);
		smfToEug.setDestinationAirport("KEUG");
		smfToEug.setDestinationLatitude(0.77009599);
		smfToEug.setDestinationLongitude(-2.15057143);
		smfToEug.setFlightFrequency(3);
		smfToEug.setLowestFlightLevel(370);
		return smfToEug;
	}
	
	@Test
	public void legsTest(){
		assertEquals(1, getFlightPlans().size());
		List<Leg> flightPlanLegs = getFlightPlans().get(0).getLegs();
		
		assertEquals(6, flightPlanLegs.size());
		Leg firstLeg = flightPlanLegs.get(0);
		Leg secondLeg = flightPlanLegs.get(1);
		assertEquals(334,firstLeg.getDistance(),0.5);
		assertEquals(334,secondLeg.getDistance(),0.5);
		assertEquals(348,firstLeg.getHeading(),0.5);
		assertEquals(167,secondLeg.getHeading(),0.5);
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

