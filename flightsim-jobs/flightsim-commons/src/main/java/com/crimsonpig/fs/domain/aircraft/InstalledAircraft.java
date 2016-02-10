package com.crimsonpig.fs.domain.aircraft;

public class InstalledAircraft {

	private String title;
	private String aircraftFolder;
	private String airline;
	private String atcType;
	private String atcModel;
	private String uiManufacturer;
	private String uiType;
	private String uiVariation;
	
	public InstalledAircraft(){
		this.airline = "";
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAircraftFolder() {
		return aircraftFolder;
	}

	public void setAircraftFolder(String aircraftFolder) {
		this.aircraftFolder = aircraftFolder;
	}

	public String getAirline() {
		return airline;
	}

	public void setAirline(String airline) {
		this.airline = airline;
	}

	public String getAtcType() {
		return atcType;
	}

	public void setAtcType(String atcType) {
		this.atcType = atcType;
	}

	public String getAtcModel() {
		return atcModel;
	}

	public void setAtcModel(String atcModel) {
		this.atcModel = atcModel;
	}

	public String getUiManufacturer() {
		return uiManufacturer;
	}

	public void setUiManufacturer(String uiManufacturer) {
		this.uiManufacturer = uiManufacturer;
	}

	public String getUiType() {
		return uiType;
	}

	public void setUiType(String uiType) {
		this.uiType = uiType;
	}

	public String getUiVariation() {
		return uiVariation;
	}

	public void setUiVariation(String uiVariation) {
		this.uiVariation = uiVariation;
	}
	
	
}
