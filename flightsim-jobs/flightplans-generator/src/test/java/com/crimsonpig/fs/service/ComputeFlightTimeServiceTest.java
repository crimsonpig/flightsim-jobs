package com.crimsonpig.fs.service;

import static org.junit.Assert.*;

import org.junit.Test;

public class ComputeFlightTimeServiceTest {

	@Test
	public void ontPhxTest(){
		int groundspeed = 430;
		double distance = 282.1;
		ComputeFlightTimeService service = new ComputeFlightTimeService(distance, groundspeed);
		long seconds = service.getFlightTimeInSeconds();
		double minutes = seconds / 60.0;
		assertEquals(54.0, minutes, 0.5);
	}
	
	@Test
	public void smfPhxTest(){
		int groundspeed = 430;
		double distance = 561;
		ComputeFlightTimeService service = new ComputeFlightTimeService(distance, groundspeed);
		long seconds = service.getFlightTimeInSeconds();
		double minutes = seconds / 60.0;
		assertEquals(93, minutes, 0.5);
	}
}
