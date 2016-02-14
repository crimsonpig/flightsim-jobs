package com.crimsonpig.fs.mappers;

import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;

import com.crimsonpig.fs.domain.airport.Airport;

public class AirportFieldSetMapper extends BeanWrapperFieldSetMapper<Airport> {

	public AirportFieldSetMapper(){
		setTargetType(Airport.class);
	}
	
}
