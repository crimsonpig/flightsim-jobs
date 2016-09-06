package com.crimsonpig.fs.readers;

import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemStreamException;
import org.springframework.batch.item.ItemStreamReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;

import com.crimsonpig.fs.domain.airport.Airport;
import com.crimsonpig.fs.mappers.AirportFieldSetMapper;


public class MultilineFS10AirportReader implements ItemStreamReader<Airport> {

	private ItemStreamReader<FieldSet> delegate;

	public MultilineFS10AirportReader(ItemStreamReader<FieldSet> delegate){
		this.delegate = delegate;
	}
	
	@Override
	public void open(ExecutionContext executionContext)
			throws ItemStreamException {
		delegate.open(executionContext);
	}

	@Override
	public void update(ExecutionContext executionContext)
			throws ItemStreamException {
		delegate.update(executionContext);
	}

	@Override
	public void close() throws ItemStreamException {
		delegate.close();
	}	
	
	@Override
	public Airport read() throws Exception, UnexpectedInputException,
			ParseException, NonTransientResourceException {
		
		Airport airport = null;
		boolean inRunwaysAndParking = false;
		for(FieldSet line = null; (line = delegate.read()) != null;){
			
			if(!inRunwaysAndParking){
				if(line.getFieldCount() > 1){
					airport = airportFieldSetMapper().mapFieldSet(line);
				} else if(line.getFieldCount() == 1 && "{".equals(line.readString(0))){
					inRunwaysAndParking = true;
				}
			} else {
				if(line.getFieldCount() == 1 && "}".equals(line.readString(0))){
					inRunwaysAndParking = false;
					break;
				} else if(line.getFieldCount() > 1){
					
				}
			}
		}
		
		return airport;
	}

	private FieldSetMapper<Airport> airportFieldSetMapper(){
		AirportFieldSetMapper mapper = new AirportFieldSetMapper();
		return mapper;
	}

}
