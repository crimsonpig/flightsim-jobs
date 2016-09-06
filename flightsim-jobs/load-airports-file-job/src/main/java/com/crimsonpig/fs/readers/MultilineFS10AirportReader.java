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

	private static final String RUNWAY = "RUNWAY";
	private static final String PARKING = "PARKING";
	private static final String CLOSE_CURLY_BRACE = "}";
	
	// Not actually necessary, as it turns out
//	private static final String OPEN_CURLY_BRACE = "{";

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

	private ReadingContext context = null;
	
	@Override
	public Airport read() throws Exception, UnexpectedInputException,
			ParseException, NonTransientResourceException {
		
		context = new ReadingContext();
		
		FieldSet line = null;
		line = delegate.read();

		while(!reachedEndOfAirportRecord(line)){
			if(isHeader(line)){
				context.setAirport(airportFieldSetMapper.mapFieldSet(line));
			} else if(isRunway(line)){
				Runway runway = runwayFieldSetMapper.mapFieldSet(line);
				context.addRunway(runway);						
			} else if(isParkingSpot(line)){
				ParkingSpot parking = parkingFieldSetMapper.mapFieldSet(line);
				context.addParkingSpot(parking);						
			} 
			line = delegate.read();
		}
		Airport toReturn = context.getAirport();
		return toReturn;
	}

	private boolean isHeader(FieldSet line) {
		return context.readyToSetAirportHeader() && 8 == line.getFieldCount();
	}

	private boolean isRunway(FieldSet line) {
		return context.readyToAddRunwaysAndParking() && RUNWAY.equals(line.readString(0));
	}
	
	private boolean isParkingSpot(FieldSet line) {
		return context.readyToAddRunwaysAndParking() && PARKING.equals(line.readString(0));
	}

	private boolean reachedEndOfAirportRecord(FieldSet line) {
		return line == null || isCloseCurlyBrace(line);
	}
	
//	Not actually necessary, it turns out
//	private boolean isOpenCurlyBrace(FieldSet line){
//		return 1 == line.getFieldCount() && OPEN_CURLY_BRACE.equals(line.readString(0));
//	}
	
	private boolean isCloseCurlyBrace(FieldSet line){
		return 1 == line.getFieldCount() && CLOSE_CURLY_BRACE.equals(line.readString(0));
	}

	private class ReadingContext {

		private Airport airport = null;

		public ReadingContext(){}

		public boolean readyToSetAirportHeader() {
			return airport == null;
		}

		public boolean readyToAddRunwaysAndParking(){
			return airport != null;
		}

		public Airport getAirport() {
			return airport;
		}

		public void setAirport(Airport airport) {
			this.airport = airport;
		}
		
		public void addParkingSpot(ParkingSpot parking) {
			getAirport().addParkingSpot(parking);
		}		
		
		public void addRunway(Runway runway){
			getAirport().addRunway(runway);
		}
		
	}
}
