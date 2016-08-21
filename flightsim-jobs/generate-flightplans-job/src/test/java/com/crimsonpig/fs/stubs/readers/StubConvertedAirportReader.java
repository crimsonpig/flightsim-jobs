package com.crimsonpig.fs.stubs.readers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.crimsonpig.fs.config.readers.ConvertedAirportReader;
import com.crimsonpig.fs.domain.airport.ConvertedFS9Airport;

public class StubConvertedAirportReader extends ConvertedAirportReader {

	private List<ConvertedFS9Airport> foundAirports = new ArrayList<ConvertedFS9Airport>();
	
	public List<ConvertedFS9Airport> retrieveAirport(String identifier){
		return foundAirports
				.stream()
				.filter(airport -> airport.getIdentifier().equals(identifier))
				.collect(Collectors.toList());	
	}
	
	public void addAirportToRetrieve(ConvertedFS9Airport airport){
		foundAirports.add(airport);
	}
}
