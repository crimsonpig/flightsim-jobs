package com.crimsonpig.fs.config;

import javax.sql.DataSource;

import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.crimsonpig.fs.tasklet.TruncateTableTasklet;

@Configuration
public class ClearTableTaskletStepConfig {

	@Autowired
	private DataSource domainDataSource;
	
	@Bean(name = "clearFlightplanAircraftTasklet")
	public Tasklet tasklet(){
		TruncateTableTasklet tasklet = new TruncateTableTasklet();
		tasklet.setDataSource(domainDataSource);
		tasklet.setTable("FLIGHTPLANAIRCRAFT");
		return tasklet;
	}
}
