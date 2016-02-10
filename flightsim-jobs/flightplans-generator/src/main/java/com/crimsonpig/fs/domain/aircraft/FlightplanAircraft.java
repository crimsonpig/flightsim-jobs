package com.crimsonpig.fs.domain.aircraft;

public class FlightplanAircraft extends AiAircraft {
	
	private String airline;
	private String atcModel;

	public FlightplanAircraft(){
		
	}

	public String getAirline() {
		return airline;
	}

	public void setAirline(String airline) {
		this.airline = airline;
	}

	public String getAtcModel() {
		return atcModel;
	}

	public void setAtcModel(String atcModel) {
		this.atcModel = atcModel;
	}
	
}
