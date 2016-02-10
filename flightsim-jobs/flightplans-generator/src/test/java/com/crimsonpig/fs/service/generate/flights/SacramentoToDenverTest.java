package com.crimsonpig.fs.service.generate.flights;

import static org.junit.Assert.*;

import java.time.LocalTime;
import java.util.List;

import org.junit.Test;

import com.crimsonpig.fs.domain.flightplan.Leg;
import com.crimsonpig.fs.domain.route.FullRouteDefinition;

public class SacramentoToDenverTest extends BaseGenerateFlightTest {

	@Override
	protected FullRouteDefinition getRouteDefinition() {
		FullRouteDefinition smfToDen = new FullRouteDefinition();
		smfToDen.setAircraftNumber(1);
		smfToDen.setAircraftTitle("Boeing 737-400 Paint1");
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
