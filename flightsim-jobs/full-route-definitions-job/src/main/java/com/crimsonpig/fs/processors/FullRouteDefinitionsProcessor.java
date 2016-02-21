package com.crimsonpig.fs.processors;

import org.springframework.batch.item.ItemProcessor;

import com.crimsonpig.fs.domain.aircraft.FlightplanAircraft;
import com.crimsonpig.fs.domain.airport.ConvertedAirport;
import com.crimsonpig.fs.domain.route.FullRouteDefinition;
import com.crimsonpig.fs.domain.route.SimpleRouteDefinition;
import com.crimsonpig.fs.service.retrieve.RetrieveAirportService;
import com.crimsonpig.fs.service.retrieve.RetrieveFlightplanAircraftService;

public class FullRouteDefinitionsProcessor implements ItemProcessor<SimpleRouteDefinition,FullRouteDefinition> {

	private RetrieveAirportService airportService;
	private RetrieveFlightplanAircraftService aircraftService;
	
	public void setAirportService(RetrieveAirportService airportService){
		this.airportService = airportService;
	}
	
	public void setAircraftService(RetrieveFlightplanAircraftService aircraftService){
		this.aircraftService = aircraftService;
	}	
	
	@Override
	public FullRouteDefinition process(SimpleRouteDefinition item)
			throws Exception {
		
		String airline = item.getAirline();
		String model = item.getAircraftModel();
		FlightplanAircraft flightPlanAircraft = aircraftService.retrieveInstalledAircraftFromAirlineAndModel(airline, model);
		
		ConvertedAirport originAirport = airportService.retrieveAirport(item.getOriginAirport());
		ConvertedAirport destinationAirport = airportService.retrieveAirport(item.getDestinationAirport());
		
		FullRouteDefinition fullRoute = new FullRouteDefinition();
		
		fullRoute.setFlightplanAircraft(flightPlanAircraft);
		fullRoute.setOrigin(originAirport);
		fullRoute.setDestination(destinationAirport);
		fullRoute.setFlightFrequency(item.getFlightFrequency());
		fullRoute.setOriginTimezone(item.getOriginTimezone());
		fullRoute.setLowestFlightLevel(item.getLowestFlightLevel());
		
		return fullRoute;
	}

}
