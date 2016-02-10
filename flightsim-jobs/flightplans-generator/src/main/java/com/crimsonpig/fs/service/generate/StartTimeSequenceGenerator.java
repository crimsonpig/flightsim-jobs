package com.crimsonpig.fs.service.generate;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class StartTimeSequenceGenerator {

	private DepartureTimeService depTimeService;
	
	public StartTimeSequenceGenerator(){
		this.depTimeService = new DepartureTimeService();
	}
	
	public List<LocalTime> generateSequenceOfStartTimes(int originTimezone,
			int numberOfFlightPlans, long repetitionSeconds) {
		LocalTime startTime = depTimeService.getNextDepartureTimeAsGmt(originTimezone);
		List<LocalTime> startTimes = new ArrayList<LocalTime>(numberOfFlightPlans);
		long incrementSeconds = calculateStartTimeInterval(repetitionSeconds, numberOfFlightPlans);
		for(int idx = 1; idx <= numberOfFlightPlans; idx++){
			if((idx >= 3) && ((idx % 2) != 0)) {
				startTime = startTime.plusSeconds(incrementSeconds);
			}
			startTimes.add(startTime);
		}
		return startTimes;
	}

	private long calculateStartTimeInterval(long repetitionSeconds,
			int numberOfFlightPlans) {
		int roundedNumberOfFlightPlans = roundUpToNearestTwo(numberOfFlightPlans);
		return repetitionSeconds / roundedNumberOfFlightPlans;
	}

	private int roundUpToNearestTwo(int numberOfFlightPlans) {
		return numberOfFlightPlans % 2 == 0 ? numberOfFlightPlans : numberOfFlightPlans + 1;
	}

}
