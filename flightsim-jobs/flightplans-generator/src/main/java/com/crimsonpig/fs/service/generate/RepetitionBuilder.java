package com.crimsonpig.fs.service.generate;

import com.crimsonpig.fs.domain.flightplan.Repetition;
import com.crimsonpig.fs.exception.RouteExceedsTwentyFourHoursException;

public class RepetitionBuilder {

	public Repetition buildFromSeconds(long singleRepetitionSeconds){
		Repetition toReturn = null;
		
		if(isWithinOneMinuteOfRepetition(singleRepetitionSeconds, Repetition.FOUR_HOURS)) {
			toReturn = Repetition.FOUR_HOURS;			
		} else if(isWithinOneMinuteOfRepetition(singleRepetitionSeconds, Repetition.SIX_HOURS)) {
			toReturn = Repetition.SIX_HOURS;			
		} else if(isWithinOneMinuteOfRepetition(singleRepetitionSeconds, Repetition.EIGHT_HOURS)) {
			toReturn = Repetition.EIGHT_HOURS;			
		} else if(isWithinOneMinuteOfRepetition(singleRepetitionSeconds, Repetition.TWELVE_HOURS)) {
			toReturn = Repetition.TWELVE_HOURS;			
		} else if(singleRepetitionSeconds <= Repetition.TWENTY_FOUR_HOURS.getSeconds()) {
			toReturn = Repetition.TWENTY_FOUR_HOURS;			
		} else {
			throw new RouteExceedsTwentyFourHoursException("Single-repetition seconds exceeds 24 hours!");
		}
		return toReturn;
	}

	private boolean isWithinOneMinuteOfRepetition(long singleRepetitionSeconds, Repetition repetition){
		return singleRepetitionSeconds <= (60 + repetition.getSeconds());
	}
}
