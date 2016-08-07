package com.crimsonpig.fs.config;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;

import com.crimsonpig.fs.tasklet.DeleteFilesTasklet;

@Configuration
public class DeleteTemporaryFilesStepConfig {

	@Autowired
	private BatchPropertiesConfig batchProperties;
	
	
	@Bean(name = "deleteTempFilesTasklet")
	public Tasklet deleteTemporaryFilesTasklet() throws MalformedURLException{
		DeleteFilesTasklet tasklet = new DeleteFilesTasklet();
		List<Resource> filesToDelete = new ArrayList<Resource>(3);
		filesToDelete.add(new UrlResource(batchProperties.getProperty("full.routes.file")));
		filesToDelete.add(new UrlResource(batchProperties.getProperty("flightplan.routes.file")));
		filesToDelete.add(new UrlResource(batchProperties.getProperty("flightplan.aircraft.file")));
		return tasklet;
		
	}
	
}
