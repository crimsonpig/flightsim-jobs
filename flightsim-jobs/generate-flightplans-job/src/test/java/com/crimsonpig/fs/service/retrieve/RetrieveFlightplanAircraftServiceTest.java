package com.crimsonpig.fs.service.retrieve;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.crimsonpig.fs.exception.EntityNotFoundException;
import com.crimsonpig.fs.readers.EmptyFlightplanAircraftReader;

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
}
