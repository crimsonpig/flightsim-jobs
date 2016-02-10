package com.crimsonpig.fs.service;

import static org.junit.Assert.*;

import org.junit.Test;

import com.crimsonpig.fs.domain.aircraft.RouteAircraft;
import com.crimsonpig.fs.domain.aircraft.FlightplanAircraft;
import com.crimsonpig.fs.domain.aircraft.InstalledAircraft;

public class FlightplanAircraftServiceTest {

	@Test
	public void testCessna(){
		RouteAircraft c172 = new RouteAircraft();
		c172.setGroundspeed(129);
		c172.setTitle("Cessna Skyhawk 172SP Paint1");
		
		InstalledAircraft installedC172 = new InstalledAircraft();
		installedC172.setTitle("Cessna Skyhawk 172SP Paint1");
		installedC172.setAtcModel("C172");
		
		CreateFlightplanAircraftService service = new CreateFlightplanAircraftService();
		
		FlightplanAircraft flightplanC172 = service.createFlightplanAircraft(c172, installedC172);
		assertEquals(c172.getGroundspeed(), flightplanC172.getGroundspeed());
		assertEquals(c172.getTitle(), flightplanC172.getTitle());
		assertEquals(installedC172.getTitle(), flightplanC172.getTitle());
		assertEquals(installedC172.getAtcModel(), flightplanC172.getAtcModel());
	}
	
	@Test
	public void testSouthwest737(){
		RouteAircraft wn737 = new RouteAircraft();
		wn737.setGroundspeed(430);
		wn737.setTitle("Boeing 737-700 Southwest Blue");
		
		InstalledAircraft iWn737 = new InstalledAircraft();
		iWn737.setTitle("Boeing 737-700 Southwest Blue");
		iWn737.setAirline("Southwest");
		iWn737.setAtcModel("B737");
		
		CreateFlightplanAircraftService service = new CreateFlightplanAircraftService();
		
		FlightplanAircraft fpWn737 = service.createFlightplanAircraft(wn737, iWn737);
		assertEquals(wn737.getTitle(), fpWn737.getTitle());
		assertEquals(iWn737.getTitle(), fpWn737.getTitle());
		assertEquals(wn737.getGroundspeed(), fpWn737.getGroundspeed());
		assertEquals(iWn737.getAirline(), fpWn737.getAirline());
		assertEquals(iWn737.getAtcModel(), fpWn737.getAtcModel());
	}
}
