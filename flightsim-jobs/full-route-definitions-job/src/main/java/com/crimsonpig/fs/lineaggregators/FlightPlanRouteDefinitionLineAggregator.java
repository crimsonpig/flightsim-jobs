package com.crimsonpig.fs.lineaggregators;

import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.batch.item.file.transform.FieldExtractor;

import com.crimsonpig.fs.domain.route.FlightPlanRouteDefinition;

public class FlightPlanRouteDefinitionLineAggregator extends CommaSeparatedLineAggregator<FlightPlanRouteDefinition> {

	public FlightPlanRouteDefinitionLineAggregator(){
		setFieldExtractor(fieldExtractor());
	}

	private FieldExtractor<FlightPlanRouteDefinition> fieldExtractor() {
		BeanWrapperFieldExtractor<FlightPlanRouteDefinition> extractor = new BeanWrapperFieldExtractor<FlightPlanRouteDefinition>();
		extractor.setNames(new String[]{"airline","aircraftModel","aircraftNumber","aircraftTitle","groundspeed","originTimezone","flightFrequency","originAirport","outboundFlightLevel","destinationAirport","returnFlightLevel","distance","holdTime","routeTime"});
		return extractor;
	}
	
	
}
