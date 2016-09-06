package com.crimsonpig.fs.mappers;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

import com.crimsonpig.fs.domain.airport.ParkingSpot;
import com.crimsonpig.fs.domain.airport.ParkingType;

public class ParkingSpotFieldSetMapper implements FieldSetMapper<ParkingSpot> {

	@Override
	public ParkingSpot mapFieldSet(FieldSet fieldSet) throws BindException {
		String[] values = fieldSet.getValues();
		ParkingSpot parking = new ParkingSpot();
		parking.setRadius(Double.parseDouble(values[1]));
		parking.setParkingType(ParkingType.valueOf(values[2]));
		return parking;
	}

}
