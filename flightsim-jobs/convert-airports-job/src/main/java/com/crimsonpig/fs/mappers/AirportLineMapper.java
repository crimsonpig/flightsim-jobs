package com.crimsonpig.fs.mappers;

import org.springframework.batch.item.file.mapping.DefaultLineMapper;

import com.crimsonpig.fs.domain.airport.Airport;

public class AirportLineMapper extends DefaultLineMapper<Airport> {

	public AirportLineMapper(){
		setLineTokenizer(new AirportLineTokenizer());
		setFieldSetMapper(new AirportFieldSetMapper());
	}

}
