package com.crimsonpig.fs.domain.route;

public class RouteLeg {

	private String originAirport;
	private String destinationAirport;
	private int flightLevel;
	private double distance;

	public RouteLeg(){
		
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
	
	public int getFlightLevel() {
		return flightLevel;
	}
	
	public void setFlightLevel(int flightLevel) {
		this.flightLevel = flightLevel;
	}
	
	public double getDistance() {
		return distance;
	}
	
	public void setDistance(double distance) {
		this.distance = distance;
	}

}
