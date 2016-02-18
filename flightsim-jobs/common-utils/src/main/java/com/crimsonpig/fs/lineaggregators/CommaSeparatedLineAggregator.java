package com.crimsonpig.fs.lineaggregators;

import org.springframework.batch.item.file.transform.DelimitedLineAggregator;

public abstract class CommaSeparatedLineAggregator<T> extends DelimitedLineAggregator<T> {

	public CommaSeparatedLineAggregator(){
		setDelimiter(",");
	}

}
