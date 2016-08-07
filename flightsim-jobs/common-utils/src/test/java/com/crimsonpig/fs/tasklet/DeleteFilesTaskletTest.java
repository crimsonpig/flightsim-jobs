package com.crimsonpig.fs.tasklet;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

public class DeleteFilesTaskletTest {

	
	private DeleteFilesTasklet deleteFilesTasklet;
	
	private static final String AIRCRAFT_FILE_PATH = "AircraftAirwave.txt";
	
	private static final String FULL_ROUTES_FILE_PATH = "./FULL-Airwave-Routes.txt";
	
	private static final String FLIGHTPLAN_ROUTES_FILE_PATH = "./Airwave-Flightplan-Routes.txt";
	
	private File flightplanRoutes = new File(FLIGHTPLAN_ROUTES_FILE_PATH);
	private File fullRoutes = new File(FULL_ROUTES_FILE_PATH);
	private File aircraft = new File(AIRCRAFT_FILE_PATH);
	
	@Before
	public void setUp() throws IOException{
		deleteFilesTasklet = new DeleteFilesTasklet();
		flightplanRoutes.createNewFile();
		fullRoutes.createNewFile();
		aircraft.createNewFile();
	}
	
	@Test
	public void testDeleteTwoFiles(){
		try {
			deleteFilesTasklet.setFilesToDelete(filesToDelete());
			assertTrue(flightplanRoutes.exists());
			assertTrue(fullRoutes.exists());
			assertTrue(aircraft.exists());
			RepeatStatus status = deleteFilesTasklet.execute(null, null);
			assertEquals(RepeatStatus.FINISHED, status);
			assertFalse(flightplanRoutes.exists());
			assertFalse(fullRoutes.exists());
			assertFalse(aircraft.exists());
			
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
		
	}
	
	
	private List<Resource> filesToDelete() throws MalformedURLException{
		List<Resource> files = new ArrayList<Resource>(2);
		files.add(new UrlResource("file:" + FLIGHTPLAN_ROUTES_FILE_PATH));
		files.add(new UrlResource("file:" + FULL_ROUTES_FILE_PATH));
		files.add(new UrlResource("file:" + AIRCRAFT_FILE_PATH));
		return files;
	}
	
}
