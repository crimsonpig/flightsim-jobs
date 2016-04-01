package com.crimsonpig.fs.service.retrieve;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.crimsonpig.fs.domain.aircraft.InstalledAircraft;
import com.crimsonpig.fs.exception.EntityNotFoundException;

public class RetrieveInstalledAircraftServiceTest {

	@Test
	public void findAircraftTest(){
		RetrieveInstalledAircraftService service = new RetrieveInstalledAircraftService();
		
		InstalledAircraft installedC172 = new InstalledAircraft();
		installedC172.setTitle("Cessna Skyhawk 172SP Paint1");
		installedC172.setAtcModel("C172");
		
		InstalledAircraft iWn737 = new InstalledAircraft();
		iWn737.setTitle("Boeing 737-700 Southwest Blue");
		iWn737.setAirline("Southwest");
		iWn737.setAtcModel("B737");
		List<InstalledAircraft> foundAircraft = new ArrayList<InstalledAircraft>();
		foundAircraft.add(iWn737);
		foundAircraft.add(installedC172);
		
		String title = "Boeing 737-700 Southwest Blue";
		
		InstalledAircraft aircraft = service.findInstalledAircraft(title, foundAircraft);
		
		assertNotNull(aircraft);
		assertEquals(title, aircraft.getTitle());
		
	}
	
	@Test(expected=EntityNotFoundException.class)
	public void aircraftNotFoundTest(){
		RetrieveInstalledAircraftService service = new RetrieveInstalledAircraftService();

		List<InstalledAircraft> foundAircraft = new ArrayList<InstalledAircraft>();

		String title = "Boeing 737-700 Southwest Blue";

		InstalledAircraft aircraft = service.findInstalledAircraft(title, foundAircraft);
	
	}
	
}
