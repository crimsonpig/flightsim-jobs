package com.crimsonpig.fs.processors;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.crimsonpig.fs.domain.aircraft.FlightplanAircraft;
import com.crimsonpig.fs.domain.aircraft.InstalledAircraft;
import com.crimsonpig.fs.domain.aircraft.RouteAircraft;
import com.crimsonpig.fs.service.retrieve.RetrieveInstalledAircraftService;

public class FlightplanAircraftProcessorTest {

	@Test
	public void processAircraft() throws Exception{
		
		FlightplanAircraftProcessor processor = new FlightplanAircraftProcessor();
		
		RouteAircraft wn737 = new RouteAircraft();
		wn737.setGroundspeed(430);
		wn737.setTitle("Boeing 737-700 Southwest Blue");

		RetrieveInstalledAircraftService installedAircraftService = new RetrieveInstalledAircraftService(){
			public InstalledAircraft retrieveInstalledAircraft(String title) {
				InstalledAircraft iWn737 = new InstalledAircraft();
				iWn737.setTitle(title);
				iWn737.setAirline("Southwest");
				iWn737.setAtcModel("B737");
				return iWn737;
			}
		};
		
		processor.setInstalledAircraftService(installedAircraftService);

		FlightplanAircraft fpWn737 = processor.process(wn737);
		assertEquals(wn737.getTitle(), fpWn737.getTitle());
		assertEquals(wn737.getGroundspeed(), fpWn737.getGroundspeed());
		assertEquals("Southwest", fpWn737.getAirline());
		assertEquals("B737", fpWn737.getAtcModel());
		
	}
	
}
