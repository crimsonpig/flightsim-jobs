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

import com.crimsonpig.fs.domain.airport.FS9Airport;
import com.crimsonpig.fs.domain.airport.ConvertedFS9Airport;
import com.crimsonpig.fs.mappers.AirportLineMapper;
import com.crimsonpig.fs.processors.AirportProcessor;

@Configuration
public class ConvertAirportsStepConfig {

	@Autowired
	private DataSource domainDataSource;
	
	@Autowired
	private BatchPropertiesConfig batchProperties;

	@Bean(name = "airportsFileReader")
	public ItemReader<FS9Airport> reader() throws MalformedURLException {
		FlatFileItemReader<FS9Airport> reader = new FlatFileItemReader<FS9Airport>();
		reader.setResource(new UrlResource(batchProperties.getProperty("convert.airports.input.filename")));
		reader.setLineMapper(new AirportLineMapper());
		return reader;
	}

	@Bean(name = "airportLatLonDecimalConverter")
	public ItemProcessor<FS9Airport,ConvertedFS9Airport> processor(){
		return new AirportProcessor();
	}

	@Bean(name = "convertedAirportsWriter")
	public ItemWriter<ConvertedFS9Airport> writer() {
		JdbcBatchItemWriter<ConvertedFS9Airport> writer = new JdbcBatchItemWriter<ConvertedFS9Airport>();
		writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<ConvertedFS9Airport>());
		writer.setAssertUpdates(true);
		writer.setDataSource(domainDataSource);
		writer.setSql("INSERT INTO CONVERTEDAIRPORTS(IDENT,LATITUDE,LONGITUDE,ELEVATION) VALUES(:identifier, :latitudeRadians, :longitudeRadians, :elevation)");
		return writer;
	}

}
