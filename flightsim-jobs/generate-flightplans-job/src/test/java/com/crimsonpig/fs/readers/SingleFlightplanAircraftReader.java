package com.crimsonpig.fs.readers;

import java.util.ArrayList;
import java.util.List;

import com.crimsonpig.fs.domain.aircraft.FlightplanAircraft;
import com.crimsonpig.fs.stubs.FlightplanAircraftStubs;

public class SingleFlightplanAircraftReader extends FlightplanAircraftReader {

	
	public List<FlightplanAircraft> retrieveInstalledAircraftFromAirlineAndModel(String airline, String model) {
		List<FlightplanAircraft> acList = new ArrayList<FlightplanAircraft>();
		acList.add(FlightplanAircraftStubs.getFirstFlightplanAircraft());
		return acList;
	}
	
}
