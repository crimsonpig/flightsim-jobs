package com.crimsonpig.fs.service.retrieve;

import java.util.List;

import com.crimsonpig.fs.config.readers.FlightplanAircraftReader;
import com.crimsonpig.fs.domain.aircraft.FlightplanAircraft;
import com.crimsonpig.fs.exception.EntityNotFoundException;

public class RetrieveFlightplanAircraftService {

	private FlightplanAircraftReader dbReader;

	public void setDatabaseReader(FlightplanAircraftReader dbReader) {
		this.dbReader = dbReader;
	}

	public FlightplanAircraft retrieveInstalledAircraftByTitle(String title) {	
		List<FlightplanAircraft> foundAircraft = dbReader.retrieveInstalledAircraftByTitle(title);
		if(foundAircraft == null || foundAircraft.isEmpty()){
			throw new EntityNotFoundException(String.format("title = %s", title));
		} else{
			return foundAircraft.get(0);
		}
	}

}
