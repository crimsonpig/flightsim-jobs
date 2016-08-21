package com.crimsonpig.fs.domain.route;

import com.crimsonpig.fs.domain.aircraft.FlightplanAircraft;
import com.crimsonpig.fs.domain.airport.ConvertedFS9Airport;

public class FullRouteDefinition {
	
	private int originTimezone;
	private int flightFrequency;
	private int lowestFlightLevel;
	private FlightplanAircraft fpAircraft;
	private ConvertedFS9Airport origin;
	private ConvertedFS9Airport destination;

	public FullRouteDefinition(){
		this.fpAircraft = new FlightplanAircraft();
		this.origin = new ConvertedFS9Airport();
		this.destination = new ConvertedFS9Airport();
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

	public FlightplanAircraft getFlightplanAircraft() {
		return fpAircraft;
	}

	public void setFlightplanAircraft(FlightplanAircraft fpAircraft) {
		this.fpAircraft = fpAircraft;
	}

	public ConvertedFS9Airport getOrigin() {
		return origin;
	}

	public void setOrigin(ConvertedFS9Airport origin) {
		this.origin = origin;
	}

	public ConvertedFS9Airport getDestination() {
		return destination;
	}

	public void setDestination(ConvertedFS9Airport destination) {
		this.destination = destination;
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

	public String getOriginAirport() {
		return origin.getIdentifier();
	}

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

	public String getDestinationAirport() {
		return destination.getIdentifier();
	}

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
	
}
