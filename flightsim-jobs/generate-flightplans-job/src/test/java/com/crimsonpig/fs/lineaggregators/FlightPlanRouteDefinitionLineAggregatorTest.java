package com.crimsonpig.fs.lineaggregators;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.batch.item.file.transform.LineAggregator;

import com.crimsonpig.fs.domain.route.FlightPlanRouteDefinition;

public class FlightPlanRouteDefinitionLineAggregatorTest {
	
	@Test
	public void aggregateFlightPlanRouteDefinitionToString(){
		LineAggregator<FlightPlanRouteDefinition> aggregator = new FlightPlanRouteDefinitionLineAggregator();
		
		FlightPlanRouteDefinition smfToDen = new FlightPlanRouteDefinition();
		smfToDen.setAircraftNumber(1);
		smfToDen.setAircraftTitle("Boeing 737-400 Paint1");
		smfToDen.setAirline("American Pacific");
		smfToDen.setAircraftModel("B734");
		smfToDen.setGroundspeed(430);
		smfToDen.setOriginAirport("KSMF");
		smfToDen.setOutboundFlightLevel(370);
		smfToDen.setOriginTimezone(-7);
		smfToDen.setDestinationAirport("KDEN");
		smfToDen.setReturnFlightLevel(380);
		smfToDen.setFlightFrequency(8);
		smfToDen.setDistance(788);
		smfToDen.setRouteTime(7500);
		
		String line = aggregator.aggregate(smfToDen);
		
		assertEquals("American Pacific,B734,1,Boeing 737-400 Paint1,430,-7,8,KSMF,370,KDEN,380,788.0,7500", line);
	}
	
}
