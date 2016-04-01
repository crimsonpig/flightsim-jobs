package com.crimsonpig.fs.service.generate;

import static org.junit.Assert.*;

import org.junit.Test;

public class AircraftRegistrationGeneratorTest {

	@Test
	public void americanRegistrationTest(){
		AircraftRegistrationGenerator generator = new AircraftRegistrationGenerator();
		for(int i = 0; i < 10000; i++){
			String registration = generator.getRandomAmericanRegistration();
			assertEquals(6,registration.length());
			assertEquals('N',registration.charAt(0));
			String numericSection = registration.substring(1);
			int numericAsInt = Integer.parseInt(numericSection);
			assertTrue(numericAsInt <= 99999);
			assertTrue(numericAsInt >= 9999);
		}
	}
	
}
