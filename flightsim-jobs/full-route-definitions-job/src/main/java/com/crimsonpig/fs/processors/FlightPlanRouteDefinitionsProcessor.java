package com.crimsonpig.fs.processors;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.batch.item.ItemProcessor;

import com.crimsonpig.fs.domain.route.DistanceAndHeading;
import com.crimsonpig.fs.domain.route.FlightPlanRouteDefinition;
import com.crimsonpig.fs.domain.route.FullRouteDefinition;
import com.crimsonpig.fs.domain.route.RouteTimes;
import com.crimsonpig.fs.service.DistanceAndHeadingService;
import com.crimsonpig.fs.service.ProposedFlightLevel;

public class FlightPlanRouteDefinitionsProcessor implements
		ItemProcessor<FullRouteDefinition, FlightPlanRouteDefinition> {

	private static final int GROUND_SECONDS = 15 * 60;
	
	private static final int MINIMUM_HOLD_TIME = 60 * 60;
	
	private DistanceAndHeadingService distanceAndHeadingService;

	public void setDistanceAndHeading(DistanceAndHeadingService distanceAndHeading) {
		this.distanceAndHeadingService = distanceAndHeading;
	}

	@Override
	public FlightPlanRouteDefinition process(FullRouteDefinition item)
			throws Exception {

		DistanceAndHeading originToDestination = distanceAndHeadingService.computeDistanceAndHeading(item.getOrigin(), item.getDestination());
		DistanceAndHeading destinationToOrigin = distanceAndHeadingService.computeDistanceAndHeading(item.getDestination(), item.getOrigin());

		if(originToDestination.getDistance() != destinationToOrigin.getDistance()){
			throw new Exception("Distances should be equal!");
		} 
		
		ProposedFlightLevel proposedFlightLevel = new ProposedFlightLevel();
		int outboundFlightLevel = proposedFlightLevel.determineActualFlightLevel(originToDestination.getHeading(), item.getLowestFlightLevel());
		int inboundFlightLevel = proposedFlightLevel.determineActualFlightLevel(destinationToOrigin.getHeading(), item.getLowestFlightLevel());

		FlightPlanRouteDefinition toReturn = new FlightPlanRouteDefinition();
		toReturn.setFlightplanAircraft(item.getFlightplanAircraft());
		toReturn.setOriginAirport(item.getOriginAirport());
		toReturn.setOriginTimezone(item.getOriginTimezone());
		toReturn.setOutboundFlightLevel(outboundFlightLevel);
		toReturn.setDestinationAirport(item.getDestinationAirport());
		toReturn.setReturnFlightLevel(inboundFlightLevel);
		toReturn.setFlightFrequency(item.getFlightFrequency());
		toReturn.setDistance(originToDestination.getDistance());
		
		RouteTimes routeTimes = new RouteTimes();
		
		long routeLegSeconds = GROUND_SECONDS;
		BigDecimal distanceInNauticalMiles = new BigDecimal(originToDestination.getDistance());
		BigDecimal groundSpeedInKnots = new BigDecimal(item.getGroundspeed());
		BigDecimal oneHourInSeconds = new BigDecimal(3600);
		BigDecimal groundSpeedKnotsPerSecond = groundSpeedInKnots.divide(oneHourInSeconds, 4, RoundingMode.HALF_UP);
		BigDecimal routeLegSecondsDecimal = distanceInNauticalMiles.divide(groundSpeedKnotsPerSecond, 0, RoundingMode.HALF_UP);
		
		routeLegSeconds = routeLegSecondsDecimal.longValue();  
		routeLegSeconds += GROUND_SECONDS;
		
		routeTimes.setRouteLegSeconds(routeLegSeconds);
		routeTimes.setHoldTime(MINIMUM_HOLD_TIME);
		
		toReturn.setRouteTimes(routeTimes);

		return toReturn;
	}
	
}
