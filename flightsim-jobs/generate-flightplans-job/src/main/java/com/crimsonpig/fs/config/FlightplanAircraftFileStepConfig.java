package com.crimsonpig.fs.config;

import java.net.MalformedURLException;

import javax.sql.DataSource;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.UrlResource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import com.crimsonpig.fs.domain.aircraft.FlightplanAircraft;
import com.crimsonpig.fs.lineaggregators.FlightplanAiAircraftAggregator;

@Configuration
public class FlightplanAircraftFileStepConfig {
	
	@Autowired
	private DataSource domainDataSource;

	@Autowired
	private BatchPropertiesConfig batchProperties;
	
	@Bean(name = "flightplanAircraftReader")
	public ItemReader<FlightplanAircraft> reader(){
		JdbcCursorItemReader<FlightplanAircraft> reader = new JdbcCursorItemReader<FlightplanAircraft>();
		BeanPropertyRowMapper<FlightplanAircraft> rowMapper = new BeanPropertyRowMapper<FlightplanAircraft>();
		rowMapper.setMappedClass(FlightplanAircraft.class);
		reader.setRowMapper(rowMapper);
		reader.setVerifyCursorPosition(true);
		reader.setDataSource(domainDataSource);
		reader.setSql("SELECT AC_ID, TITLE, GROUNDSPEED FROM FLIGHTPLANAIRCRAFT");
		return reader;
	}

	@Bean(name = "flightplanAircraftFileWriter")
	public ItemWriter<FlightplanAircraft> writer() throws MalformedURLException{
		FlatFileItemWriter<FlightplanAircraft> writer = new FlatFileItemWriter<FlightplanAircraft>();
		writer.setResource(new UrlResource(batchProperties.getProperty("flightplan.aircraft.file")));
		writer.setLineAggregator(new FlightplanAiAircraftAggregator());
		return writer;
	}

}
