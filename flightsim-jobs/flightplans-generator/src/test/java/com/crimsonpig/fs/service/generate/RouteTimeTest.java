package com.crimsonpig.fs.service.generate;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RouteTimeTest {

	@Test
	public void routeLegSecondsTest(){
		int groundspeed = 430;
		double distance = 788.0;
		
		RouteTime time = new RouteTime(groundspeed, distance);

		assertEquals(7500, time.getRouteLegSeconds(), 4);
	}
	
	
	@Test
	public void anotherRouteLegSecondsTest(){
		int groundspeed = 430;
		double distance = 2242.0;
		
		RouteTime time = new RouteTime(groundspeed, distance);

		assertEquals(19680, time.getRouteLegSeconds(), 4);
	}
	
	@Test
	public void minimumLegSecondsTest(){
		int groundspeed = 430;
		double distance = 788.0;
		
		RouteTime time = new RouteTime(groundspeed, distance);
		
		assertEquals(11100, time.getMinimumLegSeconds(), 4);
	}
	
	@Test
	public void anotherMinimumLegSecondsTest(){
		int groundspeed = 430;
		double distance = 2242.0;
		
		RouteTime time = new RouteTime(groundspeed, distance);
		
		assertEquals(23280, time.getMinimumLegSeconds(), 4);
	}
	
	@Test
	public void singleRepetitionSecondsTest(){
		int groundspeed = 430;
		double distance = 788.0;
		
		RouteTime time = new RouteTime(groundspeed, distance);
		
		assertEquals(22200, time.getSingleRepetitionSeconds(), 4);		
	}
	
	
	@Test
	public void anotherSingleRepetitionSeconds(){
		int groundspeed = 430;
		double distance = 2242.0;
		
		RouteTime time = new RouteTime(groundspeed, distance);
		
		assertEquals(46560, time.getSingleRepetitionSeconds(), 8);		
	}
}
