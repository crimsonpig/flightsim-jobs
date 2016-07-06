package com.crimsonpig.fs.jobs;

import org.springframework.batch.core.launch.support.CommandLineJobRunner;

public class RunJob {

	public static void main(String[] args) throws Exception{
		String args2[] = {"/ConvertAirportsJob.xml", "ConvertAirportsJob"};
		CommandLineJobRunner.main(args2);
	}
}
