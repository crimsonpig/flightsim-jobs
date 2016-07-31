package com.crimsonpig.fs.mappers;

import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.batch.item.file.transform.LineTokenizer;

import com.crimsonpig.fs.domain.aircraft.config.AircraftConfigFile;

public class AircraftConfigListLineMapper extends DefaultLineMapper<AircraftConfigFile> {

	public AircraftConfigListLineMapper(){
		setLineTokenizer(aircraftConfigListTokenizer());
		setFieldSetMapper(aircraftConfigListFieldSetMapper());
	}

	private LineTokenizer aircraftConfigListTokenizer() {
		DelimitedLineTokenizer tokenizer = new CommaSeparatedLineTokenizer();
		tokenizer.setNames(new String[]{"aircraftName","aircraftConfigFilePath"});
		return tokenizer;
	}
	
	private FieldSetMapper<AircraftConfigFile> aircraftConfigListFieldSetMapper() {
		BeanWrapperFieldSetMapper<AircraftConfigFile> wrapper = new BeanWrapperFieldSetMapper<AircraftConfigFile>();
		wrapper.setTargetType(AircraftConfigFile.class);
		return wrapper;
	}
	
}
