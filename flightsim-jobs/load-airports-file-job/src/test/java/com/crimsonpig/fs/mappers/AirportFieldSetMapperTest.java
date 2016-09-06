package com.crimsonpig.fs.mappers;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.batch.item.file.transform.LineTokenizer;
import org.springframework.validation.BindException;

import com.crimsonpig.fs.domain.airport.Airport;
import com.crimsonpig.fs.domain.airport.Airspace;

public class AirportFieldSetMapperTest {

	@Test
	public void testMapAirportHeaderInfo(){
		String testLine = "KMCI,39.297605529,-94.713905454,312.7,B,6,0.70,United States";
		LineTokenizer commaSeparatedTokenizer = new CommaSeparatedLineTokenizer();
		FieldSet fields = commaSeparatedTokenizer.tokenize(testLine);

		AirportFieldSetMapper mapper = new AirportFieldSetMapper();
		Airport actual = null;
		try {
			actual = mapper.mapFieldSet(fields);
		} catch (BindException e) {
			e.printStackTrace();
			fail();
		}
		assertNotNull(actual);
		assertEquals("KMCI", actual.getIdentifier());
		assertEquals(39.297605529, actual.getLatitudeDegrees(), 0.0000000001);
		assertEquals(-94.713905454, actual.getLongitudeDegrees(), 0.0000000001);
		assertEquals(312.7, actual.getAltitude(), 0.00001);
		assertEquals(Airspace.B, actual.getAirspace());
		assertEquals(6, actual.getApproachFrequencies());
		assertEquals(0.70, actual.getTrafficScalar(), 0.01);
		assertEquals("United States", actual.getCountry());		
	}
	
}
