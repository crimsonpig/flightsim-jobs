package com.crimsonpig.fs.service.generate;

import static org.junit.Assert.*;

import org.junit.Test;

import com.crimsonpig.fs.domain.flightplan.Repetition;

public class RepetitionReducerTest {

	@Test
	public void calculateSixTimesADayRepetition(){
		int flightFrequency = 6;
		Repetition originalRepetition = Repetition.FOUR_HOURS;
		assertEquals(Repetition.FOUR_HOURS, new RepetitionReducer().buildRepetitionFromFrequency(originalRepetition, flightFrequency));
	}
	
	@Test
	public void calculateFiveTimesADayRepetition(){
		int flightFrequency = 5;
		Repetition originalRepetition = Repetition.FOUR_HOURS;
		assertEquals(Repetition.FOUR_HOURS, new RepetitionReducer().buildRepetitionFromFrequency(originalRepetition, flightFrequency));
	}
	
	@Test
	public void calculateFourTimesADayRepetition(){
		int flightFrequency = 4;
		Repetition originalRepetition = Repetition.FOUR_HOURS;
		assertEquals(Repetition.SIX_HOURS, new RepetitionReducer().buildRepetitionFromFrequency(originalRepetition, flightFrequency));
	}
	
	@Test
	public void calculateThreeTimesADayRepetition(){
		int flightFrequency = 3;
		Repetition originalRepetition = Repetition.FOUR_HOURS;
		assertEquals(Repetition.EIGHT_HOURS, new RepetitionReducer().buildRepetitionFromFrequency(originalRepetition, flightFrequency));
	}
	
	@Test
	public void calculateTwoTimesADayRepetition(){
		int flightFrequency = 2;
		Repetition originalRepetition = Repetition.FOUR_HOURS;
		assertEquals(Repetition.TWELVE_HOURS, new RepetitionReducer().buildRepetitionFromFrequency(originalRepetition, flightFrequency));
	}
	
	@Test
	public void calculateOneTimesADayRepetition(){
		int flightFrequency = 1;
		Repetition originalRepetition = Repetition.FOUR_HOURS;
		assertEquals(Repetition.TWENTY_FOUR_HOURS, new RepetitionReducer().buildRepetitionFromFrequency(originalRepetition, flightFrequency));
	}
	
	
	
}
