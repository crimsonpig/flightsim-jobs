package com.crimsonpig.fs.readers;

import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemStreamException;
import org.springframework.batch.item.ItemStreamReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;

import com.crimsonpig.fs.domain.airport.Airport;
import com.crimsonpig.fs.domain.airport.ParkingSpot;
import com.crimsonpig.fs.domain.airport.Runway;
import com.crimsonpig.fs.mappers.AirportFieldSetMapper;
import com.crimsonpig.fs.mappers.ParkingSpotFieldSetMapper;
import com.crimsonpig.fs.mappers.RunwayFieldSetMapper;


public class MultilineFS10AirportReader implements ItemStreamReader<Airport> {

	private ItemStreamReader<FieldSet> delegate;
	
	private FieldSetMapper<Airport> airportFieldSetMapper;
	private FieldSetMapper<Runway> runwayFieldSetMapper;	
	private FieldSetMapper<ParkingSpot> parkingFieldSetMapper;

	public MultilineFS10AirportReader(ItemStreamReader<FieldSet> delegate){
		this.delegate = delegate;
		this.airportFieldSetMapper = new AirportFieldSetMapper();
		this.runwayFieldSetMapper = new RunwayFieldSetMapper();
		this.parkingFieldSetMapper = new ParkingSpotFieldSetMapper();
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
					airport = airportFieldSetMapper.mapFieldSet(line);
				} else if(line.getFieldCount() == 1 && "{".equals(line.readString(0))){
					inRunwaysAndParking = true;
				}
			} else {
				if(line.getFieldCount() == 1 && "}".equals(line.readString(0))){
					inRunwaysAndParking = false;
					break;
				} else if(line.getFieldCount() > 1){
					if("PARKING".equals(line.readString(0))){
						ParkingSpot parking = parkingFieldSetMapper.mapFieldSet(line);
						airport.addParkingSpot(parking);
					} else if("RUNWAY".equals(line.readString(0))){
						Runway runway = runwayFieldSetMapper.mapFieldSet(line);
						airport.addRunway(runway);
					}
				}
			}
		}
		
		return airport;
	}



}
