package com.crimsonpig.fs.domain.route;


public class RouteTimes {
	
	private long holdTime;
	private long routeLegSeconds;
	
	public long getHoldTime() {
		return holdTime;
	}
	
	public void setHoldTime(long holdTime) {
		this.holdTime = holdTime;
	}
	
	public long getRouteLegSeconds() {
		return routeLegSeconds;
	}
	
	public void setRouteLegSeconds(long routeLegSeconds) {
		this.routeLegSeconds = routeLegSeconds;
	}

	public long getMinimumLegSeconds() {
		return holdTime + getRouteLegSeconds();
	}

	public long getSingleRepetitionSeconds() {
		return 2 * getMinimumLegSeconds();
	}
}
