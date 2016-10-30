package com.crimsonpig.fs.config;

import java.net.MalformedURLException;

import javax.sql.DataSource;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemStreamReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.UrlResource;

import com.crimsonpig.fs.domain.airport.Airport;
import com.crimsonpig.fs.mappers.AirportLineMapper;
import com.crimsonpig.fs.readers.MultilineFS10AirportReader;

@Configuration
public class LoadAirportsStep {

	@Autowired
	private DataSource domainDataSource;
	
	@Autowired
	private BatchPropertiesConfig batchProperties;

	@Bean
	public ItemReader<Airport> multilineAirportReader() throws MalformedURLException{
		MultilineFS10AirportReader reader = new MultilineFS10AirportReader(delegateReader());
		return reader;
	}
	
	public ItemStreamReader<FieldSet> delegateReader() throws MalformedURLException {
		FlatFileItemReader<FieldSet> reader = new FlatFileItemReader<FieldSet>();
		reader.setResource(new UrlResource(batchProperties.getProperty("fs10.airports.filename")));
		reader.setLineMapper(new AirportLineMapper());
		return reader;
	}
	
	@Bean
	public ItemWriter<Airport> airportDatabaseWriter(){
		JdbcBatchItemWriter<Airport> writer = new JdbcBatchItemWriter<Airport>();
		writer.setAssertUpdates(true);
		writer.setDataSource(domainDataSource);
		writer.setItemSqlParameterSourceProvider(itemSqlParameterSourceProvider);
		writer.setSql("");
		return writer;
	}
}
