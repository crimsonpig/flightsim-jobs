package com.crimsonpig.fs.service.generate;

public class RouteTime {

	private final long routeLegSeconds;
	
	private final long holdTime;

	public RouteTime(long routeLegSeconds, long holdTime) {
		this.routeLegSeconds = routeLegSeconds;
		this.holdTime = holdTime;
	}

	public long getRouteLegSeconds(){
		return routeLegSeconds;
	}
	
	public long getHoldTime(){
		return holdTime;
	}
	
	public long getMinimumLegSeconds() {
		return getHoldTime() + getRouteLegSeconds();
	}

	public long getSingleRepetitionSeconds() {
		return 2 * getMinimumLegSeconds();
	}

}
