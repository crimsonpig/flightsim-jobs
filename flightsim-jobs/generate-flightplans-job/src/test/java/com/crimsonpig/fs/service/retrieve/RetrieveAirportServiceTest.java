package com.crimsonpig.fs.service.retrieve;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import com.crimsonpig.fs.config.readers.*;
import com.crimsonpig.fs.domain.airport.ConvertedAirport;
import com.crimsonpig.fs.exception.EntityNotFoundException;

public class RetrieveAirportServiceTest {

	private RetrieveAirportService retrieveService;
	
	@Before
	public void setUp(){
		retrieveService = new RetrieveAirportService();
	}
	
	@Test
	public void testAirportNotFound(){
		retrieveService.setDatabaseReader(new EmptyConvertedAirportReader());
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
		retrieveService.setDatabaseReader(new SingleConvertedAirportReader());
		String identifier = "KLAX";
		ConvertedAirport found = retrieveService.retrieveAirport(identifier);
		assertEquals("KLAX", found.getIdentifier());
		assertEquals(0.592409021, found.getLatitudeRadians(), 0.00000000001);
		assertEquals(-2.06661077, found.getLongitudeRadians(), 0.00000000001);
		assertEquals(125, found.getElevation());
		
	}
	
}
