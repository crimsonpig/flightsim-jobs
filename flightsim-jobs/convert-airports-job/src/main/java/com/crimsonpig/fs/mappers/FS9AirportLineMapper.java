package com.crimsonpig.fs.mappers;

import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.batch.item.file.transform.LineTokenizer;

import com.crimsonpig.fs.domain.airport.FS9Airport;

public class FS9AirportLineMapper extends DefaultLineMapper<FS9Airport> {

	public FS9AirportLineMapper(){
		setLineTokenizer(airportLineTokenizer());
		setFieldSetMapper(airportFieldSetMapper());
	}
	
	private LineTokenizer airportLineTokenizer(){
		DelimitedLineTokenizer tokenizer = new CommaSeparatedLineTokenizer();
		tokenizer.setNames(new String[]{"identifier","latitude","longitude","elevation"});
		return tokenizer;
	}

	private FieldSetMapper<FS9Airport> airportFieldSetMapper(){
		BeanWrapperFieldSetMapper<FS9Airport> wrapper = new BeanWrapperFieldSetMapper<FS9Airport>();
		wrapper.setTargetType(FS9Airport.class);
		return wrapper;
	}
}
