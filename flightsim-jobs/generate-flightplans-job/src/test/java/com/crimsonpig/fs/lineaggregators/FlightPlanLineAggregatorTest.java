package com.crimsonpig.fs.lineaggregators;

import static org.junit.Assert.assertEquals;

import java.time.LocalTime;

import org.junit.Before;
import org.junit.Test;

import com.crimsonpig.fs.domain.flightplan.CallBy;
import com.crimsonpig.fs.domain.flightplan.FlightPlan;
import com.crimsonpig.fs.domain.flightplan.FlightRules;
import com.crimsonpig.fs.domain.flightplan.Leg;
import com.crimsonpig.fs.domain.flightplan.Repetition;

public class FlightPlanLineAggregatorTest {
	
	
	private FlightPlanLineAggregator aggregator;
	
	@Before
	public void setUp(){
		aggregator = new FlightPlanLineAggregator();
	}
	
	@Test
	public void testLineAggregation(){
		
		String expected = "AC#5,N29782,82%,6Hr,IFR,13:35,14:47:07,370,F,1781,KSMF,15:47:07,16:59:14,380,F,1782,KPDX";
		
		Leg leg1 = new Leg();
		leg1.setDepartureAirport("KPDX");
		leg1.setArrivalAirport("KSMF");
		leg1.setDepartureTime(LocalTime.of(13, 35, 0));
		leg1.setArrivalTime(LocalTime.of(14, 47, 7));
		leg1.setFlightLevel(370);
		leg1.setfOrR(CallBy.F);
		leg1.setFlightNumber(1781);
		
		Leg leg2 = new Leg();
		leg2.setDepartureAirport("KSMF");
		leg2.setArrivalAirport("KPDX");
		leg2.setDepartureTime(LocalTime.of(15, 47, 7));
		leg2.setArrivalTime(LocalTime.of(16, 59, 14));
		leg2.setFlightLevel(380);
		leg2.setfOrR(CallBy.F);
		leg2.setFlightNumber(1782);
		
		FlightPlan fp = new FlightPlan();
		fp.setAircraftNumber(5);
		fp.setRegistration("N29782");
		fp.setPercentage(82);
		fp.setRepetition(Repetition.SIX_HOURS);
		fp.setFlightRules(FlightRules.IFR);
		fp.getLegs().add(leg1);
		fp.getLegs().add(leg2);
		
		String fpLine = aggregator.aggregate(fp);
		assertEquals(expected, fpLine);
	}

}
