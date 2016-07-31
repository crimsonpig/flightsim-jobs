package com.crimsonpig.fs.lineaggregators;

import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.batch.item.file.transform.FieldExtractor;

import com.crimsonpig.fs.domain.aircraft.config.AircraftConfigFile;

public class AircraftConfigListLineAggregator extends CommaSeparatedLineAggregator<AircraftConfigFile> {

	public AircraftConfigListLineAggregator(){
		setFieldExtractor(fieldExtractor());
	}

	private FieldExtractor<AircraftConfigFile> fieldExtractor() {
		BeanWrapperFieldExtractor<AircraftConfigFile> extractor = new BeanWrapperFieldExtractor<AircraftConfigFile>();
		extractor.setNames(new String[]{"aircraftName","aircraftConfigFilePath"});
		return extractor;
	}
	
}
