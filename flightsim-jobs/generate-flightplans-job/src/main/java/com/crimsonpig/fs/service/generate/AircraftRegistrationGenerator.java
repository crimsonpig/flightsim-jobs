package com.crimsonpig.fs.service.generate;

import java.util.Random;

public class AircraftRegistrationGenerator {

	private Random random;

	public AircraftRegistrationGenerator(){
		random = new Random();
	}

	public String getRandomAmericanRegistration(){
		StringBuilder sb = new StringBuilder();
		int fiveDigits = random.nextInt((99999 - 9999) + 1) + 9999;
		sb.append("N");
		sb.append(fiveDigits);
		return sb.toString();
	}

}
