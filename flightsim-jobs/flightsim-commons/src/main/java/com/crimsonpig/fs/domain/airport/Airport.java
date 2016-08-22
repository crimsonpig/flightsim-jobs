package com.crimsonpig.fs.domain.airport;

public class Airport {

	private String identifier;
	private double latitudeDegrees;
	private double longitudeDegrees;
	private double altitude;
	private Airspace airspace;
	private int approachFrequencies;
	private double trafficScalar;
	private String country;
	
	public Airport() {

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
	
	
}
