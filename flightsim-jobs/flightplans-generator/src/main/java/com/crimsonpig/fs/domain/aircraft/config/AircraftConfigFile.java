package com.crimsonpig.fs.domain.aircraft.config;

public class AircraftConfigFile {
	private String aircraftName;
	private String aircraftConfigFilePath;
	
	public AircraftConfigFile(){
		
	}

	public String getAircraftName() {
		return aircraftName;
	}

	public void setAircraftName(String aircraftName) {
		this.aircraftName = aircraftName;
	}

	public String getAircraftConfigFilePath() {
		return aircraftConfigFilePath;
	}

	public void setAircraftConfigFilePath(String aircraftConfigFilePath) {
		this.aircraftConfigFilePath = aircraftConfigFilePath;
	}
	
	
}
