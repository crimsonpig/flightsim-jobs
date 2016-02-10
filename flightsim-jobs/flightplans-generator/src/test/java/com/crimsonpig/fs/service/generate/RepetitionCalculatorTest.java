package com.crimsonpig.fs.service.generate;

import static org.junit.Assert.*;

import org.junit.Test;

import com.crimsonpig.fs.domain.flightplan.Repetition;

public class RepetitionCalculatorTest {

	@Test
	public void calculateFourHourRepetitionTest(){
		int groundspeed = 430;
		double distance = 324.0;
		
		RouteTime time = new RouteTime(groundspeed, distance);
		long singleRepetitionSeconds = time.getSingleRepetitionSeconds();
		
		RepetitionBuilder repetitionBuilder = new RepetitionBuilder();
		assertEquals(Repetition.FOUR_HOURS, repetitionBuilder.buildFromSeconds(singleRepetitionSeconds));
	}
	
	@Test
	public void calculateSixHourRepetitionTest(){
		int groundspeed = 430;
		double distance = 526.0;
		
		RouteTime time = new RouteTime(groundspeed, distance);
		long singleRepetitionSeconds = time.getSingleRepetitionSeconds();
		
		RepetitionBuilder repetitionBuilder = new RepetitionBuilder();
		assertEquals(Repetition.SIX_HOURS, repetitionBuilder.buildFromSeconds(singleRepetitionSeconds));
	}
	
	@Test
	public void calculateEightHourRepetitionTest(){
		int groundspeed = 430;
		double distance = 788.0;
		
		RouteTime time = new RouteTime(groundspeed, distance);
		long singleRepetitionSeconds = time.getSingleRepetitionSeconds();
		
		RepetitionBuilder repetitionBuilder = new RepetitionBuilder();
		assertEquals(Repetition.EIGHT_HOURS, repetitionBuilder.buildFromSeconds(singleRepetitionSeconds));
	}
	
	@Test
	public void calculateTwelveHourRepetitionTest(){
		int groundspeed = 480;
		double distance = 2242.0;
		
		RouteTime time = new RouteTime(groundspeed, distance);
		long singleRepetitionSeconds = time.getSingleRepetitionSeconds();
		
		RepetitionBuilder repetitionBuilder = new RepetitionBuilder();
		assertEquals(Repetition.TWELVE_HOURS, repetitionBuilder.buildFromSeconds(singleRepetitionSeconds));		
	}
	
	@Test
	public void calculateTwentyFourHourRepetitionTest(){
		int groundspeed = 430;
		double distance = 2242.0;
		
		RouteTime time = new RouteTime(groundspeed, distance);
		long singleRepetitionSeconds = time.getSingleRepetitionSeconds();
		
		RepetitionBuilder repetitionBuilder = new RepetitionBuilder();
		assertEquals(Repetition.TWENTY_FOUR_HOURS, repetitionBuilder.buildFromSeconds(singleRepetitionSeconds));		
	}
}
