package com.crimsonpig.fs.service.retrieve;

import java.util.List;

import com.crimsonpig.fs.config.readers.ConvertedAirportReader;
import com.crimsonpig.fs.domain.airport.ConvertedFS9Airport;
import com.crimsonpig.fs.exception.EntityNotFoundException;

public class RetrieveAirportService extends RetrieveItemFromDataSourceService {

	private ConvertedAirportReader dbReader;

	public void setDatabaseReader(ConvertedAirportReader dbReader) {
		this.dbReader = dbReader;
	}

	public ConvertedFS9Airport retrieveAirport(String identifier){		
		List<ConvertedFS9Airport> foundAirports = dbReader.retrieveAirport(identifier);
		if(foundAirports.size() == 0){
			throw new EntityNotFoundException(identifier);
		}
		else{
			ConvertedFS9Airport found =  foundAirports.get(0);
			return found;
		}		
	}
	
}
