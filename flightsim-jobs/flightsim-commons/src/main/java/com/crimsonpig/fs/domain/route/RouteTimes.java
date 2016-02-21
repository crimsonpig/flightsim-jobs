package com.crimsonpig.fs.domain.route;


public class RouteTimes {
	
	private long minimumHoldTimeInSeconds;
	private long routeLegSeconds;
	private long minimumLegSeconds;
	private long singleRepetitionSeconds;

	public long getMinimumHoldTimeInSeconds() {
		return minimumHoldTimeInSeconds;
	}

	public void setMinimumHoldTimeInSeconds(long minimumHoldTimeInSeconds) {
		this.minimumHoldTimeInSeconds = minimumHoldTimeInSeconds;
	}

	public long getRouteLegSeconds() {
		return routeLegSeconds;
	}

	public void setRouteLegSeconds(long routeLegSeconds) {
		this.routeLegSeconds = routeLegSeconds;
	}

	public long getMinimumLegSeconds() {
		return minimumLegSeconds;
	}

	public void setMinimumLegSeconds(long minimumLegSeconds) {
		this.minimumLegSeconds = minimumLegSeconds;
	}

	public long getSingleRepetitionSeconds() {
		return singleRepetitionSeconds;
	}

	public void setSingleRepetitionSeconds(long singleRepetitionSeconds) {
		this.singleRepetitionSeconds = singleRepetitionSeconds;
	}
	

}
