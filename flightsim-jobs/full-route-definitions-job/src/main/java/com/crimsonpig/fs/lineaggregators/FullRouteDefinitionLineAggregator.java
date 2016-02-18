package com.crimsonpig.fs.lineaggregators;

import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.batch.item.file.transform.FieldExtractor;

import com.crimsonpig.fs.domain.route.FullRouteDefinition;

public class FullRouteDefinitionLineAggregator extends CommaSeparatedLineAggregator<FullRouteDefinition> {

	public FullRouteDefinitionLineAggregator(){
		setFieldExtractor(fieldExtractor());
	}
	
	protected FieldExtractor<FullRouteDefinition> fieldExtractor(){
		BeanWrapperFieldExtractor<FullRouteDefinition> extractor = new BeanWrapperFieldExtractor<FullRouteDefinition>();
		extractor.setNames(new String[]{"airline","aircraftModel","aircraftNumber","aircraftTitle","groundspeed","originTimezone","originAirport","originLatitude","originLongitude","destinationAirport","destinationLatitude","destinationLongitude","flightFrequency","lowestFlightLevel"});
		return extractor;
	}

}
