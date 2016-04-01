package com.crimsonpig.fs.service;

import com.crimsonpig.fs.domain.route.FlightPlanRouteDefinition;
import com.crimsonpig.fs.domain.route.FullRouteDefinition;

public class FlightPlanRouteDefinitionsService {

	public FlightPlanRouteDefinition populateFlightPlanRouteDefinition(
			FullRouteDefinition item) {
		
		FlightPlanRouteDefinition toReturn = new FlightPlanRouteDefinition();
		
		toReturn.setFlightplanAircraft(item.getFlightplanAircraft());
		toReturn.setOriginAirport(item.getOriginAirport());
		toReturn.setOriginTimezone(item.getOriginTimezone());
		toReturn.setDestinationAirport(item.getDestinationAirport());
		toReturn.setFlightFrequency(item.getFlightFrequency());

		return toReturn;
	}

}
