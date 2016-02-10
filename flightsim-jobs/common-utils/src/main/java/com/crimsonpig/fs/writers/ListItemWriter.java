package com.crimsonpig.fs.writers;

import java.util.List;

import org.springframework.batch.item.ItemWriter;

public class ListItemWriter<T> implements
		ItemWriter<List<T>> {
	
	private ItemWriter<T> itemWriter;
	
	public void setItemWriter(ItemWriter<T> itemWriter){
		this.itemWriter = itemWriter;
	}

	public void write(List<? extends List<T>> listOfItems)
			throws Exception {
		for(List<T> items : listOfItems){
			itemWriter.write(items);
		}
	}

}
