package com.crimsonpig.fs.domain.route;

public class SimpleRouteDefinition {
	
	private int originTimezone;
	private int flightFrequency;
	private int lowestFlightLevel;
	private String airline;
	private String aircraftModel;
	private String originAirport;
	private String destinationAirport;
	
	public SimpleRouteDefinition(){
		
	}

	public int getOriginTimezone() {
		return originTimezone;
	}

	public void setOriginTimezone(int originTimezone) {
		this.originTimezone = originTimezone;
	}

	public int getFlightFrequency() {
		return flightFrequency;
	}

	public void setFlightFrequency(int flightFrequency) {
		this.flightFrequency = flightFrequency;
	}

	public int getLowestFlightLevel() {
		return lowestFlightLevel;
	}

	public void setLowestFlightLevel(int lowestFlightLevel) {
		this.lowestFlightLevel = lowestFlightLevel;
	}

	public String getAirline() {
		return airline;
	}

	public void setAirline(String airline) {
		this.airline = airline;
	}

	public String getAircraftModel() {
		return aircraftModel;
	}

	public void setAircraftModel(String aircraftModel) {
		this.aircraftModel = aircraftModel;
	}

	public String getOriginAirport() {
		return originAirport;
	}

	public void setOriginAirport(String originAirport) {
		this.originAirport = originAirport;
	}

	public String getDestinationAirport() {
		return destinationAirport;
	}

	public void setDestinationAirport(String destinationAirport) {
		this.destinationAirport = destinationAirport;
	}

}
