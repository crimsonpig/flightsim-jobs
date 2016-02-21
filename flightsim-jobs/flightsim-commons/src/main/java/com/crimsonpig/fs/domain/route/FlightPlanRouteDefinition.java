package com.crimsonpig.fs.domain.route;

import com.crimsonpig.fs.domain.aircraft.FlightplanAircraft;

public class FlightPlanRouteDefinition {

	private FlightplanAircraft flightplanAircraft;
	private int originTimezone;
	private int flightFrequency;
	private RouteTimes routeTimes;
	
	private String originAirport;
	private int outboundFlightLevel;
	
	private String destinationAirport;
	private int returnFlightLevel;
	
	private double distance;

	public FlightplanAircraft getFlightplanAircraft() {
		return flightplanAircraft;
	}

	public void setFlightplanAircraft(FlightplanAircraft flightplanAircraft) {
		this.flightplanAircraft = flightplanAircraft;
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

	public RouteTimes getRouteTimes() {
		return routeTimes;
	}

	public void setRouteTimes(RouteTimes routeTimes) {
		this.routeTimes = routeTimes;
	}

	public String getOriginAirport() {
		return originAirport;
	}

	public void setOriginAirport(String originAirport) {
		this.originAirport = originAirport;
	}

	public int getOutboundFlightLevel() {
		return outboundFlightLevel;
	}

	public void setOutboundFlightLevel(int outboundFlightLevel) {
		this.outboundFlightLevel = outboundFlightLevel;
	}

	public String getDestinationAirport() {
		return destinationAirport;
	}

	public void setDestinationAirport(String destinationAirport) {
		this.destinationAirport = destinationAirport;
	}

	public int getReturnFlightLevel() {
		return returnFlightLevel;
	}

	public void setReturnFlightLevel(int returnFlightLevel) {
		this.returnFlightLevel = returnFlightLevel;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}
	
	
}
