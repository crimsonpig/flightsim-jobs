package com.crimsonpig.fs.service.generate;

import java.util.Random;

public class PercentageGenerator {

	private Random random;
	
	public PercentageGenerator(){
		random = new Random();
	}
	
	public int getRandomPercentage(){
		return random.nextInt(99) + 1;
	}
	
}
