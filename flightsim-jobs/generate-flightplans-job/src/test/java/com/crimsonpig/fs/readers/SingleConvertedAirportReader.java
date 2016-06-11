package com.crimsonpig.fs.readers;

import java.util.ArrayList;
import java.util.List;

import com.crimsonpig.fs.domain.airport.ConvertedAirport;
import com.crimsonpig.fs.stubs.ConvertedAirportStubs;

public class SingleConvertedAirportReader extends ConvertedAirportReader {

	public List<ConvertedAirport> retrieveAirport(String identifier){
		List<ConvertedAirport> foundAirports = new ArrayList<ConvertedAirport>();
		foundAirports.add(ConvertedAirportStubs.getLAXAirport());
		return foundAirports;	
	}
	
}
