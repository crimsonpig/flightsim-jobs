package com.crimsonpig.fs.mappers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.springframework.batch.item.file.LineMapper;

import com.crimsonpig.fs.domain.route.SimpleRouteDefinition;

public class RouteDefinitionMapperTest {
	
	@Test
	public void mapLineToSimpleRouteDefintition(){
		LineMapper<SimpleRouteDefinition> mapper = new SimpleRouteDefinitionLineMapper();
		String lineToMap = "Airwave,MD80,-7,KSMF,KLAX,6,370";
		SimpleRouteDefinition route = null;
		try {
			route = mapper.mapLine(lineToMap, 0);
		} catch (Exception e){
			fail();
		}
		assertEquals("Airwave", route.getAirline());
		assertEquals("MD80", route.getAircraftModel());
		assertEquals(-7, route.getOriginTimezone());
		assertEquals("KSMF", route.getOriginAirport());
		assertEquals("KLAX", route.getDestinationAirport());
		assertEquals(6, route.getFlightFrequency());
		assertEquals(370, route.getLowestFlightLevel());
		
	}

}
