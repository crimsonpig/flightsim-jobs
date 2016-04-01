package com.crimsonpig.fs.service.generate;

import static org.junit.Assert.assertEquals;

import java.time.LocalTime;
import java.util.List;

import org.junit.Test;

import com.crimsonpig.fs.domain.flightplan.Repetition;

public class StartTimeGeneratorTest {

	@Test
	public void startTimeForSingleFlightTest(){
		int numberOfFlightPlans = 1;
		Repetition repetition = Repetition.FOUR_HOURS;		
		StartTimeSequenceGenerator startTimeGenerator = new StartTimeSequenceGenerator();
		List<LocalTime> startTimes = startTimeGenerator.generateSequenceOfStartTimes(-7, numberOfFlightPlans, repetition.getSeconds());
		
		assertEquals(numberOfFlightPlans, startTimes.size());
		assertEquals(LocalTime.of(13,0,0), startTimes.get(0));
	}
	
	@Test
	public void startTimeForTwoFlightsTest(){
		int numberOfFlightPlans = 2;
		Repetition repetition = Repetition.FOUR_HOURS;		
		StartTimeSequenceGenerator startTimeGenerator = new StartTimeSequenceGenerator();
		List<LocalTime> startTimes = startTimeGenerator.generateSequenceOfStartTimes(-7, numberOfFlightPlans, repetition.getSeconds());
		
		assertEquals(numberOfFlightPlans, startTimes.size());
		assertEquals(LocalTime.of(13,0,0), startTimes.get(0));
		assertEquals(LocalTime.of(13,0,0), startTimes.get(1));
	}
	
	
	@Test
	public void startTimeForThreeFlightsTest(){
		int numberOfFlightPlans = 3;
		Repetition repetition = Repetition.FOUR_HOURS;
		StartTimeSequenceGenerator startTimeGenerator = new StartTimeSequenceGenerator();
		List<LocalTime> startTimes = startTimeGenerator.generateSequenceOfStartTimes(-7, numberOfFlightPlans, repetition.getSeconds());
		
		assertEquals(numberOfFlightPlans, startTimes.size());
		assertEquals(LocalTime.of(13,0,0), startTimes.get(0));
		assertEquals(LocalTime.of(13,0,0), startTimes.get(1));
		assertEquals(LocalTime.of(14,0,0), startTimes.get(2));		
	}
	
	@Test
	public void startTimeForFourFlightsTest(){
		int numberOfFlightPlans = 4;
		Repetition repetition = Repetition.FOUR_HOURS;
		StartTimeSequenceGenerator startTimeGenerator = new StartTimeSequenceGenerator();
		List<LocalTime> startTimes = startTimeGenerator.generateSequenceOfStartTimes(-7, numberOfFlightPlans, repetition.getSeconds());
		
		assertEquals(numberOfFlightPlans, startTimes.size());
		assertEquals(LocalTime.of(13,0,0), startTimes.get(0));
		assertEquals(LocalTime.of(13,0,0), startTimes.get(1));
		assertEquals(LocalTime.of(14,0,0), startTimes.get(2));		
		assertEquals(LocalTime.of(14,0,0), startTimes.get(3));			
	}	
	
	
	@Test
	public void startTimeForFiveFlightsTest(){
		int numberOfFlightPlans = 5;
		Repetition repetition = Repetition.FOUR_HOURS;
		StartTimeSequenceGenerator startTimeGenerator = new StartTimeSequenceGenerator();
		List<LocalTime> startTimes = startTimeGenerator.generateSequenceOfStartTimes(-7, numberOfFlightPlans, repetition.getSeconds());
		
		assertEquals(numberOfFlightPlans, startTimes.size());
		assertEquals(LocalTime.of(13,0,0), startTimes.get(0));
		assertEquals(LocalTime.of(13,0,0), startTimes.get(1));
		assertEquals(LocalTime.of(13,40,0), startTimes.get(2));		
		assertEquals(LocalTime.of(13,40,0), startTimes.get(3));			
		assertEquals(LocalTime.of(14,20,0), startTimes.get(4));			
	}		

	@Test
	public void startTimeForThreeEightHourFlightsTest(){
		int numberOfFlightPlans = 3;
		Repetition repetition = Repetition.EIGHT_HOURS;
		StartTimeSequenceGenerator startTimeGenerator = new StartTimeSequenceGenerator();
		List<LocalTime> startTimes = startTimeGenerator.generateSequenceOfStartTimes(-7, numberOfFlightPlans, repetition.getSeconds());
		
		assertEquals(numberOfFlightPlans, startTimes.size());
		assertEquals(LocalTime.of(13,0,0), startTimes.get(0));
		assertEquals(LocalTime.of(13,0,0), startTimes.get(1));
		assertEquals(LocalTime.of(15,0,0), startTimes.get(2));		
	}		
	
	@Test
	public void startTimeForFourTwelveHourFlightsTest(){
		int numberOfFlightPlans = 4;
		Repetition repetition = Repetition.TWELVE_HOURS;
		StartTimeSequenceGenerator startTimeGenerator = new StartTimeSequenceGenerator();
		List<LocalTime> startTimes = startTimeGenerator.generateSequenceOfStartTimes(-7, numberOfFlightPlans, repetition.getSeconds());
		
		assertEquals(numberOfFlightPlans, startTimes.size());
		assertEquals(LocalTime.of(13,0,0), startTimes.get(0));
		assertEquals(LocalTime.of(13,0,0), startTimes.get(1));
		assertEquals(LocalTime.of(16,0,0), startTimes.get(2));		
		assertEquals(LocalTime.of(16,0,0), startTimes.get(3));			
	}	
	
	
	@Test
	public void startTimeForSixTwelveHourFlightsTest(){
		int numberOfFlightPlans = 6;
		Repetition repetition = Repetition.TWELVE_HOURS;
		StartTimeSequenceGenerator startTimeGenerator = new StartTimeSequenceGenerator();
		List<LocalTime> startTimes = startTimeGenerator.generateSequenceOfStartTimes(-7, numberOfFlightPlans, repetition.getSeconds());
		
		assertEquals(numberOfFlightPlans, startTimes.size());
		assertEquals(LocalTime.of(13,0,0), startTimes.get(0));
		assertEquals(LocalTime.of(13,0,0), startTimes.get(1));
		assertEquals(LocalTime.of(15,0,0), startTimes.get(2));
		assertEquals(LocalTime.of(15,0,0), startTimes.get(3));
		assertEquals(LocalTime.of(17,0,0), startTimes.get(4));
		assertEquals(LocalTime.of(17,0,0), startTimes.get(5));

	}	
}
