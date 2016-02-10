package com.crimsonpig.fs.service.generate;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class RouteTime {

	private final int groundspeed;
	private final double distance;
	
	private static final int GROUND_SECONDS = 15 * 60;
	
	private static final int MINIMUM_HOLD_TIME = 60 * 60;
	
	public RouteTime(int groundspeed, double distance) {
		this.groundspeed = groundspeed;
		this.distance = distance;
	}

	public int getGroundspeed() {
		return groundspeed;
	}

	public double getDistance() {
		return distance;
	}

	public long getRouteLegSeconds() {
		long routeLegSeconds = GROUND_SECONDS;
		BigDecimal distanceInNauticalMiles = new BigDecimal(distance);
		BigDecimal groundSpeedInKnots = new BigDecimal(groundspeed);
		BigDecimal oneHourInSeconds = new BigDecimal(3600);
		BigDecimal groundSpeedKnotsPerSecond = groundSpeedInKnots.divide(oneHourInSeconds, 4, RoundingMode.HALF_UP);
		BigDecimal routeLegSecondsDecimal = distanceInNauticalMiles.divide(groundSpeedKnotsPerSecond, 0, RoundingMode.HALF_UP);
		
		routeLegSeconds = routeLegSecondsDecimal.longValue();  
		routeLegSeconds += GROUND_SECONDS;
		return routeLegSeconds;
	}

	public long getMinimumLegSeconds() {
		return MINIMUM_HOLD_TIME + getRouteLegSeconds();
	}

	public long getSingleRepetitionSeconds() {
		return 2 * getMinimumLegSeconds();
	}

}
