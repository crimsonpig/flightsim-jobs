package com.crimsonpig.fs.service;

public class ComputeFlightTimeService {
	private final int groundspeed;
	private final double distance;

	private static final int GROUND_SECONDS = 15 * 60;
	
	public ComputeFlightTimeService(double distance, int groundspeed){
		this.distance = distance;
		this.groundspeed = groundspeed;
	}
	
	//get speed in nautical miles / second
	public long getFlightTimeInSeconds() {
		long flightTimeInSeconds = 0;
		flightTimeInSeconds = (long)(distance / (groundspeed / 3600.0));  
		flightTimeInSeconds += GROUND_SECONDS;
		return flightTimeInSeconds;
	}
}
