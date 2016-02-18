package com.crimsonpig.fs.lineaggregators;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.batch.item.file.transform.LineAggregator;

import com.crimsonpig.fs.domain.route.FullRouteDefinition;

public class FullRouteDefinitionsLineAggregatorTest {
	
	@Test
	public void aggregateFullRouteDefinitionsToString(){
		
		LineAggregator<FullRouteDefinition> aggregator = new FullRouteDefinitionLineAggregator();
		
		FullRouteDefinition smfToDen = new FullRouteDefinition();
		smfToDen.setAircraftNumber(1);
		smfToDen.setAircraftTitle("Boeing 737-400 Paint1");
		smfToDen.setAircraftModel("B734");
		smfToDen.setAirline("American Pacific");
		smfToDen.setGroundspeed(430);
		smfToDen.setOriginAirport("KSMF");
		smfToDen.setOriginLatitude(0.67536243);
		smfToDen.setOriginLongitude(-2.12215942);
		smfToDen.setOriginTimezone(-7);
		smfToDen.setDestinationAirport("KDEN");
		smfToDen.setDestinationLatitude(0.69571713);
		smfToDen.setDestinationLongitude(-1.82689160);
		smfToDen.setFlightFrequency(8);
		smfToDen.setLowestFlightLevel(370);
		
		String line = aggregator.aggregate(smfToDen);

		assertEquals("American Pacific,B734,1,Boeing 737-400 Paint1,430,-7,KSMF,0.67536243,-2.12215942,KDEN,0.69571713,-1.8268916,8,370", line);
		
		
		
		
	}
}
