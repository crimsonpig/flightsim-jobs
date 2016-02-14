package com.crimsonpig.fs.config;

import javax.sql.DataSource;

import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import com.crimsonpig.fs.tasklet.TruncateTableTasklet;

public class ClearTableTaskletStepConfig {
	
	@Autowired
	private DataSource domainDataSource;

	@Bean(name = "truncateTableTasklet")
	public Tasklet tasklet() {
		TruncateTableTasklet tasklet = new TruncateTableTasklet();
		tasklet.setTable("CONVERTEDAIRPORTS");
		tasklet.setDataSource(domainDataSource);
		return tasklet;
	}
}
