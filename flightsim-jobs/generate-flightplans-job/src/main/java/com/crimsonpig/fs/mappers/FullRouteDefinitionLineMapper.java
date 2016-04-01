package com.crimsonpig.fs.mappers;

import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.batch.item.file.transform.LineTokenizer;

import com.crimsonpig.fs.domain.route.FullRouteDefinition;

public class FullRouteDefinitionLineMapper extends DefaultLineMapper<FullRouteDefinition> {

	
	public FullRouteDefinitionLineMapper(){
		setLineTokenizer(fullRouteDefinitionLineTokenizer());
		setFieldSetMapper(fullRouteDefinitionFieldSetMapper());
	}

	private LineTokenizer fullRouteDefinitionLineTokenizer() {
		DelimitedLineTokenizer tokenizer = new CommaSeparatedLineTokenizer();
		tokenizer.setNames(new String[]{"airline","aircraftModel","aircraftNumber","aircraftTitle","groundspeed","originTimezone","originAirport","originLatitude","originLongitude","destinationAirport","destinationLatitude","destinationLongitude","flightFrequency","lowestFlightLevel"});
		return tokenizer;
	}
	
	private FieldSetMapper<FullRouteDefinition> fullRouteDefinitionFieldSetMapper() {
		BeanWrapperFieldSetMapper<FullRouteDefinition> mapper = new BeanWrapperFieldSetMapper<FullRouteDefinition>();
		mapper.setTargetType(FullRouteDefinition.class);
		return mapper;
	}
}
