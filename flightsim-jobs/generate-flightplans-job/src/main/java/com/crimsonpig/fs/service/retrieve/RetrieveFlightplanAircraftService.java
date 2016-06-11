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

	public FlightplanAircraft retrieveInstalledAircraftFromAirlineAndModel(String airline, String model) {	
		List<FlightplanAircraft> foundAircraft = dbReader.retrieveInstalledAircraftFromAirlineAndModel(airline, model);
		if(foundAircraft == null || foundAircraft.isEmpty()){
			throw new EntityNotFoundException("airline = " + airline + ", model = " + model);
		}
		else if(foundAircraft.size() > 1){
			throw new RuntimeException("More than one aircraft found for airline = " + airline + " and model = " + model);
		}
		else{
			return foundAircraft.get(0);
		}
	}

}
