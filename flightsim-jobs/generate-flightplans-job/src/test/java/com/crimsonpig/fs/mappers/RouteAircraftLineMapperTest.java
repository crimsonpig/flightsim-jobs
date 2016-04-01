package com.crimsonpig.fs.mappers;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.batch.item.file.LineMapper;

import com.crimsonpig.fs.domain.aircraft.RouteAircraft;

public class RouteAircraftLineMapperTest {

	@Test
	public void routeAircraftLineMapper() throws Exception{
		LineMapper<RouteAircraft> mapper = new RouteAircraftLineMapper();
		String routeAircraftLine = "265,\"De Havilland Dash 8-100\"";
		RouteAircraft aircraft = mapper.mapLine(routeAircraftLine, 0);
		
		assertEquals(265, aircraft.getGroundspeed());
		assertEquals("De Havilland Dash 8-100", aircraft.getTitle());
		
	}
}
