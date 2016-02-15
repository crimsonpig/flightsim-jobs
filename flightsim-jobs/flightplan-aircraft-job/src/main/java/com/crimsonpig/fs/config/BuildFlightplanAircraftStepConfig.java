package com.crimsonpig.fs.config;

import javax.sql.DataSource;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import com.crimsonpig.fs.domain.aircraft.FlightplanAircraft;
import com.crimsonpig.fs.domain.aircraft.RouteAircraft;
import com.crimsonpig.fs.mappers.RouteAircraftLineMapper;
import com.crimsonpig.fs.processors.FlightplanAircraftProcessor;
import com.crimsonpig.fs.service.retrieve.RetrieveInstalledAircraftService;

@Configuration
public class BuildFlightplanAircraftStepConfig {

	@Autowired
	private DataSource domainDataSource;
	
	@Bean(name = "routeAircraftReader")
	public ItemReader<RouteAircraft> reader(){
		FlatFileItemReader<RouteAircraft> reader = new FlatFileItemReader<RouteAircraft>();
		reader.setResource(new ClassPathResource("data/AircraftFSX1.txt"));
		reader.setLineMapper(new RouteAircraftLineMapper());
		return reader;
	}

	@Bean(name = "flightplanAircraftProcessor")
	public ItemProcessor<RouteAircraft,FlightplanAircraft> processor(){
		FlightplanAircraftProcessor processor = new FlightplanAircraftProcessor();
		RetrieveInstalledAircraftService installedAircraftService = new RetrieveInstalledAircraftService();
		installedAircraftService.setDataSource(domainDataSource);
		processor.setInstalledAircraftService(installedAircraftService);
		return processor;
	}

	@Bean(name = "flightplanAircraftWriter")
	public ItemWriter<FlightplanAircraft> writer(){
		JdbcBatchItemWriter<FlightplanAircraft> writer = new JdbcBatchItemWriter<FlightplanAircraft>();
		writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<FlightplanAircraft>());
		writer.setAssertUpdates(true);
		writer.setDataSource(domainDataSource);
		writer.setSql("INSERT INTO FLIGHTPLANAIRCRAFT(TITLE, GROUNDSPEED, AIRLINE, ATC_MODEL) VALUES(:title, :groundspeed, :airline, :atcModel)");
		return writer;
	}
	
}
