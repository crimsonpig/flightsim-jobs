package com.crimsonpig.fs.config.readers;

import java.util.ArrayList;
import java.util.List;

import com.crimsonpig.fs.config.readers.FlightplanAircraftReader;
import com.crimsonpig.fs.domain.aircraft.FlightplanAircraft;
import com.crimsonpig.fs.stubs.FlightplanAircraftStubs;

public class MoreThanOneFlightplanAircraftReader extends FlightplanAircraftReader {

	
	public List<FlightplanAircraft> retrieveInstalledAircraftFromAirlineAndModel(String airline, String model) {
		List<FlightplanAircraft> acList = new ArrayList<FlightplanAircraft>();
		acList.add(FlightplanAircraftStubs.getFirstFlightplanAircraft());
		acList.add(FlightplanAircraftStubs.getSecondFlightplanAircraft());
		return acList;
	}
	
}
