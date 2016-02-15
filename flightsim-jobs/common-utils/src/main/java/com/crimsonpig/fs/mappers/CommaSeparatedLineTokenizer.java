package com.crimsonpig.fs.mappers;

import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;

public class CommaSeparatedLineTokenizer extends DelimitedLineTokenizer {

	public CommaSeparatedLineTokenizer(){
		setDelimiter(",");
	}
	
}
