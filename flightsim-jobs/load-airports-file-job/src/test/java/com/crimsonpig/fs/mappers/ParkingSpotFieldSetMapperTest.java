package com.crimsonpig.fs.mappers;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.batch.item.file.transform.LineTokenizer;
import org.springframework.validation.BindException;

import com.crimsonpig.fs.domain.airport.ParkingSpot;
import com.crimsonpig.fs.domain.airport.ParkingType;

public class ParkingSpotFieldSetMapperTest {

	private LineTokenizer tokenizer;
	
	private FieldSetMapper<ParkingSpot> mapper;
	
	@Before
	public void setUp(){
		tokenizer = new CommaSeparatedLineTokenizer();
		mapper = new ParkingSpotFieldSetMapper();
	}
	
	@Test
	public void testMapGate(){
		String line = "PARKING,18.0,GATE";
		FieldSet fields = tokenizer.tokenize(line);

		ParkingSpot parking = null;
		
		try {
			parking = mapper.mapFieldSet(fields);
		} catch (BindException e) {
			e.printStackTrace();
			fail();
		}
		
		assertNotNull(parking);
		assertEquals(18.0, parking.getRadius(), 0.001);
		assertEquals(ParkingType.GATE, parking.getParkingType());
		
	}
	
	@Test
	public void testMapCargo(){
		String line = "PARKING,50.0,CARGO";
		FieldSet fields = tokenizer.tokenize(line);

		ParkingSpot parking = null;
		
		try {
			parking = mapper.mapFieldSet(fields);
		} catch (BindException e) {
			e.printStackTrace();
			fail();
		}
		
		assertNotNull(parking);
		assertEquals(50.0, parking.getRadius(), 0.001);
		assertEquals(ParkingType.CARGO, parking.getParkingType());
		
	}
	
	@Test
	public void testMapRamp(){
		String line = "PARKING,14.0,RAMP";
		FieldSet fields = tokenizer.tokenize(line);

		ParkingSpot parking = null;
		
		try {
			parking = mapper.mapFieldSet(fields);
		} catch (BindException e) {
			e.printStackTrace();
			fail();
		}
		
		assertNotNull(parking);
		assertEquals(14.0, parking.getRadius(), 0.001);
		assertEquals(ParkingType.RAMP, parking.getParkingType());
		
	}	
	
}
