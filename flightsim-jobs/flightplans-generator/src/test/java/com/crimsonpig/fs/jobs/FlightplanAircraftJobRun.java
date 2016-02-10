package com.crimsonpig.fs.jobs;

import org.springframework.batch.core.launch.support.CommandLineJobRunner;

public class FlightplanAircraftJobRun {
	
	public static void main(String[] args) throws Exception{
		String args2[] = {"/jobs/FlightplanAircraftJob.xml", "FlightplanAircraftJob"};
		CommandLineJobRunner.main(args2);
	}
}
