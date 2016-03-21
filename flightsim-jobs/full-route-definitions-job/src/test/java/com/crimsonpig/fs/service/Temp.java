package com.crimsonpig.fs.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Temp {

	
	@Test
	public void routeTimesTest(){
		
		
		int groundspeed = 480;
		double distance = 1639;
		
		RouteTimesService routeTimesService = new RouteTimesService();
		long routeTime = routeTimesService.calculateRouteTime(distance, groundspeed);
		
		System.out.println(routeTime);
		
	}
	
}
