package com.crimsonpig.fs.service.generate.flights;

import static org.junit.Assert.*;

import java.time.LocalTime;
import java.util.List;

import org.junit.Test;

import com.crimsonpig.fs.domain.flightplan.Leg;
import com.crimsonpig.fs.domain.route.FlightPlanRouteDefinition;

public class SacramentoToDenverTest extends BaseGenerateFlightTest {

	@Override
	protected FlightPlanRouteDefinition getRouteDefinition() {
		FlightPlanRouteDefinition smfToDen = new FlightPlanRouteDefinition();
		smfToDen.setAircraftNumber(1);
		smfToDen.setAircraftTitle("Boeing 737-400 Paint1");
		smfToDen.setAirline("American Pacific");
		smfToDen.setGroundspeed(430);
		smfToDen.setOriginAirport("KSMF");
		smfToDen.setOriginTimezone(-7);
		smfToDen.setDestinationAirport("KDEN");
		smfToDen.setFlightFrequency(8);
		return smfToDen;
	}

	@Test
	public void firstFlightPlanLegsTest(){
		List<Leg> legs = getFlightPlans().get(0).getLegs();
		
		Leg firstLeg = legs.get(0);
		Leg secondLeg = legs.get(1);
		assertEquals(788, firstLeg.getDistance(), 0.5);
		assertEquals(788, secondLeg.getDistance(), 0.5);
		assertEquals(80, firstLeg.getHeading(), 0.5);
		assertEquals(270, secondLeg.getHeading(), 0.5);
		
		assertLeg(firstLeg, LocalTime.of(13, 0, 0), LocalTime.of(15, 4, 54));
		assertEquals(370, firstLeg.getFlightLevel());
		assertLeg(secondLeg, LocalTime.of(16, 4, 54), LocalTime.of(18, 9, 48));
		assertEquals(380, secondLeg.getFlightLevel());
	}

	@Test
	public void flightPlansTest() {
		assertEquals(2, getFlightPlans().size());
	}

	@Test
	public void repetitionTest() {
		getFlightPlans().forEach(flightPlan -> assertEquals("6Hr", flightPlan.getRepetition()));
	}

}
