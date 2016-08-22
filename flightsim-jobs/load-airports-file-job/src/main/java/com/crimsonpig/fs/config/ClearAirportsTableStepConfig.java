package com.crimsonpig.fs.config;

import javax.sql.DataSource;

import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.crimsonpig.fs.tasklet.TruncateTableTasklet;

@Configuration
public class ClearAirportsTableStepConfig {
	
	@Autowired
	private DataSource domainDataSource;

	/*
	 * This Tasklet appears to only clear the 'AIRPORTS' table, but
	 * the cascading deletes on the foreign keys mean that the 'RUNWAYS' and 
	 * 'PARKING_SPOTS' tables will also be cleared as well.
	 */
	
	@Bean(name = "truncateTableTasklet")
	public Tasklet tasklet() {
		TruncateTableTasklet tasklet = new TruncateTableTasklet();
		tasklet.setTable("AIRPORTS");
		tasklet.setDataSource(domainDataSource);
		return tasklet;
	}
}
