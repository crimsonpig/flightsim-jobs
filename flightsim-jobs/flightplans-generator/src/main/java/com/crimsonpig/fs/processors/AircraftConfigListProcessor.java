package com.crimsonpig.fs.processors;

import java.io.File;
import java.io.FilenameFilter;

import org.springframework.batch.item.ItemProcessor;

import com.crimsonpig.fs.domain.aircraft.config.AircraftConfigFile;

public class AircraftConfigListProcessor implements
		ItemProcessor<File, AircraftConfigFile> {

	private FilenameFilter aircraftConfigFilenameFilter = new AircraftConfigFilenameFilter();
	
	public AircraftConfigFile process(File aircraftFolder) throws Exception {
		File[] aircraftConfigSearchResults = aircraftFolder.listFiles(aircraftConfigFilenameFilter);
		if(aircraftConfigSearchResults == null || aircraftConfigSearchResults.length == 0){
			return null;
		}
		else{
			AircraftConfigFile aircraftCfg = new AircraftConfigFile();
			aircraftCfg.setAircraftName(aircraftFolder.getName());
			aircraftCfg.setAircraftConfigFilePath(aircraftConfigSearchResults[0].getPath());
			return aircraftCfg;
		}
	}

	private class AircraftConfigFilenameFilter implements FilenameFilter {

		public boolean accept(File dir, String name) {
			return name.toUpperCase().equals("AIRCRAFT.CFG");
		}
		
	}
}
