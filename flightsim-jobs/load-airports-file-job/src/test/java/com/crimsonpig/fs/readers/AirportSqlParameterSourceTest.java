package com.crimsonpig.fs.readers;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import com.crimsonpig.fs.domain.airport.Airport;
import com.crimsonpig.fs.domain.airport.Airspace;

public class AirportSqlParameterSourceTest {

	@Test
	public void testMapAirport(){
		Airport kprc = airport();
		AirportSqlParameterSource sqlParam = new AirportSqlParameterSource();
		SqlParameterSource params = sqlParam.createSqlParameterSource(kprc);
		assertEquals("KPRC", params.getValue("identifier"));
		assertEquals("United States", params.getValue("country"));
		assertEquals("D", params.getValue("airspace"));
		assertEquals(1537.7, params.getValue("altitude"));
		assertEquals(34.65447239, params.getValue("latitude"));
		assertEquals(-112.419583350, params.getValue("longitude"));
		assertEquals(0, params.getValue("approachFrequencies"));
		assertEquals(0.70, params.getValue("trafficScalar"));
	}

	private Airport airport(){
		Airport ap = new Airport();
		ap.setAirspace(Airspace.D);
		ap.setAltitude(1537.7);
		ap.setApproachFrequencies(0);
		ap.setCountry("United States");
		ap.setIdentifier("KPRC");
		ap.setTrafficScalar(0.70);
		ap.setLatitudeDegrees(34.65447239);
		ap.setLongitudeDegrees(-112.419583350);
		return ap;
	}
}
