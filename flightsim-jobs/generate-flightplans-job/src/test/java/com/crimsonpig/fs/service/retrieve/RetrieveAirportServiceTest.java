package com.crimsonpig.fs.service.retrieve;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import com.crimsonpig.fs.domain.airport.ConvertedFS9Airport;
import com.crimsonpig.fs.exception.EntityNotFoundException;
import com.crimsonpig.fs.stubs.ConvertedAirportStubs;
import com.crimsonpig.fs.stubs.readers.*;

public class RetrieveAirportServiceTest {

	private RetrieveAirportService retrieveService;
	
	@Before
	public void setUp(){
		retrieveService = new RetrieveAirportService();
	}
	
	@Test
	public void testAirportNotFound(){
		retrieveService.setDatabaseReader(new StubConvertedAirportReader());
		String identifier = "L01";
		try {
			retrieveService.retrieveAirport(identifier);
			fail();
		} catch(EntityNotFoundException e){
			String expected = "Entity : L01 not found in database! ";
			assertEquals(expected, e.getMessage());
		}
	}
	
	@Test
	public void testAirportFound(){
		StubConvertedAirportReader reader = new StubConvertedAirportReader();
		reader.addAirportToRetrieve(ConvertedAirportStubs.getLAXAirport());
		retrieveService.setDatabaseReader(reader);
		String identifier = "KLAX";
		ConvertedFS9Airport found = retrieveService.retrieveAirport(identifier);
		assertEquals("KLAX", found.getIdentifier());
		assertEquals(0.592409021, found.getLatitudeRadians(), 0.00000000001);
		assertEquals(-2.06661077, found.getLongitudeRadians(), 0.00000000001);
		assertEquals(125, found.getElevation());
		
	}
	
}
