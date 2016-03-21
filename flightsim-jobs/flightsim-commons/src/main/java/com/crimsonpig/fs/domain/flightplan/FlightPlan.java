package com.crimsonpig.fs.domain.flightplan;

import java.util.ArrayList;
import java.util.List;

public class FlightPlan {

	private int aircraftNumber;
	private String aircraftTitle;
	private String airline;
	private String registration = "N700MS";
	private int percentage = 90;
	private Repetition repetition = Repetition.TWENTY_FOUR_HOURS;
	private FlightRules flightRules = FlightRules.IFR;
	private List<Leg> legs;
	
	public FlightPlan(){
		this.legs = new ArrayList<Leg>(2);
	}
	
	public String getAircraftTitle() {
		return aircraftTitle;
	}
	public void setAircraftTitle(String aircraftTitle) {
		this.aircraftTitle = aircraftTitle;
	}
	public String getAirline() {
		return airline;
	}
	public void setAirline(String airline) {
		this.airline = airline;
	}

	public void setLegs(List<Leg> legs) {
		this.legs = legs;
	}
	
	public List<Leg> getLegs(){
		return legs;
	}

	public int getAircraftNumber() {
		return aircraftNumber;
	}

	public void setAircraftNumber(int aircraftNumber) {
		this.aircraftNumber = aircraftNumber;
	}

	public String getRegistration() {
		return registration;
	}

	public void setRegistration(String registration) {
		this.registration = registration;
	}

	public int getPercentage() {
		return percentage;
	}

	public void setPercentage(int percentage) {
		this.percentage = percentage;
	}

	public Repetition getRepetition() {
		return repetition;
	}

	public void setRepetition(Repetition repetition) {
		this.repetition = repetition;
	}

	public FlightRules getFlightRules() {
		return flightRules;
	}

	public void setFlightRules(FlightRules flightRules) {
		this.flightRules = flightRules;
	}
}
