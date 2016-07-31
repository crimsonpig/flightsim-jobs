package com.crimsonpig.fs.config;

import java.net.MalformedURLException;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.UrlResource;

import com.crimsonpig.fs.domain.route.FlightPlanRouteDefinition;
import com.crimsonpig.fs.domain.route.FullRouteDefinition;
import com.crimsonpig.fs.lineaggregators.FlightPlanRouteDefinitionLineAggregator;
import com.crimsonpig.fs.mappers.FullRouteDefinitionLineMapper;
import com.crimsonpig.fs.processors.FlightPlanRouteDefinitionsProcessor;
import com.crimsonpig.fs.service.DistanceAndHeadingService;
import com.crimsonpig.fs.service.FlightLevelService;
import com.crimsonpig.fs.service.FlightPlanRouteDefinitionsService;
import com.crimsonpig.fs.service.RouteTimesService;

@Configuration
public class FlightPlanRouteDefinitionsStepConfig {
	
	@Autowired
	private BatchPropertiesConfig batchProperties;
	
	@Bean(name = "fullRoutesReader")
	public ItemReader<FullRouteDefinition> routesReader() throws MalformedURLException{
		FlatFileItemReader<FullRouteDefinition> reader = new FlatFileItemReader<FullRouteDefinition>();
		reader.setResource(new UrlResource(batchProperties.getProperty("full.routes.file")));
		reader.setLineMapper(new FullRouteDefinitionLineMapper());
		return reader;
	}

	@Bean(name = "flightPlanRouteDefinitionsProcessor")
	public ItemProcessor<FullRouteDefinition,FlightPlanRouteDefinition> processor(){
		FlightPlanRouteDefinitionsProcessor processor = new FlightPlanRouteDefinitionsProcessor();
		processor.setDistanceAndHeading(new DistanceAndHeadingService());
		processor.setFlightLevelService(new FlightLevelService());
		processor.setRouteDefinitionsService(new FlightPlanRouteDefinitionsService());
		processor.setRouteTimesService(new RouteTimesService());
		return processor;
	}
	
	@Bean(name = "flightPlanRoutesWriter")
	public ItemWriter<FlightPlanRouteDefinition> fullRoutesWriter() throws MalformedURLException{
		FlatFileItemWriter<FlightPlanRouteDefinition> writer = new FlatFileItemWriter<FlightPlanRouteDefinition>();
		writer.setShouldDeleteIfExists(true);
		writer.setResource(new UrlResource(batchProperties.getProperty("flightplan.routes.file")));
		writer.setLineAggregator(new FlightPlanRouteDefinitionLineAggregator());
		return writer;
	}
}
