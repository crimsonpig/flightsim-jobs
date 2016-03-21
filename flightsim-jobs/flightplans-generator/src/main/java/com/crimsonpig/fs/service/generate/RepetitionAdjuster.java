package com.crimsonpig.fs.service.generate;

import com.crimsonpig.fs.domain.flightplan.Repetition;

public class RepetitionAdjuster {

	public Repetition adjustRepetitionDownBasedOnFlightFrequency(Repetition repetition, int flightFrequency) {
		

		int repetitionFrequency = repetition.getFrequency();
		while(repetitionFrequency > flightFrequency){
			int lowerRepetitionFrequency = repetitionFrequency - 1;
			
			
		}
		return repetition;
	}

}
