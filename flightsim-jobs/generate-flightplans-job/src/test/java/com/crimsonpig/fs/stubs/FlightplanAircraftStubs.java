package com.crimsonpig.fs.stubs;

import com.crimsonpig.fs.domain.aircraft.FlightplanAircraft;

public class FlightplanAircraftStubs {

	public static FlightplanAircraft getFirstFlightplanAircraft(){
		FlightplanAircraft first = new FlightplanAircraft();
		first.setAirline("Southwest");
		first.setAtcModel("B737");
		first.setTitle("Boeing 737-700 Southwest Newest Colors");
		first.setGroundspeed(430);
		return first;
	}
	
	public static FlightplanAircraft getSecondFlightplanAircraft(){
		FlightplanAircraft second = new FlightplanAircraft();
		second.setAirline("Southwest");
		second.setAtcModel("B737");
		second.setTitle("Boeing 737-700 Southwest Older Colors");
		second.setGroundspeed(430);
		return second;
	}
	
}
