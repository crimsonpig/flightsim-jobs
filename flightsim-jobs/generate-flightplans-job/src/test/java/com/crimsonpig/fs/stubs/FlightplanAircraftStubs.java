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

	public static FlightplanAircraft getGeneric737400(){
		FlightplanAircraft fpAircraft = new FlightplanAircraft();
		fpAircraft.setAcId(1);
		fpAircraft.setGroundspeed(430);
		fpAircraft.setTitle("Boeing 737-400 Paint1");
		fpAircraft.setAirline("American Pacific");
		fpAircraft.setAtcModel("B734");
		return fpAircraft;
	}
	
	public static FlightplanAircraft getGenericMD83(){
		FlightplanAircraft aircraft = new FlightplanAircraft();
		aircraft.setAcId(4);
		aircraft.setGroundspeed(437);
		aircraft.setTitle("McDonnell-Douglas/Boeing MD-83");
		aircraft.setAirline("Airwave");
		aircraft.setAtcModel("MD83");
		return aircraft;
	}
	
	
}
