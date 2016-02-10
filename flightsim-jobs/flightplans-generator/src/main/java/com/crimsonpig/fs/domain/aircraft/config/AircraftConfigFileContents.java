package com.crimsonpig.fs.domain.aircraft.config;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AircraftConfigFileContents {

	private Map<String,Map<String,String>> contents;
	
	public AircraftConfigFileContents(){
		contents = new HashMap<String,Map<String,String>>(16);
	}
	
	public void addSection(String sectionHeader){
		Map<String,String> newSection = new HashMap<String,String>(16);
		contents.put(sectionHeader, newSection);
	}
	
	public Map<String,String> getSection(String sectionHeader){
		return contents.get(sectionHeader);
	}
	
	public void clear(){
		for(Map<String,String> section : contents.values()){
			section.clear();
		}
		contents.clear();
	}

	public Set<String> getConfigSections() {
		Set<String> toReturn = new HashSet<String>();
		toReturn.addAll(contents.keySet());
		toReturn.remove("General");
		return toReturn;
	}
	
	public String getPropertyValue(String sectionHeader, String property){
		return getSection(sectionHeader).get(property);
	}
}
