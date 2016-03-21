package com.crimsonpig.fs.service.generate;

import static org.junit.Assert.*;

import org.junit.Test;

public class NumberOfFlightPlansTest {

	private final static long ONE_HOUR_HOLD_TIME = 3600;
	
	@Test
	public void singleFourHourFlightPlanTest(){
		
		long routeTime = 3614;
		int flightFrequency = 6;
		
		RouteTime time = new RouteTime(routeTime, ONE_HOUR_HOLD_TIME);

		FlightPlanBuilder flightPlanBuilder = new FlightPlanBuilder();
		int numberOfFlightPlans = flightPlanBuilder.getNumberOfFlightPlans(flightFrequency, time);
		assertEquals(1, numberOfFlightPlans);
	}
	

	@Test
	public void doubleFourHourFlightPlanTest(){

		long routeTime = 3614;
		int flightFrequency = 11;
		
		RouteTime time = new RouteTime(routeTime, ONE_HOUR_HOLD_TIME);

		FlightPlanBuilder flightPlanBuilder = new FlightPlanBuilder();
		int numberOfFlightPlans = flightPlanBuilder.getNumberOfFlightPlans(flightFrequency, time);
		assertEquals(2, numberOfFlightPlans);
	}	
	

	@Test
	public void tripleFourHourFlightPlanTest(){
		
		long routeTime = 3614;
		int flightFrequency = 14;
		
		RouteTime time = new RouteTime(routeTime, ONE_HOUR_HOLD_TIME);

		FlightPlanBuilder flightPlanBuilder = new FlightPlanBuilder();
		int numberOfFlightPlans = flightPlanBuilder.getNumberOfFlightPlans(flightFrequency, time);
		assertEquals(3, numberOfFlightPlans);
	}	
	
	
	@Test
	public void singleSixHourFlightPlanTest(){
		
		long routeTime = 5305;
		int flightFrequency = 4;
		
		RouteTime time = new RouteTime(routeTime, ONE_HOUR_HOLD_TIME);

		FlightPlanBuilder flightPlanBuilder = new FlightPlanBuilder();
		int numberOfFlightPlans = flightPlanBuilder.getNumberOfFlightPlans(flightFrequency, time);
		assertEquals(1, numberOfFlightPlans);
	}	
	
	
	@Test
	public void doubleSixHourFlightPlanTest(){
		long routeTime = 5305;
		int flightFrequency = 8;
		
		RouteTime time = new RouteTime(routeTime, ONE_HOUR_HOLD_TIME);

		FlightPlanBuilder flightPlanBuilder = new FlightPlanBuilder();
		int numberOfFlightPlans = flightPlanBuilder.getNumberOfFlightPlans(flightFrequency, time);
		assertEquals(2, numberOfFlightPlans);
	}		
	
	@Test
	public void quadrupleSixHourFlightPlanTest(){
		long routeTime = 5305;
		int flightFrequency = 15;
		
		RouteTime time = new RouteTime(routeTime, ONE_HOUR_HOLD_TIME);

		FlightPlanBuilder flightPlanBuilder = new FlightPlanBuilder();
		int numberOfFlightPlans = flightPlanBuilder.getNumberOfFlightPlans(flightFrequency, time);
		assertEquals(4, numberOfFlightPlans);
	}	
	
	@Test
	public void singleEightHourFlightPlanTest(){
		long routeTime = 7500;
		int flightFrequency = 3;
		
		RouteTime time = new RouteTime(routeTime, ONE_HOUR_HOLD_TIME);

		FlightPlanBuilder flightPlanBuilder = new FlightPlanBuilder();
		int numberOfFlightPlans = flightPlanBuilder.getNumberOfFlightPlans(flightFrequency, time);
		assertEquals(1, numberOfFlightPlans);
	}		
	
	@Test
	public void tripleEightHourFlightPlanTest(){
		long routeTime = 7500;
		int flightFrequency = 8;
		
		RouteTime time = new RouteTime(routeTime, ONE_HOUR_HOLD_TIME);

		FlightPlanBuilder flightPlanBuilder = new FlightPlanBuilder();
		int numberOfFlightPlans = flightPlanBuilder.getNumberOfFlightPlans(flightFrequency, time);
		assertEquals(3, numberOfFlightPlans);
	}			
	
	@Test
	public void singleTwelveHourFlightPlanTest(){
		long routeTime = 17719;
		int flightFrequency = 2;
		
		RouteTime time = new RouteTime(routeTime, ONE_HOUR_HOLD_TIME);

		FlightPlanBuilder flightPlanBuilder = new FlightPlanBuilder();
		int numberOfFlightPlans = flightPlanBuilder.getNumberOfFlightPlans(flightFrequency, time);
		assertEquals(1, numberOfFlightPlans);
	}	
	
	@Test
	public void quadrupleTwelveHourFlightPlanTest(){
		long routeTime = 17719;
		int flightFrequency = 8;
		
		RouteTime time = new RouteTime(routeTime, ONE_HOUR_HOLD_TIME);

		FlightPlanBuilder flightPlanBuilder = new FlightPlanBuilder();
		int numberOfFlightPlans = flightPlanBuilder.getNumberOfFlightPlans(flightFrequency, time);
		assertEquals(4, numberOfFlightPlans);
	}	
	
	@Test
	public void quintupleTwelveHourFlightPlanTest(){
		long routeTime = 17719;
		int flightFrequency = 10;
		
		RouteTime time = new RouteTime(routeTime, ONE_HOUR_HOLD_TIME);

		FlightPlanBuilder flightPlanBuilder = new FlightPlanBuilder();
		int numberOfFlightPlans = flightPlanBuilder.getNumberOfFlightPlans(flightFrequency, time);
		assertEquals(5, numberOfFlightPlans);
	}		
	
	@Test
	public void singleOneDayFlightPlanTest(){
		long routeTime = 19677;
		int flightFrequency = 1;
		
		RouteTime time = new RouteTime(routeTime, ONE_HOUR_HOLD_TIME);

		FlightPlanBuilder flightPlanBuilder = new FlightPlanBuilder();
		int numberOfFlightPlans = flightPlanBuilder.getNumberOfFlightPlans(flightFrequency, time);
		assertEquals(1, numberOfFlightPlans);
	}	
	
	@Test
	public void doubleOneDayFlightPlanTest(){
		long routeTime = 19677;
		int flightFrequency = 2;
		
		RouteTime time = new RouteTime(routeTime, ONE_HOUR_HOLD_TIME);

		FlightPlanBuilder flightPlanBuilder = new FlightPlanBuilder();
		int numberOfFlightPlans = flightPlanBuilder.getNumberOfFlightPlans(flightFrequency, time);
		assertEquals(2, numberOfFlightPlans);
	}		
}
