package com.crimsonpig.fs.jobs;

import org.springframework.batch.core.launch.support.CommandLineJobRunner;

public class ConvertAirportsJobRun {

	public static void main(String[] args) throws Exception{
		String args2[] = {"/jobs/ConvertAirportsJob.xml", "ConvertAirportsJob"};
		CommandLineJobRunner.main(args2);
	}
}
