package com.crimsonpig.fs.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FlightLevelServiceTest {

	
	@Test
	public void oddUpToEvenTest(){
		double heading = 326;
		int lowestFlightLevel = 330;
		FlightLevelService proposal = new FlightLevelService(heading, lowestFlightLevel);
		int actualFlightLevel = proposal.determineActualFlightLevel();
		assertEquals(340, actualFlightLevel);
	}
	
	@Test
	public void oddSameAsLowestTest(){
		double heading = 144;
		int lowestFlightLevel = 330;
		FlightLevelService proposal = new FlightLevelService(heading, lowestFlightLevel);
		int actualFlightLevel = proposal.determineActualFlightLevel();
		assertEquals(330, actualFlightLevel);
	}
	
	@Test
	public void evenUpToOddTest(){
		double heading = 144;
		int lowestFlightLevel = 340;
		FlightLevelService proposal = new FlightLevelService(heading, lowestFlightLevel);
		int actualFlightLevel = proposal.determineActualFlightLevel();
		assertEquals(350, actualFlightLevel);	
	}
	
	@Test
	public void evenSameAsLowestTest(){
		double heading = 348;
		int lowestFlightLevel = 340;
		FlightLevelService proposal = new FlightLevelService(heading, lowestFlightLevel);
		int actualFlightLevel = proposal.determineActualFlightLevel();
		assertEquals(340, actualFlightLevel);			
	}
}
