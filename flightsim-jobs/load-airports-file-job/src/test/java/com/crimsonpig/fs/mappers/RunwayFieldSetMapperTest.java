package com.crimsonpig.fs.mappers;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.batch.item.file.transform.LineTokenizer;
import org.springframework.validation.BindException;

import com.crimsonpig.fs.domain.airport.Runway;
import com.crimsonpig.fs.domain.airport.Surface;

public class RunwayFieldSetMapperTest {

	@Test
	public void testMapRunway(){
		String line = "RUNWAY,9507,150,HARD";
		LineTokenizer commaSeparatedTokenizer = new CommaSeparatedLineTokenizer();
		FieldSet fields = commaSeparatedTokenizer.tokenize(line);

		FieldSetMapper<Runway> mapper = new RunwayFieldSetMapper();
		Runway rwy = null;
		
		try {
			rwy = mapper.mapFieldSet(fields);
		} catch (BindException e) {
			e.printStackTrace();
			fail();
		}
		
		assertNotNull(rwy);
		assertEquals(9507, rwy.getLength());
		assertEquals(150, rwy.getWidth());
		assertEquals(Surface.HARD, rwy.getSurface());
		
	}
	
}
