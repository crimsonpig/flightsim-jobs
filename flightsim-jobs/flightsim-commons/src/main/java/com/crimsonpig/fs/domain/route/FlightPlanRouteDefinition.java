package com.crimsonpig.fs.domain.route;

import com.crimsonpig.fs.domain.aircraft.FlightplanAircraft;

public class FlightPlanRouteDefinition {

	private FlightplanAircraft fpAircraft;
	private int originTimezone;
	private int flightFrequency;
	
	private String originAirport;
	private int outboundFlightLevel;
	
	private String destinationAirport;
	private int returnFlightLevel;
	
	private double distance;
	
	private long routeTime;

	public FlightPlanRouteDefinition(){
		this.fpAircraft = new FlightplanAircraft();
	}
	
	public FlightplanAircraft getFlightplanAircraft() {
		return fpAircraft;
	}

	public void setFlightplanAircraft(FlightplanAircraft flightplanAircraft) {
		this.fpAircraft = flightplanAircraft;
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
	

	public String getAircraftTitle() {
		return fpAircraft.getTitle();
	}

	public void setAircraftTitle(String aircraftTitle) {
		fpAircraft.setTitle(aircraftTitle);
	}
	
	public int getGroundspeed() {
		return fpAircraft.getGroundspeed();
	}

	public void setGroundspeed(int groundspeed) {
		fpAircraft.setGroundspeed(groundspeed);
	}

	public int getAircraftNumber(){
		return fpAircraft.getAcId();
	}
	
	public void setAircraftNumber(int acId) {
		fpAircraft.setAcId(acId);
	}

	public String getAirline() {
		return fpAircraft.getAirline();
	}

	public void setAirline(String airline) {
		fpAircraft.setAirline(airline);
	}

	public String getAircraftModel() {
		return fpAircraft.getAtcModel();
	}

	public void setAircraftModel(String aircraftModel) {
		fpAircraft.setAtcModel(aircraftModel);
	}

	public long getRouteTime() {
		return routeTime;
	}

	public void setRouteTime(long routeTimeInSeconds) {
		this.routeTime = routeTimeInSeconds;
	}	
	

}
