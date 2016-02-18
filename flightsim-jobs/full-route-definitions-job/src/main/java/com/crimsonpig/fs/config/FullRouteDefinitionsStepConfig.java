package com.crimsonpig.fs.config;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import com.crimsonpig.fs.domain.route.*;
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
		
	
}
