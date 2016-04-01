package com.crimsonpig.fs.service.generate;

import static org.junit.Assert.*;

import org.junit.Test;

import com.crimsonpig.fs.domain.flightplan.Repetition;

public class RepetitionCalculatorTest {

	private final static long ONE_HOUR_HOLD_TIME = 3600;
	
	@Test
	public void calculateFourHourRepetitionTest(){
		long routeTime = 3614;
		
		RouteTime time = new RouteTime(routeTime, ONE_HOUR_HOLD_TIME);
		long singleRepetitionSeconds = time.getSingleRepetitionSeconds();
		
		RepetitionBuilder repetitionBuilder = new RepetitionBuilder();
		assertEquals(Repetition.FOUR_HOURS, repetitionBuilder.buildFromSeconds(singleRepetitionSeconds));
	}
	
	@Test
	public void calculateSixHourRepetitionTest(){
		long routeTime = 5305;
		
		RouteTime time = new RouteTime(routeTime, ONE_HOUR_HOLD_TIME);
		long singleRepetitionSeconds = time.getSingleRepetitionSeconds();
		
		RepetitionBuilder repetitionBuilder = new RepetitionBuilder();
		assertEquals(Repetition.SIX_HOURS, repetitionBuilder.buildFromSeconds(singleRepetitionSeconds));
	}
	
	@Test
	public void calculateAnotherSixHourRepetitionTest(){
		long routeTime = 7500;
		
		RouteTime time = new RouteTime(routeTime, ONE_HOUR_HOLD_TIME);
		long singleRepetitionSeconds = time.getSingleRepetitionSeconds();
		
		RepetitionBuilder repetitionBuilder = new RepetitionBuilder();
		assertEquals(Repetition.SIX_HOURS, repetitionBuilder.buildFromSeconds(singleRepetitionSeconds));
	}
	
	@Test
	public void calculateEightHourRepetitionTest(){
		long routeTime = 7600;
		
		RouteTime time = new RouteTime(routeTime, ONE_HOUR_HOLD_TIME);
		long singleRepetitionSeconds = time.getSingleRepetitionSeconds();
		
		RepetitionBuilder repetitionBuilder = new RepetitionBuilder();
		assertEquals(Repetition.EIGHT_HOURS, repetitionBuilder.buildFromSeconds(singleRepetitionSeconds));
	}
	
	@Test
	public void calculateTwelveHourRepetitionTest(){
		long routeTime = 17719;
		
		RouteTime time = new RouteTime(routeTime, ONE_HOUR_HOLD_TIME);
		long singleRepetitionSeconds = time.getSingleRepetitionSeconds();
		
		RepetitionBuilder repetitionBuilder = new RepetitionBuilder();
		assertEquals(Repetition.TWELVE_HOURS, repetitionBuilder.buildFromSeconds(singleRepetitionSeconds));		
	}
	
	@Test
	public void calculateTwentyFourHourRepetitionTest(){
		long routeTime = 19677;
		
		RouteTime time = new RouteTime(routeTime, ONE_HOUR_HOLD_TIME);
		long singleRepetitionSeconds = time.getSingleRepetitionSeconds();
		
		RepetitionBuilder repetitionBuilder = new RepetitionBuilder();
		assertEquals(Repetition.TWENTY_FOUR_HOURS, repetitionBuilder.buildFromSeconds(singleRepetitionSeconds));		
	}
}
