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
	private static final String OPEN_CURLY_BRACE = "{";
	private static final String CLOSE_CURLY_BRACE = "}";

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
		boolean hasCompleteAirport = false;
		
		FieldSet line = null;
		line = delegate.read();

		while(!hasCompleteAirport && line != null){
			// skip blank lines
			if(isNotBlank(line)){
				if(!inRunwaysAndParking){
					if(isHeader(line)){
						airport = airportFieldSetMapper.mapFieldSet(line);
					} else if(enteringRunwaysAndParking(line)){
						inRunwaysAndParking = true;
					} else {
						throw new RuntimeException("Invalid header data!");
					}
				} else {
					if(isRunway(line)){
						Runway runway = runwayFieldSetMapper.mapFieldSet(line);
						airport.addRunway(runway);						
					} else if(isParkingSpot(line)){
						ParkingSpot parking = parkingFieldSetMapper.mapFieldSet(line);
						airport.addParkingSpot(parking);						
					} else if(exitingRunwaysAndParking(line)){
						inRunwaysAndParking = false;
						hasCompleteAirport = true;
					} else {
						throw new RuntimeException("Invalid runway and parking data!");
					}
				}
			} 	
			line = delegate.read();
		}
		return airport;
	}

	private boolean isNotBlank(FieldSet line) {
		return line.getFieldCount() > 0;
	}

	private boolean isHeader(FieldSet line) {
		return 8 == line.getFieldCount();
	}
	
	private boolean enteringRunwaysAndParking(FieldSet line) {
		return 1 == line.getFieldCount() && OPEN_CURLY_BRACE.equals(line.readString(0));
	}
	
	private boolean isRunway(FieldSet line) {
		return RUNWAY.equals(line.readString(0));
	}
	
	private boolean isParkingSpot(FieldSet line) {
		return PARKING.equals(line.readString(0));
	}

	private boolean exitingRunwaysAndParking(FieldSet line) {
		return 1 == line.getFieldCount() && CLOSE_CURLY_BRACE.equals(line.readString(0));
	}

}
