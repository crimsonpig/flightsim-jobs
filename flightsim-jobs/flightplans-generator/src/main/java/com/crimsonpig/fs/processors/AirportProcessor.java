package com.crimsonpig.fs.processors;

import org.springframework.batch.item.ItemProcessor;

import com.crimsonpig.fs.domain.airport.Airport;
import com.crimsonpig.fs.domain.airport.ConvertedAirport;
import com.crimsonpig.fs.domain.flightplan.*;
import com.crimsonpig.fs.service.AirportConverter;

public class AirportProcessor implements
		ItemProcessor<Airport, ConvertedAirport> {
	
	private AirportConverter conversionService;
	
	public AirportProcessor(){
		conversionService = new AirportConverter();
	}

	public ConvertedAirport process(Airport airportToConvert) throws Exception {
		return conversionService.convertAirport(airportToConvert);
	}

}
