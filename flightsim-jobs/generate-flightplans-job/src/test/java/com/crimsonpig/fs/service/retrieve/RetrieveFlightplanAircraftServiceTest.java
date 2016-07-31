package com.crimsonpig.fs.service.retrieve;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.crimsonpig.fs.domain.aircraft.FlightplanAircraft;
import com.crimsonpig.fs.exception.EntityNotFoundException;
import com.crimsonpig.fs.stubs.FlightplanAircraftStubs;
import com.crimsonpig.fs.stubs.readers.*;

public class RetrieveFlightplanAircraftServiceTest {

	private RetrieveFlightplanAircraftService retrieveService;
	
	@Before
	public void setUp(){
		retrieveService = new RetrieveFlightplanAircraftService();
	}
	
	
	@Test
	public void testAircraftNotFound(){
		retrieveService.setDatabaseReader(new StubFlightplanAircraftReader());
		String title = "Airbus A320 Southwest";
		try {
			retrieveService.retrieveInstalledAircraftByTitle(title);
			fail();
		} catch(EntityNotFoundException e){
			String expected = "Entity : title = Airbus A320 Southwest not found in database! ";
			assertEquals(expected, e.getMessage());
		}
	}

	@Test
	public void testAircraftFound(){
		StubFlightplanAircraftReader reader = new StubFlightplanAircraftReader();
		reader.addAircraftToList(FlightplanAircraftStubs.getFirstFlightplanAircraft());
		retrieveService.setDatabaseReader(reader);
		String title = "Boeing 737-700 Southwest Newest Colors";
		FlightplanAircraft found = retrieveService.retrieveInstalledAircraftByTitle(title);
		assertEquals("Southwest", found.getAirline());
		assertEquals("B737", found.getAtcModel());
		assertEquals("Boeing 737-700 Southwest Newest Colors", found.getTitle());
		assertEquals(430, found.getGroundspeed());
		
	}
	
}
