package com.crimsonpig.fs.service.generate;

import static org.junit.Assert.*;

import org.junit.Test;

public class NumberOfFlightPlansTest {

	@Test
	public void singleFourHourFlightPlanTest(){
		int groundspeed = 430;
		double distance = 324.0;
		int flightFrequency = 6;
		
		RouteTime time = new RouteTime(groundspeed, distance);

		FlightPlanBuilder flightPlanBuilder = new FlightPlanBuilder();
		int numberOfFlightPlans = flightPlanBuilder.getNumberOfFlightPlans(flightFrequency, time);
		assertEquals(1, numberOfFlightPlans);
	}
	

	@Test
	public void doubleFourHourFlightPlanTest(){
		int groundspeed = 430;
		double distance = 324.0;
		int flightFrequency = 11;
		
		RouteTime time = new RouteTime(groundspeed, distance);

		FlightPlanBuilder flightPlanBuilder = new FlightPlanBuilder();
		int numberOfFlightPlans = flightPlanBuilder.getNumberOfFlightPlans(flightFrequency, time);
		assertEquals(2, numberOfFlightPlans);
	}	
	

	@Test
	public void tripleFourHourFlightPlanTest(){
		int groundspeed = 430;
		double distance = 324.0;
		int flightFrequency = 14;
		
		RouteTime time = new RouteTime(groundspeed, distance);

		FlightPlanBuilder flightPlanBuilder = new FlightPlanBuilder();
		int numberOfFlightPlans = flightPlanBuilder.getNumberOfFlightPlans(flightFrequency, time);
		assertEquals(3, numberOfFlightPlans);
	}	
	
	
	@Test
	public void singleSixHourFlightPlanTest(){
		int groundspeed = 430;
		double distance = 526.0;
		int flightFrequency = 4;
		
		RouteTime time = new RouteTime(groundspeed, distance);

		FlightPlanBuilder flightPlanBuilder = new FlightPlanBuilder();
		int numberOfFlightPlans = flightPlanBuilder.getNumberOfFlightPlans(flightFrequency, time);
		assertEquals(1, numberOfFlightPlans);
	}	
	
	
	@Test
	public void doubleSixHourFlightPlanTest(){
		int groundspeed = 430;
		double distance = 526.0;
		int flightFrequency = 8;
		
		RouteTime time = new RouteTime(groundspeed, distance);

		FlightPlanBuilder flightPlanBuilder = new FlightPlanBuilder();
		int numberOfFlightPlans = flightPlanBuilder.getNumberOfFlightPlans(flightFrequency, time);
		assertEquals(2, numberOfFlightPlans);
	}		
	
	@Test
	public void quadrupleSixHourFlightPlanTest(){
		int groundspeed = 430;
		double distance = 526.0;
		int flightFrequency = 15;
		
		RouteTime time = new RouteTime(groundspeed, distance);

		FlightPlanBuilder flightPlanBuilder = new FlightPlanBuilder();
		int numberOfFlightPlans = flightPlanBuilder.getNumberOfFlightPlans(flightFrequency, time);
		assertEquals(4, numberOfFlightPlans);
	}	
	
	@Test
	public void singleEightHourFlightPlanTest(){
		int groundspeed = 430;
		double distance = 788.0;
		int flightFrequency = 3;
		
		RouteTime time = new RouteTime(groundspeed, distance);

		FlightPlanBuilder flightPlanBuilder = new FlightPlanBuilder();
		int numberOfFlightPlans = flightPlanBuilder.getNumberOfFlightPlans(flightFrequency, time);
		assertEquals(1, numberOfFlightPlans);
	}		
	
	@Test
	public void tripleEightHourFlightPlanTest(){
		int groundspeed = 430;
		double distance = 788.0;
		int flightFrequency = 8;
		
		RouteTime time = new RouteTime(groundspeed, distance);

		FlightPlanBuilder flightPlanBuilder = new FlightPlanBuilder();
		int numberOfFlightPlans = flightPlanBuilder.getNumberOfFlightPlans(flightFrequency, time);
		assertEquals(3, numberOfFlightPlans);
	}			
	
	@Test
	public void singleTwelveHourFlightPlanTest(){
		int groundspeed = 480;
		double distance = 2242.0;
		int flightFrequency = 2;
		
		RouteTime time = new RouteTime(groundspeed, distance);

		FlightPlanBuilder flightPlanBuilder = new FlightPlanBuilder();
		int numberOfFlightPlans = flightPlanBuilder.getNumberOfFlightPlans(flightFrequency, time);
		assertEquals(1, numberOfFlightPlans);
	}	
	
	@Test
	public void quadrupleTwelveHourFlightPlanTest(){
		int groundspeed = 480;
		double distance = 2242.0;
		int flightFrequency = 8;
		
		RouteTime time = new RouteTime(groundspeed, distance);

		FlightPlanBuilder flightPlanBuilder = new FlightPlanBuilder();
		int numberOfFlightPlans = flightPlanBuilder.getNumberOfFlightPlans(flightFrequency, time);
		assertEquals(4, numberOfFlightPlans);
	}	
	
	@Test
	public void quintupleTwelveHourFlightPlanTest(){
		int groundspeed = 480;
		double distance = 2242.0;
		int flightFrequency = 10;
		
		RouteTime time = new RouteTime(groundspeed, distance);

		FlightPlanBuilder flightPlanBuilder = new FlightPlanBuilder();
		int numberOfFlightPlans = flightPlanBuilder.getNumberOfFlightPlans(flightFrequency, time);
		assertEquals(5, numberOfFlightPlans);
	}		
	
	@Test
	public void singleOneDayFlightPlanTest(){
		int groundspeed = 430;
		double distance = 2242.0;
		int flightFrequency = 1;
		
		RouteTime time = new RouteTime(groundspeed, distance);

		FlightPlanBuilder flightPlanBuilder = new FlightPlanBuilder();
		int numberOfFlightPlans = flightPlanBuilder.getNumberOfFlightPlans(flightFrequency, time);
		assertEquals(1, numberOfFlightPlans);
	}	
	
	@Test
	public void doubleOneDayFlightPlanTest(){
		int groundspeed = 430;
		double distance = 2242.0;
		int flightFrequency = 2;
		
		RouteTime time = new RouteTime(groundspeed, distance);

		FlightPlanBuilder flightPlanBuilder = new FlightPlanBuilder();
		int numberOfFlightPlans = flightPlanBuilder.getNumberOfFlightPlans(flightFrequency, time);
		assertEquals(2, numberOfFlightPlans);
	}		
}
