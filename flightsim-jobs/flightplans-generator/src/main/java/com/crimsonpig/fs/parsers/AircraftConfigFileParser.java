package com.crimsonpig.fs.parsers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.crimsonpig.fs.domain.aircraft.InstalledAircraft;
import com.crimsonpig.fs.domain.aircraft.config.AircraftConfigFile;
import com.crimsonpig.fs.domain.aircraft.config.AircraftConfigFileContents;

public class AircraftConfigFileParser {


	private Pattern configurationProperty = Pattern.compile("(.+)=(.*)");
	private AircraftConfigFile aircraftConfigFile;
	private AircraftConfigFileContents configFileContents;

	public AircraftConfigFileParser(){
		this.configFileContents = new AircraftConfigFileContents();
	}

	public void setAircraftConfigFile(AircraftConfigFile file) {
		this.aircraftConfigFile = file;
	}

	public List<InstalledAircraft> parseLinesIntoInstalledAircraft() throws IOException {
		configFileContents.clear();
		parseFileIntoContents();
		return buildInstalledAircraftList();
	}

	private void parseFileIntoContents() throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(aircraftConfigFile.getAircraftConfigFilePath()));
		String fileLine = reader.readLine();
		String currentSection = "";
		while(fileLine != null){
			if(isHeaderLine(fileLine)){
				if(isRelevantHeaderLine(fileLine)){
					currentSection = parseHeaderLine(fileLine);
					configFileContents.addSection(currentSection);
				}
				else{
					currentSection = "";
				}
			}
			else if(!currentSection.isEmpty() && isPropertyLine(fileLine)){
				Matcher propertyMatcher = configurationProperty.matcher(fileLine);
				if(propertyMatcher.matches()){
					String key = propertyMatcher.group(1);
					String value = propertyMatcher.group(2);
					String valueWithoutComments = value.replaceAll("//.*", "");
					configFileContents.getSection(currentSection).put(key.trim(), valueWithoutComments.trim());
				}
			}
			fileLine = reader.readLine();
		}
		reader.close();
	}

	private boolean isHeaderLine(String fileLine) {
		return fileLine.startsWith("[");
	}

	private boolean isRelevantHeaderLine(String fileLine) {
		return (fileLine.startsWith("[fltsim") && !fileLine.equals("[fltsim.x]")) || fileLine.startsWith("[General]");
	}

	private String parseHeaderLine(String fileLine) {
		return fileLine.substring(1, fileLine.indexOf("]"));
	}

	private boolean isPropertyLine(String fileLine) {
		return fileLine.contains("=");
	}
	
	private List<InstalledAircraft> buildInstalledAircraftList() {
		Set<String> configSections = configFileContents.getConfigSections();
		List<InstalledAircraft> installedAircraftList = new ArrayList<InstalledAircraft>(configSections.size());
		for(String configSection : configSections){
			InstalledAircraft newAircraft = new InstalledAircraft();
			newAircraft = populateFltsimProperties(configSection, newAircraft);
			newAircraft = populateGeneralProperties(newAircraft);
			newAircraft.setAircraftFolder(getCurrentAircraftFolder());
			installedAircraftList.add(newAircraft);
		}
		return installedAircraftList;
	}

	private InstalledAircraft populateFltsimProperties(String configSection, 
			InstalledAircraft newAircraft) {
		Map<String,String> fltSimSection = configFileContents.getSection(configSection);
		newAircraft.setTitle(fltSimSection.get("title"));
		String airline = fltSimSection.get("atc_airline");
		if(airline == null){
			airline = "";
		}
		newAircraft.setAirline(airline);
		newAircraft.setUiManufacturer(fltSimSection.get("ui_manufacturer"));
		newAircraft.setUiType(fltSimSection.get("ui_type"));
		newAircraft.setUiVariation(fltSimSection.get("ui_variation"));
		return newAircraft;
	}

	private InstalledAircraft populateGeneralProperties(
			InstalledAircraft newAircraft) {
		Map<String,String> generalSection = configFileContents.getSection("General");
		newAircraft.setAtcType(generalSection.get("atc_type"));
		newAircraft.setAtcModel(generalSection.get("atc_model"));
		return newAircraft;
	}

	private String getCurrentAircraftFolder() {
		File aircraftCfgFile = new File(aircraftConfigFile.getAircraftConfigFilePath());
		String aircraftFolderName = aircraftCfgFile.getParentFile().getName();
		return aircraftFolderName;
	}

}
