package com.crimsonpig.fs.config;

import java.net.MalformedURLException;

import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.UrlResource;

import com.crimsonpig.fs.tasklet.DeleteFileTasklet;

@Configuration
public class CleanupPreStepConfig {

	@Bean(name = "deleteFullRouteDefinitions")
	public Tasklet deleteFullRouteDefinitionsTasklet() throws MalformedURLException{
		DeleteFileTasklet tasklet = new DeleteFileTasklet();
		tasklet.setFileToDelete(new UrlResource("file:./data/FULL-Airwave-Routes.txt"));
		return tasklet;
	}
	
}
