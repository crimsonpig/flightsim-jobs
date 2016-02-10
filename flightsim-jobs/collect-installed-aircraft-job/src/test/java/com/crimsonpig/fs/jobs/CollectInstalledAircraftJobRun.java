package com.crimsonpig.fs.jobs;

import org.springframework.batch.core.launch.support.CommandLineJobRunner;

public class CollectInstalledAircraftJobRun {

	public static void main(String[] args) throws Exception{
		String args2[] = {"/CollectInstalledAircraftJob.xml", "CollectInstalledAircraftJob"};
		CommandLineJobRunner.main(args2);
	}
}
