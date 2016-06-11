package com.crimsonpig.fs.service.retrieve;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.crimsonpig.fs.domain.aircraft.FlightplanAircraft;
import com.crimsonpig.fs.exception.EntityNotFoundException;
import com.crimsonpig.fs.readers.*;

public class RetrieveFlightplanAircraftServiceTest {

	private RetrieveFlightplanAircraftService retrieveService;
	
	@Before
	public void setUp(){
		retrieveService = new RetrieveFlightplanAircraftService();
	}
	
	
	@Test
	public void testAircraftNotFound(){
		retrieveService.setDatabaseReader(new EmptyFlightplanAircraftReader());
		String airline = "Southwest";
		String aircraft = "A320";
		try {
			retrieveService.retrieveInstalledAircraftFromAirlineAndModel(airline, aircraft);
			fail();
		} catch(EntityNotFoundException e){
			String expected = "Entity : airline = Southwest, model = A320 not found in database! ";
			assertEquals(expected, e.getMessage());
		}
	}
	
	@Test
	public void testMoreThanOneAircraftFound(){
		retrieveService.setDatabaseReader(new MoreThanOneFlightplanAircraftReader());
		String airline = "Southwest";
		String aircraft = "B737";
		try {
			retrieveService.retrieveInstalledAircraftFromAirlineAndModel(airline, aircraft);
			fail();
		} catch(RuntimeException e){
			String expected = "More than one aircraft found for airline = Southwest and model = B737";
			assertEquals(expected, e.getMessage());
		}
	}
	
	@Test
	public void testAircraftFound(){
		retrieveService.setDatabaseReader(new SingleFlightplanAircraftReader());
		String airline = "Southwest";
		String aircraft = "B737";
		FlightplanAircraft found = retrieveService.retrieveInstalledAircraftFromAirlineAndModel(airline, aircraft);
		assertEquals("Southwest", found.getAirline());
		assertEquals("B737", found.getAtcModel());
		assertEquals("Boeing 737-700 Southwest Newest Colors", found.getTitle());
		assertEquals(430, found.getGroundspeed());
		
	}
	
}
