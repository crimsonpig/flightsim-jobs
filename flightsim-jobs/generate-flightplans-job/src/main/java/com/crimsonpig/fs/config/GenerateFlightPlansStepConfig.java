package com.crimsonpig.fs.config;

import java.net.MalformedURLException;
import java.util.List;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemStreamWriter;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.UrlResource;

import com.crimsonpig.fs.domain.flightplan.FlightPlan;
import com.crimsonpig.fs.lineaggregators.FlightPlanLineAggregator;
import com.crimsonpig.fs.mappers.FlightPlanRouteDefinitionLineMapper;
import com.crimsonpig.fs.processors.FlightPlanGenerator;
import com.crimsonpig.fs.writers.ListItemStreamWriter;
import com.crimsonpig.fs.domain.route.FlightPlanRouteDefinition;

@Configuration
public class GenerateFlightPlansStepConfig {

	@Autowired
	private BatchPropertiesConfig batchProperties;
	
	@Bean(name = "flightPlanRoutesReader")
	public ItemReader<FlightPlanRouteDefinition> reader() throws MalformedURLException{
		FlatFileItemReader<FlightPlanRouteDefinition> reader = new FlatFileItemReader<FlightPlanRouteDefinition>();
		reader.setResource(new UrlResource(batchProperties.getProperty("flightplan.routes.file")));
		reader.setLineMapper(new FlightPlanRouteDefinitionLineMapper());
		return reader;
	}
	
	@Bean(name = "flightPlanGenerator")
	public ItemProcessor<FlightPlanRouteDefinition,List<FlightPlan>> flightPlanGenerator(){
		return new FlightPlanGenerator();
	}

	@Bean(name = "flightPlansWriter")
	public ItemWriter<List<FlightPlan>> flightPlansWriter() throws MalformedURLException{
		ListItemStreamWriter<FlightPlan> writer = new ListItemStreamWriter<FlightPlan>();
		writer.setItemStreamWriter(singleFlightPlanWriter());
		return writer;
	}

	private ItemStreamWriter<FlightPlan> singleFlightPlanWriter() throws MalformedURLException{
		FlatFileItemWriter<FlightPlan> writer = new FlatFileItemWriter<FlightPlan>();
		writer.setResource(new UrlResource(batchProperties.getProperty("generated.flightplans.file")));
		writer.setLineAggregator(new FlightPlanLineAggregator());
		return writer;
	}
	
}
