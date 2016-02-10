package com.crimsonpig.fs.domain.flightplan;

import java.time.LocalTime;

public class Leg {
	private LocalTime departureTime;
	private LocalTime arrivalTime;
	private int flightLevel;
	private CallBy fOrR;
	private int flightNumber;
	private String arrivalAirport;
	private String departureAirport;
	private double heading;
	private double distance;
	
	public double getHeading() {
		return heading;
	}

	public void setHeading(double heading) {
		this.heading = heading;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public Leg(){
		
	}
	
	public LocalTime getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(LocalTime departureTime) {
		this.departureTime = departureTime;
	}
	public LocalTime getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(LocalTime arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public int getFlightLevel() {
		return flightLevel;
	}
	public void setFlightLevel(int flightLevel) {
		this.flightLevel = flightLevel;
	}
	public CallBy getfOrR() {
		return fOrR;
	}
	public void setfOrR(CallBy fOrR) {
		this.fOrR = fOrR;
	}
	public int getFlightNumber() {
		return flightNumber;
	}
	public void setFlightNumber(int flightNumber) {
		this.flightNumber = flightNumber;
	}
	public String getArrivalAirport() {
		return arrivalAirport;
	}
	public void setArrivalAirport(String arrivalAirport) {
		this.arrivalAirport = arrivalAirport;
	}
	public String getDepartureAirport() {
		return departureAirport;
	}
	public void setDepartureAirport(String departureAirport) {
		this.departureAirport = departureAirport;
	}
	
	
}
