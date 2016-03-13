package com.crimsonpig.fs.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RouteTimesServiceTest {

	
	@Test
	public void routeTimesTest(){
		
		double distance = 788;
		int groundspeed = 430;
		
		RouteTimesService routeTimesService = new RouteTimesService();
		long routeTime = routeTimesService.calculateRouteTime(distance, groundspeed);
		

		assertEquals(7500, routeTime);

		
	}
	
}
