package com.crimsonpig.fs.service.generate;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.crimsonpig.fs.domain.flightplan.Repetition;

public class RepetitionAdjusterTest {

	@Test
	public void adjustSixHourRepetitionToEightHours(){
			
			int flightFrequency = 3;
			Repetition repetition = Repetition.SIX_HOURS;
		
			RepetitionAdjuster repetitionAdjuster = new RepetitionAdjuster();
			repetitionAdjuster.adjustRepetitionDownBasedOnFlightFrequency(repetition, flightFrequency);
			
	}
	
	
}
