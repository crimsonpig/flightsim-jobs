package com.crimsonpig.fs.jobs;

import org.springframework.batch.core.launch.support.CommandLineJobRunner;

public class GenerateFlightPlansJobRun {

	public static void main(String[] args) throws Exception{
		String args2[] = {"/GenerateFlightplansJob.xml", "GenerateFlightplansJob"};
		CommandLineJobRunner.main(args2);
	}
}