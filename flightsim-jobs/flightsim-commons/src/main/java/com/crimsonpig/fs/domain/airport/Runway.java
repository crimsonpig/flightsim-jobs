package com.crimsonpig.fs.domain.airport;

public class Runway {
	
	private String airportIdentifier;
	private int length;
	private int width;
	private Surface surface;
	
	public Runway(){
		
	}

	public String getAirportIdentifier() {
		return airportIdentifier;
	}

	public void setAirportIdentifier(String airportIdentifier) {
		this.airportIdentifier = airportIdentifier;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public Surface getSurface() {
		return surface;
	}

	public void setSurface(Surface surface) {
		this.surface = surface;
	}
	
}
