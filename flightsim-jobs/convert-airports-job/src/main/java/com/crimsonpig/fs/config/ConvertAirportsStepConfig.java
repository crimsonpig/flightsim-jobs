package com.crimsonpig.fs.config;

import java.net.MalformedURLException;

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
import org.springframework.core.env.Environment;
import org.springframework.core.io.UrlResource;

import com.crimsonpig.fs.domain.airport.Airport;
import com.crimsonpig.fs.domain.airport.ConvertedAirport;
import com.crimsonpig.fs.mappers.AirportLineMapper;
import com.crimsonpig.fs.processors.AirportProcessor;

@Configuration
public class ConvertAirportsStepConfig {

	@Autowired
	private DataSource domainDataSource;
	
	@Autowired
	private BatchPropertiesConfig batchProperties;

	@Bean(name = "airportsFileReader")
	public ItemReader<Airport> reader() throws MalformedURLException {
		FlatFileItemReader<Airport> reader = new FlatFileItemReader<Airport>();
		reader.setResource(new UrlResource(batchProperties.getProperty("convert.airports.input.filename")));
		reader.setLineMapper(new AirportLineMapper());
		return reader;
	}

	@Bean(name = "airportLatLonDecimalConverter")
	public ItemProcessor<Airport,ConvertedAirport> processor(){
		return new AirportProcessor();
	}

	@Bean(name = "convertedAirportsWriter")
	public ItemWriter<ConvertedAirport> writer() {
		JdbcBatchItemWriter<ConvertedAirport> writer = new JdbcBatchItemWriter<ConvertedAirport>();
		writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<ConvertedAirport>());
		writer.setAssertUpdates(true);
		writer.setDataSource(domainDataSource);
		writer.setSql("INSERT INTO CONVERTEDAIRPORTS(IDENT,LATITUDE,LONGITUDE,ELEVATION) VALUES(:identifier, :latitudeRadians, :longitudeRadians, :elevation)");
		return writer;
	}

}
