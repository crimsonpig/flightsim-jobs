package com.crimsonpig.fs.readers;

import java.util.ArrayList;
import java.util.List;

import com.crimsonpig.fs.domain.aircraft.FlightplanAircraft;

public class MoreThanOneFlightplanAircraftReader extends FlightplanAircraftReader {

	
	public List<FlightplanAircraft> retrieveInstalledAircraftFromAirlineAndModel(String airline, String model) {
		List<FlightplanAircraft> acList = new ArrayList<FlightplanAircraft>();
		acList.add(getFirstFlightplanAircraft());
		acList.add(getSecondFlightplanAircraft());
		return acList;
	}
	
	private FlightplanAircraft getFirstFlightplanAircraft(){
		FlightplanAircraft first = new FlightplanAircraft();
		first.setAirline("Southwest");
		first.setAtcModel("B737");
		first.setTitle("Boeing 737-700 Southwest Newest Colors");
		return first;
	}
	
	private FlightplanAircraft getSecondFlightplanAircraft(){
		FlightplanAircraft second = new FlightplanAircraft();
		second.setAirline("Southwest");
		second.setAtcModel("B737");
		second.setTitle("Boeing 737-700 Southwest Older Colors");
		return second;
	}
}
