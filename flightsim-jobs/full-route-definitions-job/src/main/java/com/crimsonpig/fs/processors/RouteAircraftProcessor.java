package com.crimsonpig.fs.processors;

import org.springframework.batch.item.ItemProcessor;

import com.crimsonpig.fs.domain.aircraft.FlightplanAircraft;
import com.crimsonpig.fs.domain.route.ExpandedRouteDefinition;
import com.crimsonpig.fs.domain.route.FullRouteDefinition;
import com.crimsonpig.fs.service.retrieve.RetrieveFlightplanAircraftService;

public class RouteAircraftProcessor implements ItemProcessor<ExpandedRouteDefinition,FullRouteDefinition> {

	private RetrieveFlightplanAircraftService aircraftService;
	
	public void setAircraftService(RetrieveFlightplanAircraftService aircraftService){
		this.aircraftService = aircraftService;
	}
	
	public FullRouteDefinition process(ExpandedRouteDefinition item)
			throws Exception {
		String airline = item.getAirline();
		String model = item.getAircraftModel();
		FlightplanAircraft flightPlanAircraft = aircraftService.retrieveInstalledAircraftFromAirlineAndModel(airline, model);
		FullRouteDefinition fullRoute = new FullRouteDefinition();
		fullRoute.setFlightplanAircraft(flightPlanAircraft);
		fullRoute.setOrigin(item.getOrigin());
		fullRoute.setDestination(item.getDestination());
		fullRoute.setFlightFrequency(item.getFlightFrequency());
		fullRoute.setOriginTimezone(item.getOriginTimezone());
		fullRoute.setLowestFlightLevel(item.getLowestFlightLevel());
		return fullRoute;
	}

}
