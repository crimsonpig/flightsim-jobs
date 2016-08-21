package com.crimsonpig.fs.domain.airport;

/*Converted airport stores lat/lon in radians*/
public class ConvertedFS9Airport {
	
	private String identifier;
	private double latitudeRadians;
	private double longitudeRadians;
	private int elevation;
	
	public ConvertedFS9Airport(){
		
	}

	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public double getLatitudeRadians() {
		return latitudeRadians;
	}

	public void setLatitudeRadians(double latitudeRadians) {
		this.latitudeRadians = latitudeRadians;
	}

	public double getLongitudeRadians() {
		return longitudeRadians;
	}

	public void setLongitudeRadians(double longitudeRadians) {
		this.longitudeRadians = longitudeRadians;
	}

	public int getElevation() {
		return elevation;
	}

	public void setElevation(int elevation) {
		this.elevation = elevation;
	}
	
}
