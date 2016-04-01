package com.crimsonpig.fs.service.generate;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RouteTimeTest {

	private final static long ONE_HOUR_HOLD_TIME = 3600;
	
	@Test
	public void routeLegSecondsTest(){
		
		long routeTime = 7500;
		
		RouteTime time = new RouteTime(routeTime, ONE_HOUR_HOLD_TIME);

		assertEquals(7500, time.getRouteLegSeconds(), 4);
	}
	
	
	@Test
	public void anotherRouteLegSecondsTest(){
		long routeTime = 19677;
		
		RouteTime time = new RouteTime(routeTime, ONE_HOUR_HOLD_TIME);

		assertEquals(19680, time.getRouteLegSeconds(), 4);
	}
	
	@Test
	public void minimumLegSecondsTest(){
		long routeTime = 7500;
		
		RouteTime time = new RouteTime(routeTime, ONE_HOUR_HOLD_TIME);
		
		assertEquals(11100, time.getMinimumLegSeconds(), 4);
	}
	
	@Test
	public void anotherMinimumLegSecondsTest(){
		long routeTime = 19677;
		RouteTime time = new RouteTime(routeTime, ONE_HOUR_HOLD_TIME);
		
		assertEquals(23280, time.getMinimumLegSeconds(), 4);
	}
	
	@Test
	public void singleRepetitionSecondsTest(){
		long routeTime = 7500;
		
		RouteTime time = new RouteTime(routeTime, ONE_HOUR_HOLD_TIME);
		
		assertEquals(22200, time.getSingleRepetitionSeconds(), 4);		
	}
	
	
	@Test
	public void anotherSingleRepetitionSeconds(){
		long routeTime = 19677;
		RouteTime time = new RouteTime(routeTime, ONE_HOUR_HOLD_TIME);
		
		assertEquals(46560, time.getSingleRepetitionSeconds(), 8);		
	}
}
