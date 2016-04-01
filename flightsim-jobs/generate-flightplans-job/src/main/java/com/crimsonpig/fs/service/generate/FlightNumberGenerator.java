package com.crimsonpig.fs.service.generate;

import java.util.Random;

public class FlightNumberGenerator {

	private Random random;
	
	public FlightNumberGenerator(){
		random = new Random();
	}
	
	public int generateRandomFlightNumber(){
		return random.nextInt(9999);
	}
	
	
}
