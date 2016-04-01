package com.crimsonpig.fs.service;

import com.crimsonpig.fs.domain.aircraft.RouteAircraft;
import com.crimsonpig.fs.domain.aircraft.FlightplanAircraft;
import com.crimsonpig.fs.domain.aircraft.InstalledAircraft;

public class CreateFlightplanAircraftService {

	public FlightplanAircraft createFlightplanAircraft(RouteAircraft aiAircraft,
			InstalledAircraft installedAircraft) {
		FlightplanAircraft flightplanAircraft = new FlightplanAircraft();
		flightplanAircraft.setTitle(installedAircraft.getTitle());
		flightplanAircraft.setAirline(installedAircraft.getAirline());
		flightplanAircraft.setAtcModel(installedAircraft.getAtcModel());
		flightplanAircraft.setGroundspeed(aiAircraft.getGroundspeed());
		return flightplanAircraft;
	}

}
