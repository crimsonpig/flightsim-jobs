package com.crimsonpig.fs.jobs;

import org.springframework.batch.core.launch.support.CommandLineJobRunner;

public class FullRouteDefinitionsJobRun {

	public static void main(String[] args) throws Exception{
		String args2[] = {"/FullRouteDefinitionsJob.xml", "FullRouteDefinitionsJob"};
		CommandLineJobRunner.main(args2);
	}
}
