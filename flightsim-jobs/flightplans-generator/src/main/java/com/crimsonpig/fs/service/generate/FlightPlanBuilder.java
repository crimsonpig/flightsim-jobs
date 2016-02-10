package com.crimsonpig.fs.service.generate;

import com.crimsonpig.fs.domain.flightplan.Repetition;

public class FlightPlanBuilder {

	private RepetitionBuilder repetitionBuilder;
	
	public FlightPlanBuilder(){
		repetitionBuilder = new RepetitionBuilder();
	}
	
	public int getNumberOfFlightPlans(int routeFrequency,
			RouteTime time) {
		long singleRepetitionSeconds = time.getSingleRepetitionSeconds();
		Repetition repetition = repetitionBuilder.buildFromSeconds(singleRepetitionSeconds);
		
		int numberOfFlightPlans = 1;
		int singleFlightFrequency = repetition.getFrequency();
		int numberOfRepetitions = numberOfFlightPlans * singleFlightFrequency;
		while(numberOfRepetitions < routeFrequency){
			numberOfFlightPlans++;
			numberOfRepetitions = numberOfFlightPlans * singleFlightFrequency;
		}
		return numberOfFlightPlans;
	}

}
