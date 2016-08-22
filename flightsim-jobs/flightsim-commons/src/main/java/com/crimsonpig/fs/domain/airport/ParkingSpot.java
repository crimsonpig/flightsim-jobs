package com.crimsonpig.fs.domain.airport;

public class ParkingSpot {

	private String airportIdentifier;
	private double radius;
	private ParkingType parkingType;
	
	public ParkingSpot() {

	}

	public String getAirportIdentifier() {
		return airportIdentifier;
	}

	public void setAirportIdentifier(String airportIdentifier) {
		this.airportIdentifier = airportIdentifier;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public ParkingType getParkingType() {
		return parkingType;
	}

	public void setParkingType(ParkingType parkingType) {
		this.parkingType = parkingType;
	}

}
