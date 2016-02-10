package com.crimsonpig.fs.processors;

import java.util.List;

import org.springframework.batch.item.ItemProcessor;

import com.crimsonpig.fs.domain.aircraft.InstalledAircraft;
import com.crimsonpig.fs.domain.aircraft.config.AircraftConfigFile;
import com.crimsonpig.fs.parsers.AircraftConfigFileParser;

public class InstalledAircraftProcessor implements
		ItemProcessor<AircraftConfigFile, List<InstalledAircraft>> {

	public List<InstalledAircraft> process(AircraftConfigFile item) throws Exception {
		AircraftConfigFileParser aircraftConfigParser = new AircraftConfigFileParser();
		aircraftConfigParser.setAircraftConfigFile(item);
		List<InstalledAircraft> installedAircraftList = aircraftConfigParser.parseLinesIntoInstalledAircraft();
//		checkForNulls(installedAircraftList);
		return installedAircraftList;
	}
	
//	private void checkForNulls(List<InstalledAircraft> installedAircraftList) {
//	for(InstalledAircraft aircraft : installedAircraftList){
//		if(aircraft.getTitle() == null){
//			throw new NullPointerException();
//		}
//	}
//}
}
