package com.crimsonpig.fs.stubs.readers;

import java.util.ArrayList;
import java.util.List;

import com.crimsonpig.fs.config.readers.ConvertedAirportReader;
import com.crimsonpig.fs.domain.airport.ConvertedAirport;

public class StubConvertedAirportReader extends ConvertedAirportReader {

	private List<ConvertedAirport> foundAirports = new ArrayList<ConvertedAirport>();
	
	public List<ConvertedAirport> retrieveAirport(String identifier){
		return foundAirports;	
	}
	
	public void addAirportToRetrieve(ConvertedAirport airport){
		foundAirports.add(airport);
	}
}
