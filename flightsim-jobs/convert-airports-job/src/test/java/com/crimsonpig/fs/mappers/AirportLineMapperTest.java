package com.crimsonpig.fs.mappers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.springframework.batch.item.file.LineMapper;

import com.crimsonpig.fs.domain.airport.FS9Airport;

public class AirportLineMapperTest {

	@Test
	public void mapLineToAirport(){
		LineMapper<FS9Airport> mapper = new AirportLineMapper();
		String lineToMap = "KSEA,N47* 26.94000',W122* 18.55830',433";
		FS9Airport ksea = null;
		try {
			ksea = mapper.mapLine(lineToMap, 1);
		} catch (Exception e) {
			fail();
		}
		assertEquals("KSEA",ksea.getIdentifier());
		assertEquals("N47* 26.94000'", ksea.getLatitude());
		assertEquals("W122* 18.55830'", ksea.getLongitude());
		assertEquals(433, ksea.getElevation());
	}
}
