package com.crimsonpig.fs.writers;

import java.util.List;

import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemStream;
import org.springframework.batch.item.ItemStreamException;
import org.springframework.batch.item.ItemStreamWriter;
import org.springframework.batch.item.ItemWriter;

public class ListItemStreamWriter<T> implements ItemStream, ItemWriter<List<T>> {
	
	private ItemStreamWriter<T> itemStreamWriter;
	
	public void setItemStreamWriter(ItemStreamWriter<T> itemWriter){
		this.itemStreamWriter = itemWriter;
	}
	
	public void close(){
		itemStreamWriter.close();
	}

	public void open(ExecutionContext executionContext)
			throws ItemStreamException {
		itemStreamWriter.open(executionContext);
	}

	public void update(ExecutionContext executionContext)
			throws ItemStreamException {
		itemStreamWriter.update(executionContext);
	}
	
	public void write(List<? extends List<T>> listOfItems)
			throws Exception {
		for(List<T> items : listOfItems){
			itemStreamWriter.write(items);
		}
	}

}
