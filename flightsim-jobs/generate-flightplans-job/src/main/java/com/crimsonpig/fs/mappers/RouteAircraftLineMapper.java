package com.crimsonpig.fs.mappers;

import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.batch.item.file.transform.LineTokenizer;

import com.crimsonpig.fs.domain.aircraft.RouteAircraft;

public class RouteAircraftLineMapper extends DefaultLineMapper<RouteAircraft> {

	public RouteAircraftLineMapper(){
		setLineTokenizer(routeAircraftLineTokenizer());
		setFieldSetMapper(routeAircraftFieldSetMapper());
	}
	
	private LineTokenizer routeAircraftLineTokenizer(){
		DelimitedLineTokenizer tokenizer = new CommaSeparatedLineTokenizer();
		tokenizer.setNames(new String[]{"groundspeed","title"});
		return tokenizer;
	}
	
	private FieldSetMapper<RouteAircraft> routeAircraftFieldSetMapper(){
		BeanWrapperFieldSetMapper<RouteAircraft> wrapper = new BeanWrapperFieldSetMapper<RouteAircraft>();
		wrapper.setTargetType(RouteAircraft.class);
		return wrapper;
	}
}
