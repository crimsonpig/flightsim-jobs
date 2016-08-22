package com.crimsonpig.fs.domain.airport;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Airport {

	private String identifier;
	private double latitudeDegrees;
	private double longitudeDegrees;
	private double altitude;
	private Airspace airspace;
	private int approachFrequencies;
	private double trafficScalar;
	private String country;
	private List<Runway> runways;
	private List<ParkingSpot> parkingSpots;
	
	public Airport() {
		runways = new ArrayList<Runway>(2);
		parkingSpots = new LinkedList<ParkingSpot>();
	}

	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public double getLatitudeDegrees() {
		return latitudeDegrees;
	}

	public void setLatitudeDegrees(double latitudeDegrees) {
		this.latitudeDegrees = latitudeDegrees;
	}

	public double getLongitudeDegrees() {
		return longitudeDegrees;
	}

	public void setLongitudeDegrees(double longitudeDegrees) {
		this.longitudeDegrees = longitudeDegrees;
	}

	public double getAltitude() {
		return altitude;
	}

	public void setAltitude(double altitude) {
		this.altitude = altitude;
	}

	public Airspace getAirspace() {
		return airspace;
	}

	public void setAirspace(Airspace airspace) {
		this.airspace = airspace;
	}

	public int getApproachFrequencies() {
		return approachFrequencies;
	}

	public void setApproachFrequencies(int approachFrequencies) {
		this.approachFrequencies = approachFrequencies;
	}

	public double getTrafficScalar() {
		return trafficScalar;
	}

	public void setTrafficScalar(double trafficScalar) {
		this.trafficScalar = trafficScalar;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public List<Runway> getRunways() {
		return runways;
	}

	public List<ParkingSpot> getParkingSpots() {
		return parkingSpots;
	}

	public void addRunway(Runway runway) {
		runway.setAirportIdentifier(getIdentifier());
		runways.add(runway);
	}

	public void addParkingSpot(ParkingSpot parking) {
		parking.setAirportIdentifier(getIdentifier());
		parkingSpots.add(parking);
	}
	
	
}
