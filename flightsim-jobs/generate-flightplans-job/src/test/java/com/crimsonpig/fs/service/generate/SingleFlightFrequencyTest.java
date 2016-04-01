package com.crimsonpig.fs.service.generate;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.crimsonpig.fs.domain.flightplan.Repetition;

public class SingleFlightFrequencyTest {

	@Test
	public void fourHourRepetitionTest(){
		Repetition repetition = Repetition.FOUR_HOURS;
		
		assertEquals(6, repetition.getFrequency());
	}
	
	@Test
	public void sixHourRepetitionTest(){
		Repetition repetition = Repetition.SIX_HOURS;
		
		assertEquals(4, repetition.getFrequency());
	}
	
	@Test
	public void eightHourRepetitionTest(){
		Repetition repetition = Repetition.EIGHT_HOURS;
		
		assertEquals(3, repetition.getFrequency());
	}
	
	@Test
	public void twelveHourRepetitionTest(){
		Repetition repetition = Repetition.TWELVE_HOURS;
		
		assertEquals(2, repetition.getFrequency());
	}
	
	@Test
	public void oneDayRepetitionTest(){
		Repetition repetition = Repetition.TWENTY_FOUR_HOURS;
		
		assertEquals(1, repetition.getFrequency());		
	}
}
