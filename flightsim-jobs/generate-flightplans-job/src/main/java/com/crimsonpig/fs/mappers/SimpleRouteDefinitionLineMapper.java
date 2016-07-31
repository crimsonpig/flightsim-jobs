package com.crimsonpig.fs.mappers;

import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.batch.item.file.transform.LineTokenizer;

import com.crimsonpig.fs.domain.route.SimpleRouteDefinition;

public class SimpleRouteDefinitionLineMapper extends DefaultLineMapper<SimpleRouteDefinition> {

	public SimpleRouteDefinitionLineMapper(){
		setLineTokenizer(simpleRouteDefinitionLineTokenizer());
		setFieldSetMapper(simpleRouteDefinitionFieldSetMapper());
	}
	
	private LineTokenizer simpleRouteDefinitionLineTokenizer(){
		DelimitedLineTokenizer tokenizer = new CommaSeparatedLineTokenizer();
		tokenizer.setNames(new String[]{"airline","title","originTimezone","originAirport","destinationAirport","flightFrequency","lowestFlightLevel"});
		return tokenizer;
	}
	
	private FieldSetMapper<SimpleRouteDefinition> simpleRouteDefinitionFieldSetMapper(){
		BeanWrapperFieldSetMapper<SimpleRouteDefinition> mapper = new BeanWrapperFieldSetMapper<SimpleRouteDefinition>();
		mapper.setTargetType(SimpleRouteDefinition.class);
		return mapper;
	}
}
