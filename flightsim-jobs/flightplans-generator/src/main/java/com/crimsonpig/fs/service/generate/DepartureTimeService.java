package com.crimsonpig.fs.service.generate;

import java.time.LocalTime;

public class DepartureTimeService {
	
	private LocalTime localTime;
	private LocalTime initialLocalTime;
	private LocalTime upperBoundLocalTime;
	
	public DepartureTimeService(){
		this.initialLocalTime = LocalTime.of(6, 0, 0);
		localTime = this.initialLocalTime;
		this.upperBoundLocalTime = this.initialLocalTime.plusHours(3).plusMinutes(55);
	}
	
	private void incrementLocalTime(){
		if(localTime.equals(upperBoundLocalTime)){
			localTime = initialLocalTime;
		}else{
			localTime = localTime.plusMinutes(5);
		}
	}

	public LocalTime getNextDepartureTimeAsGmt(int originTimezone) {
		LocalTime localTimeWithGmt = localTime.minusHours(originTimezone);
		incrementLocalTime();
		return localTimeWithGmt;
	}
}
