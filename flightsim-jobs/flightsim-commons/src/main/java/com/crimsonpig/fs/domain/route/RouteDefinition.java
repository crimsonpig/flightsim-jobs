package com.crimsonpig.fs.domain.route;

public abstract class RouteDefinition {
	private int originTimezone;
	private int flightFrequency;
	private int lowestFlightLevel;

	public int getFlightFrequency() {
		return flightFrequency;
	}

	public void setFlightFrequency(int flightFrequency) {
		this.flightFrequency = flightFrequency;
	}
	
	public int getOriginTimezone() {
		return originTimezone;
	}

	public void setOriginTimezone(int originTimezone) {
		this.originTimezone = originTimezone;
	}
	
	public int getLowestFlightLevel(){
		return lowestFlightLevel;
	}
	
	public void setLowestFlightLevel(int lowestFlightLevel){
		this.lowestFlightLevel = lowestFlightLevel;
	}
	
	public abstract String getAirline();
	public abstract void setAirline(String airline);
	public abstract String getAircraftModel();
	public abstract void setAircraftModel(String aircraftModel);
	public abstract String getOriginAirport();
	public abstract void setOriginAirport(String originAirport);
	public abstract String getDestinationAirport();
	public abstract void setDestinationAirport(String destinationAirport);
}
