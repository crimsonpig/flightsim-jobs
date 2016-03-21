package com.crimsonpig.fs.service.generate.flights;

import static org.junit.Assert.*;

import java.time.LocalTime;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.crimsonpig.fs.domain.flightplan.FlightPlan;
import com.crimsonpig.fs.domain.flightplan.FlightRules;
import com.crimsonpig.fs.domain.flightplan.Leg;
import com.crimsonpig.fs.domain.route.FlightPlanRouteDefinition;
import com.crimsonpig.fs.service.GenerateFlightPlanService;

public abstract class BaseGenerateFlightTest {

	private List<FlightPlan> flightPlans;
	
	protected abstract FlightPlanRouteDefinition getRouteDefinition();	
	public abstract void flightPlansTest();
	public abstract void repetitionTest();

	protected List<FlightPlan> getFlightPlans(){
		return flightPlans;
	}
	
	protected final void assertOriginToDestinationLeg(Leg leg){
		assertEquals(getRouteDefinition().getOriginAirport(), leg.getDepartureAirport());
		assertEquals(getRouteDefinition().getDestinationAirport(), leg.getArrivalAirport());
	}
	
	protected final void assertDestinationToOriginLeg(Leg leg){
		assertEquals(getRouteDefinition().getDestinationAirport(), leg.getDepartureAirport());
		assertEquals(getRouteDefinition().getOriginAirport(), leg.getArrivalAirport());
	}

	private final void assertFOrR(Leg leg){
		assertEquals("F", leg.getfOrR().toString());
	}
	
	protected final void assertLeg(Leg leg, LocalTime departureTime, LocalTime arrivalTime){
		assertFOrR(leg);
		assertEquals(departureTime, leg.getDepartureTime());
		assertEquals(arrivalTime, leg.getArrivalTime());		
	}
	
	@Before
	public final void generateFlightPlan(){
		GenerateFlightPlanService service = new GenerateFlightPlanService();
		FlightPlanRouteDefinition smfToEug = getRouteDefinition();
		flightPlans = service.buildFlightPlans(smfToEug);
	}
	
	@Test
	public final void firstAndSecondLegTest(){
		assertNotNull(getFlightPlans());
		assertTrue(getFlightPlans().size() > 0);
		for(FlightPlan flightPlan : getFlightPlans()){
			assertEquals(2, flightPlan.getLegs().size());
			Leg firstLeg = flightPlan.getLegs().get(0);
			Leg secondLeg = flightPlan.getLegs().get(1);
			
			assertEquals(firstLeg.getDepartureAirport(), secondLeg.getArrivalAirport());
			assertEquals(firstLeg.getArrivalAirport(), secondLeg.getDepartureAirport());			
		}
	}
	
	@Test
	public final void assertPercentage(){
		assertNotNull(getFlightPlans());
		assertTrue(getFlightPlans().size() > 0);
		for(FlightPlan flightPlan : getFlightPlans()){
			int percentage = flightPlan.getPercentage();
			assertTrue(100 > percentage);
			assertTrue(1 < percentage);
		}
	}
	
	@Test
	public final void assertRegistration(){
		assertNotNull(getFlightPlans());
		assertTrue(getFlightPlans().size() > 0);
		for(FlightPlan flightPlan : getFlightPlans()){
			String registration = flightPlan.getRegistration();
			assertEquals("N", registration.substring(0,1));
			assertEquals(6, registration.length());
		}
	}
	
	@Test
	public final void flightPlanHeaderTest(){
		assertNotNull(getFlightPlans());
		assertTrue(getFlightPlans().size() > 0);
		for(FlightPlan flightPlan : getFlightPlans()){
			assertEquals(getRouteDefinition().getAircraftNumber(), flightPlan.getAircraftNumber());
			assertEquals(getRouteDefinition().getAircraftTitle(), flightPlan.getAircraftTitle());
			assertEquals(getRouteDefinition().getAirline(), flightPlan.getAirline());
			assertEquals(FlightRules.IFR, flightPlan.getFlightRules());
		}
	}

}
