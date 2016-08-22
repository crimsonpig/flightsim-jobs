package com.crimsonpig.fs.domain.airport;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AirportTest {

	
	@Test
	public void testCreateAirport(){
		
		Airport airport = new Airport();
		airport.setIdentifier("KSEA");
		airport.setLatitudeDegrees(39.297605529);
		airport.setLongitudeDegrees(-94.713905454);
		airport.setAltitude(312.7);
		airport.setAirspace(Airspace.B);
		airport.setApproachFrequencies(6);
		airport.setTrafficScalar(0.70);
		airport.setCountry("United States");
		
		Runway runway1 = new Runway();
		runway1.setLength(10810);
		runway1.setWidth(150);
		runway1.setSurface(Surface.HARD);
		
		airport.addRunway(runway1);
		
		Runway runway2 = new Runway();
		runway2.setLength(9507);
		runway2.setWidth(150);
		runway2.setSurface(Surface.HARD);
		
		airport.addRunway(runway2);
		
		ParkingSpot parking1 = new ParkingSpot();
		parking1.setRadius(18.0);
		parking1.setParkingType(ParkingType.GATE);
	
		airport.addParkingSpot(parking1);
		
		ParkingSpot parking2 = new ParkingSpot();
		parking2.setRadius(50.0);
		parking2.setParkingType(ParkingType.CARGO);
		
		airport.addParkingSpot(parking2);
		
		ParkingSpot parking3 = new ParkingSpot();
		parking3.setRadius(10.0);
		parking3.setParkingType(ParkingType.RAMP);
			
		airport.addParkingSpot(parking3);
		
		assertEquals(2, airport.getRunways().size());
		assertEquals("KSEA", airport.getRunways().get(0).getAirportIdentifier());
		assertEquals("KSEA", airport.getRunways().get(1).getAirportIdentifier());
		assertEquals(3, airport.getParkingSpots().size());
		assertEquals("KSEA", airport.getParkingSpots().get(0).getAirportIdentifier());
		assertEquals("KSEA", airport.getParkingSpots().get(1).getAirportIdentifier());
		assertEquals("KSEA", airport.getParkingSpots().get(2).getAirportIdentifier());
		
		
	}
	
}
