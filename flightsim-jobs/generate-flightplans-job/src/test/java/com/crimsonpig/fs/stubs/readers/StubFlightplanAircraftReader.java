package com.crimsonpig.fs.stubs.readers;

import java.util.ArrayList;
import java.util.List;

import com.crimsonpig.fs.config.readers.FlightplanAircraftReader;
import com.crimsonpig.fs.domain.aircraft.FlightplanAircraft;

public class StubFlightplanAircraftReader extends FlightplanAircraftReader {

	private List<FlightplanAircraft> acList = new ArrayList<FlightplanAircraft>();
	
	public List<FlightplanAircraft> retrieveInstalledAircraftByTitle(String title) {
		return acList;
	}
	
	public void addAircraftToList(FlightplanAircraft aircraft){
		acList.add(aircraft);
	}
	
}
