package com.crimsonpig.fs.config.readers;

import java.util.ArrayList;
import java.util.List;

import com.crimsonpig.fs.config.readers.ConvertedAirportReader;
import com.crimsonpig.fs.domain.airport.ConvertedAirport;

public class EmptyConvertedAirportReader extends ConvertedAirportReader {

	public List<ConvertedAirport> retrieveAirport(String identifier){
		List<ConvertedAirport> foundAirports = new ArrayList<ConvertedAirport>();
		return foundAirports;	
	}
	
}
