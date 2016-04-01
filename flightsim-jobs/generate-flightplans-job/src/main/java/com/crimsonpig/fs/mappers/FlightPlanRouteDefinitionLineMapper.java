package com.crimsonpig.fs.mappers;

import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.batch.item.file.transform.LineTokenizer;

import com.crimsonpig.fs.domain.route.FlightPlanRouteDefinition;

public class FlightPlanRouteDefinitionLineMapper extends DefaultLineMapper<FlightPlanRouteDefinition> {

	
	public FlightPlanRouteDefinitionLineMapper(){
		setLineTokenizer(flightPlanRouteDefinitionLineTokenizer());
		setFieldSetMapper(flightPlanRouteDefinitionFieldSetMapper());
	}

	private LineTokenizer flightPlanRouteDefinitionLineTokenizer() {
		DelimitedLineTokenizer tokenizer = new CommaSeparatedLineTokenizer();
		tokenizer.setNames(new String[]{"airline","aircraftModel","aircraftNumber","aircraftTitle","groundspeed","originTimezone","flightFrequency","originAirport","outboundFlightLevel","destinationAirport","returnFlightLevel","distance","routeTime"});
		return tokenizer;
	}
	
	private FieldSetMapper<FlightPlanRouteDefinition> flightPlanRouteDefinitionFieldSetMapper() {
		BeanWrapperFieldSetMapper<FlightPlanRouteDefinition> mapper = new BeanWrapperFieldSetMapper<FlightPlanRouteDefinition>();
		mapper.setTargetType(FlightPlanRouteDefinition.class);
		return mapper;
	}
}
