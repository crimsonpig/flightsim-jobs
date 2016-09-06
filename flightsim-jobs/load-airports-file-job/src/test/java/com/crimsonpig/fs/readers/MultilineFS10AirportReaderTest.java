package com.crimsonpig.fs.readers;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.core.io.ClassPathResource;

import com.crimsonpig.fs.domain.airport.Airport;
import com.crimsonpig.fs.domain.airport.Airspace;
import com.crimsonpig.fs.domain.airport.ParkingSpot;
import com.crimsonpig.fs.domain.airport.ParkingType;
import com.crimsonpig.fs.domain.airport.Runway;
import com.crimsonpig.fs.domain.airport.Surface;
import com.crimsonpig.fs.mappers.AirportLineMapper;

public class MultilineFS10AirportReaderTest {

	private static final String PATH_TO_TEST_FILE = "./fs10.airport.dat";
	
	private FlatFileItemReader<FieldSet> delegateReader;
	
	private MultilineFS10AirportReader reader;
	
	@Before
	public void setUp(){
		delegateReader = new FlatFileItemReader<FieldSet>();
		delegateReader.setResource(new ClassPathResource(PATH_TO_TEST_FILE));
		delegateReader.setLineMapper(new AirportLineMapper());
		reader = new MultilineFS10AirportReader(delegateReader);
	}
	
	@Test
	public void testReadAirport(){
		Airport kmci = null;
		Airport kojc = null;
		Airport eof = new Airport(); 
		try {
			reader.open(new ExecutionContext());
			kmci = reader.read();
			kojc = reader.read();
			eof = reader.read();
			reader.close();	
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
		assertNotNull(kmci);
		assertNotNull(kojc);
		assertAirportHeaderMCI(kmci);
		assertRunwaysMCI(kmci.getRunways());
		assertParkingSpotsMCI(kmci.getParkingSpots());
		
		assertAirportHeaderOJC(kojc);
		assertRunwaysOJC(kojc.getRunways());
		assertParkingSpotsOJC(kojc.getParkingSpots());
		
		assertNull(eof);
	}	

	private void assertAirportHeaderMCI(Airport actual){
		assertEquals("KMCI", actual.getIdentifier());
		assertEquals(39.297605529, actual.getLatitudeDegrees(), 0.0000000001);
		assertEquals(-94.713905454, actual.getLongitudeDegrees(), 0.0000000001);
		assertEquals(312.7, actual.getAltitude(), 0.00001);
		assertEquals(Airspace.B, actual.getAirspace());
		assertEquals(6, actual.getApproachFrequencies());
		assertEquals(0.70, actual.getTrafficScalar(), 0.01);
		assertEquals("United States", actual.getCountry());			
	}
	
	private void assertAirportHeaderOJC(Airport actual){
		assertEquals("KOJC", actual.getIdentifier());
		assertEquals(38.847591542, actual.getLatitudeDegrees(), 0.0000000001);
		assertEquals(-94.735108763, actual.getLongitudeDegrees(), 0.0000000001);
		assertEquals(334.1, actual.getAltitude(), 0.00001);
		assertEquals(Airspace.D, actual.getAirspace());
		assertEquals(2, actual.getApproachFrequencies());
		assertEquals(0.70, actual.getTrafficScalar(), 0.01);
		assertEquals("United States", actual.getCountry());			
	}	
	
	private void assertRunwaysMCI(List<Runway> runways) {
		assertNotNull(runways);
		assertEquals(3, runways.size());
		Runway longest = runways.get(0);
		assertEquals(10810, longest.getLength());
		assertEquals(150, longest.getWidth());
		assertEquals(Surface.HARD, longest.getSurface());
		assertEquals("KMCI", longest.getAirportIdentifier());
	}
	
	private void assertRunwaysOJC(List<Runway> runways) {
		assertNotNull(runways);
		assertEquals(1, runways.size());
		Runway longest = runways.get(0);
		assertEquals(4101, longest.getLength());
		assertEquals(75, longest.getWidth());
		assertEquals(Surface.HARD, longest.getSurface());
		assertEquals("KOJC", longest.getAirportIdentifier());
	}	
	
	private void assertParkingSpotsMCI(List<ParkingSpot> parkingSpots) {
		assertNotNull(parkingSpots);
		assertEquals(43, parkingSpots.size());
		ParkingSpot gate = parkingSpots.get(42);
		assertEquals(23.0, gate.getRadius(), 0.001);
		assertEquals(ParkingType.GATE, gate.getParkingType());
		assertEquals("KMCI", gate.getAirportIdentifier());
	}	

	private void assertParkingSpotsOJC(List<ParkingSpot> parkingSpots) {
		assertNotNull(parkingSpots);
		assertEquals(19, parkingSpots.size());
		ParkingSpot gate = parkingSpots.get(4);
		assertEquals(10.0, gate.getRadius(), 0.001);
		assertEquals(ParkingType.RAMP, gate.getParkingType());
		assertEquals("KOJC", gate.getAirportIdentifier());
	}
}
