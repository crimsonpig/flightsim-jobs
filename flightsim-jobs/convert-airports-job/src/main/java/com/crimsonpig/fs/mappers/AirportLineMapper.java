package com.crimsonpig.fs.mappers;

import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.batch.item.file.transform.LineTokenizer;

import com.crimsonpig.fs.domain.airport.Airport;

public class AirportLineMapper extends DefaultLineMapper<Airport> {

	public AirportLineMapper(){
		setLineTokenizer(airportLineTokenizer());
		setFieldSetMapper(airportFieldSetMapper());
	}
	
	private LineTokenizer airportLineTokenizer(){
		DelimitedLineTokenizer tokenizer = new DelimitedLineTokenizer();
		tokenizer.setDelimiter(",");
		tokenizer.setNames(new String[]{"identifier","latitude","longitude","elevation"});
		return tokenizer;
	}

	private FieldSetMapper<Airport> airportFieldSetMapper(){
		BeanWrapperFieldSetMapper<Airport> wrapper = new BeanWrapperFieldSetMapper<Airport>();
		wrapper.setTargetType(Airport.class);
		return wrapper;
	}
}
