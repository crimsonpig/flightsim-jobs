package com.crimsonpig.fs.processors;
import static org.junit.Assert.*;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.crimsonpig.fs.domain.aircraft.InstalledAircraft;
import com.crimsonpig.fs.domain.aircraft.config.AircraftConfigFile;
import com.crimsonpig.fs.processors.InstalledAircraftProcessor;

@RunWith(JUnit4.class)
public class InstalledAircraftProcessorTest {

	@Test
	public void processAircraftConfigFile() throws Exception{
		AircraftConfigFile configFile = getTestAircraftConfigFile();
		InstalledAircraftProcessor processor = new InstalledAircraftProcessor();
		List<InstalledAircraft> aircrafts = processor.process(configFile);
		assertEquals(5, aircrafts.size());
		Map<String, InstalledAircraft> aircraftsMap = buildAircraftsMap(aircrafts);
		assertTrue(aircraftsMap.containsKey("Boeing 767-200_Delta_Widget"));
		assertTrue(aircraftsMap.containsKey("AIA 767-200 US Airways"));
		assertTrue(aircraftsMap.containsKey("Boeing 767-200_Delta (New Colors)"));
		assertTrue(aircraftsMap.containsKey("Continental 767-200"));
		assertTrue(aircraftsMap.containsKey("Boeing 767-200_American"));
		assertEquals("B762", aircraftsMap.get("Boeing 767-200_Delta_Widget").getAtcModel());
		assertEquals("BOEING", aircraftsMap.get("Boeing 767-200_Delta_Widget").getAtcType());
	}

	private AircraftConfigFile getTestAircraftConfigFile(){
		AircraftConfigFile configFile = new AircraftConfigFile();
		configFile.setAircraftName("AIA_767_200_GE");
		String srcTestResources = "src/test/resources";
		File aircraftCfg = new File(srcTestResources + "/data/Aircraft.cfg");
		configFile.setAircraftConfigFilePath(aircraftCfg.getPath());
		return configFile;
	}
	
	private Map<String, InstalledAircraft> buildAircraftsMap(
			List<InstalledAircraft> aircrafts) {
		Map<String,InstalledAircraft> aircraftsMap = new HashMap<String,InstalledAircraft>(aircrafts.size());
		for(InstalledAircraft aircraft : aircrafts){
			aircraftsMap.put(aircraft.getTitle(), aircraft);
		}
		return aircraftsMap;
	}


}
