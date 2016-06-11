package com.crimsonpig.fs.readers;

import java.util.ArrayList;
import java.util.List;

import com.crimsonpig.fs.domain.aircraft.FlightplanAircraft;

public class EmptyFlightplanAircraftReader extends FlightplanAircraftReader {

	
	public List<FlightplanAircraft> retrieveInstalledAircraftFromAirlineAndModel(String airline, String model) {
		List<FlightplanAircraft> acList = new ArrayList<FlightplanAircraft>();
		return acList;
	}
	
}
