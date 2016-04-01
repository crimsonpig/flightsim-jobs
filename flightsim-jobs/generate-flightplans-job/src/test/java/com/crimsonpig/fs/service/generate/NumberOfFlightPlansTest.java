package com.crimsonpig.fs.service.generate;

import static org.junit.Assert.*;

import org.junit.Test;

import com.crimsonpig.fs.domain.flightplan.Repetition;

public class NumberOfFlightPlansTest {

	@Test
	public void singleFourHourFlightPlanTest(){

		int flightFrequency = 6;

		FlightPlanBuilder flightPlanBuilder = new FlightPlanBuilder();
		int numberOfFlightPlans = flightPlanBuilder.getNumberOfFlightPlans(flightFrequency, Repetition.FOUR_HOURS);
		assertEquals(1, numberOfFlightPlans);
	}
	

	@Test
	public void doubleFourHourFlightPlanTest(){

		int flightFrequency = 11;

		FlightPlanBuilder flightPlanBuilder = new FlightPlanBuilder();
		int numberOfFlightPlans = flightPlanBuilder.getNumberOfFlightPlans(flightFrequency, Repetition.FOUR_HOURS);
		assertEquals(2, numberOfFlightPlans);
	}	
	

	@Test
	public void tripleFourHourFlightPlanTest(){

		int flightFrequency = 14;
		
		FlightPlanBuilder flightPlanBuilder = new FlightPlanBuilder();
		int numberOfFlightPlans = flightPlanBuilder.getNumberOfFlightPlans(flightFrequency, Repetition.FOUR_HOURS);
		assertEquals(3, numberOfFlightPlans);
	}	
	
	
	@Test
	public void singleSixHourFlightPlanTest(){

		int flightFrequency = 4;

		FlightPlanBuilder flightPlanBuilder = new FlightPlanBuilder();
		int numberOfFlightPlans = flightPlanBuilder.getNumberOfFlightPlans(flightFrequency, Repetition.SIX_HOURS);
		assertEquals(1, numberOfFlightPlans);
	}	
	
	
	@Test
	public void doubleSixHourFlightPlanTest(){

		int flightFrequency = 8;

		FlightPlanBuilder flightPlanBuilder = new FlightPlanBuilder();
		int numberOfFlightPlans = flightPlanBuilder.getNumberOfFlightPlans(flightFrequency, Repetition.SIX_HOURS);
		assertEquals(2, numberOfFlightPlans);
	}		
	
	@Test
	public void quadrupleSixHourFlightPlanTest(){
		int flightFrequency = 15;
		
		FlightPlanBuilder flightPlanBuilder = new FlightPlanBuilder();
		int numberOfFlightPlans = flightPlanBuilder.getNumberOfFlightPlans(flightFrequency, Repetition.SIX_HOURS);
		assertEquals(4, numberOfFlightPlans);
	}	
	
	@Test
	public void singleEightHourFlightPlanTest(){

		int flightFrequency = 3;

		FlightPlanBuilder flightPlanBuilder = new FlightPlanBuilder();
		int numberOfFlightPlans = flightPlanBuilder.getNumberOfFlightPlans(flightFrequency, Repetition.EIGHT_HOURS);
		assertEquals(1, numberOfFlightPlans);
	}		
	
	@Test
	public void tripleEightHourFlightPlanTest(){

		int flightFrequency = 8;

		FlightPlanBuilder flightPlanBuilder = new FlightPlanBuilder();
		int numberOfFlightPlans = flightPlanBuilder.getNumberOfFlightPlans(flightFrequency, Repetition.EIGHT_HOURS);
		assertEquals(3, numberOfFlightPlans);
	}			
	
	@Test
	public void singleTwelveHourFlightPlanTest(){

		int flightFrequency = 2;
		
		FlightPlanBuilder flightPlanBuilder = new FlightPlanBuilder();
		int numberOfFlightPlans = flightPlanBuilder.getNumberOfFlightPlans(flightFrequency, Repetition.TWELVE_HOURS);
		assertEquals(1, numberOfFlightPlans);
	}	
	
	@Test
	public void quadrupleTwelveHourFlightPlanTest(){

		int flightFrequency = 8;

		FlightPlanBuilder flightPlanBuilder = new FlightPlanBuilder();
		int numberOfFlightPlans = flightPlanBuilder.getNumberOfFlightPlans(flightFrequency, Repetition.TWELVE_HOURS);
		assertEquals(4, numberOfFlightPlans);
	}	
	
	@Test
	public void quintupleTwelveHourFlightPlanTest(){

		int flightFrequency = 10;

		FlightPlanBuilder flightPlanBuilder = new FlightPlanBuilder();
		int numberOfFlightPlans = flightPlanBuilder.getNumberOfFlightPlans(flightFrequency, Repetition.TWELVE_HOURS);
		assertEquals(5, numberOfFlightPlans);
	}		
	
	@Test
	public void singleOneDayFlightPlanTest(){

		int flightFrequency = 1;
		
		FlightPlanBuilder flightPlanBuilder = new FlightPlanBuilder();
		int numberOfFlightPlans = flightPlanBuilder.getNumberOfFlightPlans(flightFrequency, Repetition.TWENTY_FOUR_HOURS);
		assertEquals(1, numberOfFlightPlans);
	}	
	
	@Test
	public void doubleOneDayFlightPlanTest(){

		int flightFrequency = 2;

		FlightPlanBuilder flightPlanBuilder = new FlightPlanBuilder();
		int numberOfFlightPlans = flightPlanBuilder.getNumberOfFlightPlans(flightFrequency, Repetition.TWENTY_FOUR_HOURS);
		assertEquals(2, numberOfFlightPlans);
	}		
}
