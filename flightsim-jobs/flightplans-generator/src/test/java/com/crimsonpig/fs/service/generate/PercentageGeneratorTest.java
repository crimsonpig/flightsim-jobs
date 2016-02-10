package com.crimsonpig.fs.service.generate;

import static org.junit.Assert.*;

import org.junit.Test;

public class PercentageGeneratorTest {

	@Test
	public void testPercentageGenerator(){
		PercentageGenerator generator = new PercentageGenerator();
		for(int i=0; i < 1000000; i++){
			int percentage = generator.getRandomPercentage();
			assertTrue(percentage >= 1);
			assertTrue(percentage <= 99);
		}
	}
}
