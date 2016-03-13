package com.crimsonpig.fs.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class RouteTimesService {


	private static final int GROUND_SECONDS = 15 * 60;

	public long calculateRouteTime(double distance, int groundspeed) {

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

}
