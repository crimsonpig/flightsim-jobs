package com.crimsonpig.fs.processors;

import org.springframework.batch.item.ItemProcessor;

import com.crimsonpig.fs.domain.airport.FS9Airport;
import com.crimsonpig.fs.domain.airport.ConvertedFS9Airport;
import com.crimsonpig.fs.service.AirportConverter;

public class AirportProcessor implements
		ItemProcessor<FS9Airport, ConvertedFS9Airport> {
	
	private AirportConverter conversionService;
	
	public AirportProcessor(){
		conversionService = new AirportConverter();
	}

	public ConvertedFS9Airport process(FS9Airport airportToConvert) throws Exception {
		return conversionService.convertAirport(airportToConvert);
	}

}
