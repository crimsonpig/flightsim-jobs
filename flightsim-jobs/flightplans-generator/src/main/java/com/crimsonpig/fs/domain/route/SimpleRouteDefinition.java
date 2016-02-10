package com.crimsonpig.fs.domain.route;

public class SimpleRouteDefinition extends RouteDefinition {
	
	private String airline;
	private String aircraftModel;
	private String originAirport;
	private String destinationAirport;
	
	public SimpleRouteDefinition(){
		
	}

	@Override
	public String getAirline() {
		return airline;
	}

	@Override
	public void setAirline(String airline) {
		this.airline = airline;
	}

	@Override
	public String getAircraftModel() {
		return aircraftModel;
	}

	@Override
	public void setAircraftModel(String aircraftModel) {
		this.aircraftModel = aircraftModel;
	}

	@Override
	public String getOriginAirport() {
		return originAirport;
	}

	@Override
	public void setOriginAirport(String originAirport) {
		this.originAirport = originAirport;
	}

	@Override
	public String getDestinationAirport() {
		return destinationAirport;
	}

	@Override
	public void setDestinationAirport(String destinationAirport) {
		this.destinationAirport = destinationAirport;
	}
	
}
