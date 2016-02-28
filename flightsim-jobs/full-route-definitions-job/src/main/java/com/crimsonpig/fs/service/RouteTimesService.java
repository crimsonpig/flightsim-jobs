package com.crimsonpig.fs.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.crimsonpig.fs.domain.route.RouteTimes;

public class RouteTimesService {


	private static final int GROUND_SECONDS = 15 * 60;
	
	private static final int MINIMUM_HOLD_TIME = 60 * 60;
	
	public RouteTimes calculateRouteTimes(double distance, int groundspeed) {
		RouteTimes routeTimes = new RouteTimes();
		
		long routeLegSeconds = GROUND_SECONDS;
		BigDecimal distanceInNauticalMiles = new BigDecimal(distance);
		BigDecimal groundSpeedInKnots = new BigDecimal(groundspeed);
		BigDecimal oneHourInSeconds = new BigDecimal(3600);
		BigDecimal groundSpeedKnotsPerSecond = groundSpeedInKnots.divide(oneHourInSeconds, 4, RoundingMode.HALF_UP);
		BigDecimal routeLegSecondsDecimal = distanceInNauticalMiles.divide(groundSpeedKnotsPerSecond, 0, RoundingMode.HALF_UP);
		
		routeLegSeconds = routeLegSecondsDecimal.longValue();  
		routeLegSeconds += GROUND_SECONDS;
		
		routeTimes.setRouteLegSeconds(routeLegSeconds);
		routeTimes.setHoldTime(MINIMUM_HOLD_TIME);
		
		return routeTimes;
	}

}
