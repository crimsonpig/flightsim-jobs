package com.crimsonpig.fs.service.retrieve;

import java.util.List;

import com.crimsonpig.fs.config.readers.ConvertedAirportReader;
import com.crimsonpig.fs.domain.airport.ConvertedAirport;
import com.crimsonpig.fs.exception.EntityNotFoundException;

public class RetrieveAirportService extends RetrieveItemFromDataSourceService {

	private ConvertedAirportReader dbReader;

	public void setDbReader(ConvertedAirportReader dbReader) {
		this.dbReader = dbReader;
	}

	public ConvertedAirport retrieveAirport(String identifier){		
		List<ConvertedAirport> foundAirports = dbReader.retrieveAirport(identifier);
		if(foundAirports.size() == 0){
			throw new EntityNotFoundException(identifier);
		}
		else{
			ConvertedAirport found =  foundAirports.get(0);
			return found;
		}		
	}
	
}
