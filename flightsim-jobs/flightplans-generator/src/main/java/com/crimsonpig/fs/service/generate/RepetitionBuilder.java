package com.crimsonpig.fs.service.generate;

import com.crimsonpig.fs.domain.flightplan.Repetition;
import com.crimsonpig.fs.exception.RouteExceedsTwentyFourHoursException;

public class RepetitionBuilder {

	private double TOLERANCE_FACTOR = 1.0/6.0;
	
	public Repetition buildFromSeconds(RouteTime routeTime){
		Repetition toReturn = null;
		
		long singleRepetitionSeconds = routeTime.getSingleRepetitionSeconds();
		long toleranceSeconds = (long)(TOLERANCE_FACTOR * (double)routeTime.getHoldTime());
		
		if(isWithinToleranceOfRepetition(singleRepetitionSeconds, Repetition.FOUR_HOURS, toleranceSeconds)) {
			toReturn = Repetition.FOUR_HOURS;			
		} else if(isWithinToleranceOfRepetition(singleRepetitionSeconds, Repetition.SIX_HOURS, toleranceSeconds)) {
			toReturn = Repetition.SIX_HOURS;			
		} else if(isWithinToleranceOfRepetition(singleRepetitionSeconds, Repetition.EIGHT_HOURS, toleranceSeconds)) {
			toReturn = Repetition.EIGHT_HOURS;			
		} else if(isWithinToleranceOfRepetition(singleRepetitionSeconds, Repetition.TWELVE_HOURS, toleranceSeconds)) {
			toReturn = Repetition.TWELVE_HOURS;			
		} else if(isWithinToleranceOfRepetition(singleRepetitionSeconds, Repetition.TWENTY_FOUR_HOURS, toleranceSeconds)) {
			toReturn = Repetition.TWENTY_FOUR_HOURS;			
		} else {
			throw new RouteExceedsTwentyFourHoursException("Single-repetition seconds exceeds 24 hours!");
		}
		return toReturn;
	}

	private boolean isWithinToleranceOfRepetition(long singleRepetitionSeconds, Repetition repetition, long tolerance){
		return singleRepetitionSeconds <= (tolerance + repetition.getSeconds());
	}
}
