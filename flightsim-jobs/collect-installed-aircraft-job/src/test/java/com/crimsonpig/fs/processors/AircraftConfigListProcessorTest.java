package com.crimsonpig.fs.processors;

import static org.junit.Assert.assertEquals;

import java.io.File;

import org.junit.Test;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.core.io.UrlResource;

import com.crimsonpig.fs.domain.aircraft.config.AircraftConfigFile;

public class AircraftConfigListProcessorTest {

	@Test
	public void testAircraftConfigListProcessor() throws Exception{
		ItemProcessor<File, AircraftConfigFile> processor = new AircraftConfigListProcessor();
		File aircraftFolder = new UrlResource("file:src/test/resources/AIA_767_200_GE").getFile();
		AircraftConfigFile aircraftCfg = processor.process(aircraftFolder);
		assertEquals("AIA_767_200_GE", aircraftCfg.getAircraftName());
		String expectedPath = "src" + File.separator + "test" + File.separator + "resources" + File.separator + "AIA_767_200_GE" + File.separator + "Aircraft.cfg";
		assertEquals(expectedPath, aircraftCfg.getAircraftConfigFilePath());
	}
	
}
