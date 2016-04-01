package com.crimsonpig.fs.config;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.support.CompositeItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.UrlResource;

import com.crimsonpig.fs.domain.route.*;
import com.crimsonpig.fs.lineaggregators.FullRouteDefinitionLineAggregator;
import com.crimsonpig.fs.mappers.SimpleRouteDefinitionLineMapper;
import com.crimsonpig.fs.processors.FullRouteDefinitionsProcessor;
import com.crimsonpig.fs.service.retrieve.RetrieveAirportService;
import com.crimsonpig.fs.service.retrieve.RetrieveFlightplanAircraftService;

@Configuration
public class FullRouteDefinitionsStepConfig {

	@Autowired
	private DataSource domainDataSource;
	
	@Bean(name = "routesReader")
	public ItemReader<SimpleRouteDefinition> routesReader(){
		FlatFileItemReader<SimpleRouteDefinition> reader = new FlatFileItemReader<SimpleRouteDefinition>();
		reader.setResource(new ClassPathResource("data/Airwave-Routes.csv"));
		reader.setLineMapper(new SimpleRouteDefinitionLineMapper());
		return reader;
	}
	
	@Bean(name = "fullRouteDefinitionsProcessor")
	public ItemProcessor<SimpleRouteDefinition,FullRouteDefinition> processor(){
		CompositeItemProcessor<SimpleRouteDefinition,FullRouteDefinition> compositeProcessor = new CompositeItemProcessor<SimpleRouteDefinition,FullRouteDefinition>();
		compositeProcessor.setDelegates(getItemProcessors());
		return compositeProcessor;
		
	}
	
	private List<ItemProcessor<?, ?>> getItemProcessors() {
		List<ItemProcessor<?, ?>> processors = new ArrayList<ItemProcessor<?, ?>>();
		processors.add(fullRouteDefinitionsProcessor());
		return processors;
	}
	
	private FullRouteDefinitionsProcessor fullRouteDefinitionsProcessor() {
		FullRouteDefinitionsProcessor processor = new FullRouteDefinitionsProcessor();
		RetrieveAirportService airportService = new RetrieveAirportService();
		airportService.setDataSource(domainDataSource);		
		processor.setAirportService(airportService);
		
		RetrieveFlightplanAircraftService aircraftService = new RetrieveFlightplanAircraftService();
		aircraftService.setDataSource(domainDataSource);
		processor.setAircraftService(aircraftService);
		
		return processor;
	}

	@Bean(name = "fullRoutesWriter")
	public ItemWriter<FullRouteDefinition> fullRoutesWriter() throws MalformedURLException{
		FlatFileItemWriter<FullRouteDefinition> writer = new FlatFileItemWriter<FullRouteDefinition>();
		writer.setShouldDeleteIfExists(true);
		writer.setResource(new UrlResource("file:./data/FULL-Airwave-Routes.txt"));
		writer.setLineAggregator(new FullRouteDefinitionLineAggregator());
		return writer;
	}

}