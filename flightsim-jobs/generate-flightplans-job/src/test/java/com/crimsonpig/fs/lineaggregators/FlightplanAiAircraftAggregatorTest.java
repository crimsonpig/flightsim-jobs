package com.crimsonpig.fs.lineaggregators;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;
import org.springframework.batch.item.file.transform.LineAggregator;

import com.crimsonpig.fs.domain.aircraft.FlightplanAircraft;
import com.crimsonpig.fs.stubs.FlightplanAircraftStubs;

public class FlightplanAiAircraftAggregatorTest {

	@Test
	public void aggregateFlightplanAircraftToString(){
		
		LineAggregator<FlightplanAircraft> aggregator = new FlightplanAiAircraftAggregator();
		FlightplanAircraft aircraft = FlightplanAircraftStubs.getGenericMD83();
		
		String line = aggregator.aggregate(aircraft);
		
		assertFalse(line.contains("Airwave"));	
		assertEquals("AC#4,437,\"McDonnell-Douglas/Boeing MD-83\"", line);
		
	}
}
