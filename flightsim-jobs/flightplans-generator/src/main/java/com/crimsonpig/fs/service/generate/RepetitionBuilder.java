package com.crimsonpig.fs.service.generate;

import com.crimsonpig.fs.domain.flightplan.Repetition;
import com.crimsonpig.fs.exception.RouteExceedsTwentyFourHoursException;

public class RepetitionBuilder {

	private int TOLERANCE_SECONDS = 600;
	
	public Repetition buildFromSeconds(long singleRepetitionSeconds){
		Repetition toReturn = null;
		
		if(isWithinToleranceOfRepetition(singleRepetitionSeconds, Repetition.FOUR_HOURS, TOLERANCE_SECONDS)) {
			toReturn = Repetition.FOUR_HOURS;			
		} else if(isWithinToleranceOfRepetition(singleRepetitionSeconds, Repetition.SIX_HOURS, TOLERANCE_SECONDS)) {
			toReturn = Repetition.SIX_HOURS;			
		} else if(isWithinToleranceOfRepetition(singleRepetitionSeconds, Repetition.EIGHT_HOURS, TOLERANCE_SECONDS)) {
			toReturn = Repetition.EIGHT_HOURS;			
		} else if(isWithinToleranceOfRepetition(singleRepetitionSeconds, Repetition.TWELVE_HOURS, TOLERANCE_SECONDS)) {
			toReturn = Repetition.TWELVE_HOURS;			
		} else if(isWithinToleranceOfRepetition(singleRepetitionSeconds, Repetition.TWENTY_FOUR_HOURS, TOLERANCE_SECONDS)) {
			toReturn = Repetition.TWENTY_FOUR_HOURS;			
		} else {
			throw new RouteExceedsTwentyFourHoursException("Single-repetition seconds exceeds 24 hours!");
		}
		return toReturn;
	}

	private boolean isWithinToleranceOfRepetition(long singleRepetitionSeconds, Repetition repetition, int tolerance){
		return singleRepetitionSeconds <= (tolerance + repetition.getSeconds());
	}
}
