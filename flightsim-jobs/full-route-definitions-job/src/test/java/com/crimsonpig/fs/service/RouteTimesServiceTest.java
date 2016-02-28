package com.crimsonpig.fs.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.crimsonpig.fs.domain.route.RouteTimes;

public class RouteTimesServiceTest {

	
	@Test
	public void routeTimesTest(){
		
		double distance = 788;
		int groundspeed = 430;
		
		RouteTimesService routeTimesService = new RouteTimesService();
		RouteTimes routeTimes = routeTimesService.calculateRouteTimes(distance, groundspeed);
		
		assertEquals(3600, routeTimes.getHoldTime());
		assertEquals(7500, routeTimes.getRouteLegSeconds());
		assertEquals(11100, routeTimes.getMinimumLegSeconds());
		assertEquals(22200, routeTimes.getSingleRepetitionSeconds());
		
	}
	
}
