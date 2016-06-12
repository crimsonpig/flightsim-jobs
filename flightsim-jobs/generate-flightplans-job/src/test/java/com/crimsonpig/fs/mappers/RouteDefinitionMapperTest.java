package com.crimsonpig.fs.mappers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.springframework.batch.item.file.LineMapper;

import com.crimsonpig.fs.domain.route.*;

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
	
	@Test
	public void mapLineToFullRouteDefinition(){
		
		LineMapper<FullRouteDefinition> mapper = new FullRouteDefinitionLineMapper();
		String lineToMap = "Airwave,MD80,5,McDonnell-Douglas/Boeing MD-83 Paint1,437,-7,KPDX,0.79567329,-2.13973003,KSMF,0.67536243,-2.12215942,5,370";
		FullRouteDefinition route = null;
		try {
			route = mapper.mapLine(lineToMap, 0);
		} catch (Exception e){
			fail();
		}
		assertEquals("Airwave", route.getAirline());
		assertEquals("MD80", route.getAircraftModel());
		assertEquals(5, route.getAircraftNumber());
		assertEquals("McDonnell-Douglas/Boeing MD-83 Paint1", route.getAircraftTitle());
		assertEquals(437, route.getGroundspeed());
		assertEquals(-7, route.getOriginTimezone());
		assertEquals("KPDX", route.getOriginAirport());
		assertEquals(0.79567329, route.getOriginLatitude(), 0);
		assertEquals(-2.13973003, route.getOriginLongitude(), 0);
		assertEquals("KSMF", route.getDestinationAirport());
		assertEquals(0.67536243, route.getDestinationLatitude(), 0);
		assertEquals(-2.12215942, route.getDestinationLongitude(), 0);
		assertEquals(5, route.getFlightFrequency());
		assertEquals(370, route.getLowestFlightLevel());
		
	}
	
	@Test
	public void mapLineToFlightPlanRouteDefinition(){
		
		LineMapper<FlightPlanRouteDefinition> mapper = new FlightPlanRouteDefinitionLineMapper();
		String lineToMap = "Airwave,MD80,5,McDonnell-Douglas/Boeing MD-83 Paint1,437,-7,5,KPDX,370,KSMF,380,416.0061345896832,4327";
		FlightPlanRouteDefinition route = null;
		try {
			route = mapper.mapLine(lineToMap, 0);
		} catch (Exception e){
			fail();
		}
		assertEquals("Airwave", route.getAirline());
		assertEquals("MD80", route.getAircraftModel());
		assertEquals(5, route.getAircraftNumber());
		assertEquals("McDonnell-Douglas/Boeing MD-83 Paint1", route.getAircraftTitle());
		assertEquals(437, route.getGroundspeed());
		assertEquals(-7, route.getOriginTimezone());
		assertEquals(5, route.getFlightFrequency());
		assertEquals("KPDX", route.getOriginAirport());
		assertEquals(370, route.getOutboundFlightLevel());
		assertEquals("KSMF", route.getDestinationAirport());
		assertEquals(380, route.getReturnFlightLevel());
		assertEquals(416.00, route.getDistance(), 0.01);
		assertEquals(4327, route.getRouteTime());
		
	}

}
