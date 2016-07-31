package com.crimsonpig.fs.config;

import java.io.File;
import java.net.MalformedURLException;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.UrlResource;

import com.crimsonpig.fs.domain.aircraft.config.AircraftConfigFile;
import com.crimsonpig.fs.lineaggregators.AircraftConfigListLineAggregator;
import com.crimsonpig.fs.processors.AircraftConfigListProcessor;
import com.crimsonpig.fs.readers.AircraftDirectoryReader;

@Configuration
public class AircraftConfigListConfig {
	
	@Autowired
	private BatchPropertiesConfig batchProperties;

	@Bean(name="aircraftDirectoryReader")
	public ItemReader<File> aircraftDirectoryReader(){
		AircraftDirectoryReader reader = new AircraftDirectoryReader();
		reader.setInstalledAircraftDirectory(batchProperties.getProperty("fsx.airplanes.folder"));
		return reader;
	}
	
	@Bean(name="aircraftConfigListProcessor")
	public ItemProcessor<File, AircraftConfigFile> aircraftConfigListProcessor(){
		return new AircraftConfigListProcessor();
	}

	@Bean(name="aircraftConfigListWriter")
	public ItemWriter<AircraftConfigFile> aircraftConfigListWriter() throws MalformedURLException{
		FlatFileItemWriter<AircraftConfigFile> writer = new FlatFileItemWriter<AircraftConfigFile>();
		writer.setResource(new UrlResource(batchProperties.getProperty("aircraft.config.list.file")));
		writer.setLineAggregator(new AircraftConfigListLineAggregator());
		return writer;
	}

}
