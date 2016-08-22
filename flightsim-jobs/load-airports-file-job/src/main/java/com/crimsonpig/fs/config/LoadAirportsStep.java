package com.crimsonpig.fs.config;

import java.net.MalformedURLException;

import javax.sql.DataSource;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.UrlResource;

@Configuration
public class LoadAirportsStep {

	@Autowired
	private DataSource domainDataSource;
	
	@Autowired
	private BatchPropertiesConfig batchProperties;

	@Bean(name = "delegateReader")
	public ItemReader delegateReader() throws MalformedURLException {
		FlatFileItemReader reader = new FlatFileItemReader();
		reader.setResource(new UrlResource(batchProperties.getProperty("fs10.airports.filename")));

		return reader;
	}
	
}
