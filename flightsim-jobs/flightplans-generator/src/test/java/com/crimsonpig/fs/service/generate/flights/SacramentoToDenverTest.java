package com.crimsonpig.fs.service.generate.flights;

import static org.junit.Assert.*;

import java.time.LocalTime;
import java.util.List;

import org.junit.Test;

import com.crimsonpig.fs.domain.flightplan.Leg;
import com.crimsonpig.fs.domain.route.FlightPlanRouteDefinition;
import com.crimsonpig.fs.domain.flightplan.Repetition;

public class SacramentoToDenverTest extends BaseGenerateFlightTest {

	@Override
	protected FlightPlanRouteDefinition getRouteDefinition() {
		FlightPlanRouteDefinition smfToDen = new FlightPlanRouteDefinition();
		smfToDen.setAircraftNumber(1);
		smfToDen.setAircraftTitle("Boeing 737-400 Paint1");
		smfToDen.setAirline("American Pacific");
		smfToDen.setGroundspeed(430);
		smfToDen.setOriginAirport("KSMF");
		smfToDen.setOutboundFlightLevel(370);
		smfToDen.setOriginTimezone(-7);
		smfToDen.setDestinationAirport("KDEN");
		smfToDen.setReturnFlightLevel(380);
		smfToDen.setFlightFrequency(8);
		smfToDen.setDistance(788);
		smfToDen.setRouteTime(7500);
		return smfToDen;
	}

	@Test
	public void firstFlightPlanLegsTest(){
		List<Leg> legs = getFlightPlans().get(0).getLegs();
		
		Leg firstLeg = legs.get(0);
		Leg secondLeg = legs.get(1);

		assertEquals(370, firstLeg.getFlightLevel());
		assertEquals(380, secondLeg.getFlightLevel());
		
		assertLeg(firstLeg, LocalTime.of(13, 0, 0), LocalTime.of(15, 5, 0));
		assertLeg(secondLeg, LocalTime.of(16, 5, 0), LocalTime.of(18, 10, 0));
	}

	@Test
	public void flightPlansTest() {
		assertEquals(2, getFlightPlans().size());
	}

	@Test
	public void repetitionTest() {
		getFlightPlans().forEach(flightPlan -> assertEquals(Repetition.SIX_HOURS, flightPlan.getRepetition()));
	}

}
