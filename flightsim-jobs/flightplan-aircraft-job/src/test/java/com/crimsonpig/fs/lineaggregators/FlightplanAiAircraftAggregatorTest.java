package com.crimsonpig.fs.lineaggregators;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;
import org.springframework.batch.item.file.transform.LineAggregator;

import com.crimsonpig.fs.domain.aircraft.FlightplanAircraft;

public class FlightplanAiAircraftAggregatorTest {

	@Test
	public void aggregateFlightplanAircraftToString(){
		
		LineAggregator<FlightplanAircraft> aggregator = new FlightplanAiAircraftAggregator();
		FlightplanAircraft aircraft = new FlightplanAircraft();
		aircraft.setAcId(4);
		aircraft.setGroundspeed(437);
		aircraft.setTitle("McDonnell-Douglas/Boeing MD-83");
		aircraft.setAirline("Airwave");
		aircraft.setAtcModel("MD83");
		
		String line = aggregator.aggregate(aircraft);
		
		assertFalse(line.contains("Airwave"));	
		assertEquals("AC#4,437,\"McDonnell-Douglas/Boeing MD-83\"", line);
		
	}
}
