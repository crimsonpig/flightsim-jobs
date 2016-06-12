package com.crimsonpig.fs.stubs.readers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.crimsonpig.fs.config.readers.ConvertedAirportReader;
import com.crimsonpig.fs.domain.airport.ConvertedAirport;

public class StubConvertedAirportReader extends ConvertedAirportReader {

	private List<ConvertedAirport> foundAirports = new ArrayList<ConvertedAirport>();
	
	public List<ConvertedAirport> retrieveAirport(String identifier){
		return foundAirports
				.stream()
				.filter(airport -> airport.getIdentifier().equals(identifier))
				.collect(Collectors.toList());	
	}
	
	public void addAirportToRetrieve(ConvertedAirport airport){
		foundAirports.add(airport);
	}
}
