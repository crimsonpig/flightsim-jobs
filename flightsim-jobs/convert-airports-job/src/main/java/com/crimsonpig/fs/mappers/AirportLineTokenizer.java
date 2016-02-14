package com.crimsonpig.fs.mappers;

import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;

public class AirportLineTokenizer extends DelimitedLineTokenizer {
	
	public AirportLineTokenizer(){
		setDelimiter(",");
		String[] names = {"identifier","latitude","longitude","elevation"};
		setNames(names);
	}
}
