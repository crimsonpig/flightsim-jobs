package com.crimsonpig.fs.processors;

import org.springframework.batch.item.ItemProcessor;

import com.crimsonpig.fs.domain.airport.ConvertedAirport;
import com.crimsonpig.fs.domain.route.ExpandedRouteDefinition;
import com.crimsonpig.fs.domain.route.SimpleRouteDefinition;
import com.crimsonpig.fs.service.retrieve.RetrieveAirportService;

public class RouteAirportProcessor implements ItemProcessor<SimpleRouteDefinition,ExpandedRouteDefinition>{

	private RetrieveAirportService airportService;
	
	public void setAirportService(RetrieveAirportService airportService){
		this.airportService = airportService;
	}
	
	public ExpandedRouteDefinition process(SimpleRouteDefinition item)
			throws Exception {
		return buildExpandedRouteDefinition(item);
	}

	private ExpandedRouteDefinition buildExpandedRouteDefinition(
			SimpleRouteDefinition item) {
		ConvertedAirport originAirport = airportService.retrieveAirport(item.getOriginAirport());
		ConvertedAirport destinationAirport = airportService.retrieveAirport(item.getDestinationAirport());
		ExpandedRouteDefinition routeWithAirports = new ExpandedRouteDefinition(); 
		routeWithAirports.setAircraftModel(item.getAircraftModel());
		routeWithAirports.setAirline(item.getAirline());
		routeWithAirports.setOrigin(originAirport);
		routeWithAirports.setDestination(destinationAirport);
		routeWithAirports.setOriginTimezone(item.getOriginTimezone());
		routeWithAirports.setFlightFrequency(item.getFlightFrequency());
		routeWithAirports.setLowestFlightLevel(item.getLowestFlightLevel());
		return routeWithAirports;
	}

}
