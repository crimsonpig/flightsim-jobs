package com.crimsonpig.fs.service.generate;

import com.crimsonpig.fs.domain.flightplan.Repetition;

public class FlightPlanBuilder {

	public FlightPlanBuilder(){

	}
	
	public int getNumberOfFlightPlans(int routeFrequency,
			Repetition repetition) {
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
