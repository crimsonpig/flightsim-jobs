package com.crimsonpig.fs.mappers;

import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.mapping.PassThroughFieldSetMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.batch.item.file.transform.LineTokenizer;

public class AirportLineMapper extends DefaultLineMapper<FieldSet> {

	public AirportLineMapper(){
		setLineTokenizer(lineTokenizer());
		setFieldSetMapper(fieldSetMapper());
	}

	private LineTokenizer lineTokenizer() {
		DelimitedLineTokenizer tokenizer = new CommaSeparatedLineTokenizer();
		return tokenizer;
	}

	private FieldSetMapper<FieldSet> fieldSetMapper() {
		return new PassThroughFieldSetMapper();
	}
	
}
