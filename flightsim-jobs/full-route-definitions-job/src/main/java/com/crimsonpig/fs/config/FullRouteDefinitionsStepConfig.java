package com.crimsonpig.fs.config;

import java.net.MalformedURLException;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.UrlResource;

import com.crimsonpig.fs.domain.route.*;
import com.crimsonpig.fs.lineaggregators.FullRouteDefinitionLineAggregator;
import com.crimsonpig.fs.mappers.SimpleRouteDefinitionLineMapper;

@Configuration
public class FullRouteDefinitionsStepConfig {

	@Bean(name = "routesReader")
	public ItemReader<SimpleRouteDefinition> routesReader(){
		FlatFileItemReader<SimpleRouteDefinition> reader = new FlatFileItemReader<SimpleRouteDefinition>();
		reader.setResource(new ClassPathResource("data/Airwave-Routes.csv"));
		reader.setLineMapper(new SimpleRouteDefinitionLineMapper());
		return reader;
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
