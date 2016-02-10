package com.crimsonpig.fs.domain.route;

import com.crimsonpig.fs.domain.airport.ConvertedAirport;

public class ExpandedRouteDefinition extends RouteDefinition {
	
	private ConvertedAirport origin;
	private ConvertedAirport destination;
	
	private String airline;
	private String aircraftModel;
	
	public ExpandedRouteDefinition(){
		this.origin = new ConvertedAirport();
		this.destination = new ConvertedAirport();		
	}
	
	public ConvertedAirport getOrigin() {
		return origin;
	}

	public void setOrigin(ConvertedAirport origin) {
		this.origin = origin;
	}

	public ConvertedAirport getDestination() {
		return destination;
	}

	public void setDestination(ConvertedAirport destination) {
		this.destination = destination;
	}
	
	@Override
	public String getOriginAirport() {
		return origin.getIdentifier();
	}

	@Override
	public void setOriginAirport(String originAirport) {
		origin.setIdentifier(originAirport);
	}

	public double getOriginLatitude() {
		return origin.getLatitudeRadians();
	}

	public void setOriginLatitude(double originLatitude) {
		origin.setLatitudeRadians(originLatitude);
	}

	public double getOriginLongitude() {
		return origin.getLongitudeRadians();
	}

	public void setOriginLongitude(double originLongitude) {
		origin.setLongitudeRadians(originLongitude);
	}

	@Override
	public String getDestinationAirport() {
		return destination.getIdentifier();
	}

	@Override
	public void setDestinationAirport(String destinationAirport) {
		destination.setIdentifier(destinationAirport);
	}

	public double getDestinationLatitude() {
		return destination.getLatitudeRadians();
	}

	public void setDestinationLatitude(double destinationLatitude) {
		destination.setLatitudeRadians(destinationLatitude);
	}

	public double getDestinationLongitude() {
		return destination.getLongitudeRadians();
	}

	public void setDestinationLongitude(double destinationLongitude) {
		destination.setLongitudeRadians(destinationLongitude);
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
	
}
