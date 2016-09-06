package com.crimsonpig.fs.mappers;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

import com.crimsonpig.fs.domain.airport.Airport;
import com.crimsonpig.fs.domain.airport.Airspace;

public class AirportFieldSetMapper implements FieldSetMapper<Airport> {

	@Override
	public Airport mapFieldSet(FieldSet fieldSet) throws BindException {
		String[] values = fieldSet.getValues();
		Airport toReturn = new Airport();
		toReturn.setIdentifier(values[0]);
		toReturn.setLatitudeDegrees(Double.parseDouble(values[1]));
		toReturn.setLongitudeDegrees(Double.parseDouble(values[2]));
		toReturn.setAltitude(Double.parseDouble(values[3]));
		toReturn.setAirspace(Airspace.valueOf(values[4]));
		toReturn.setApproachFrequencies(Integer.parseInt(values[5]));
		toReturn.setTrafficScalar(Double.parseDouble(values[6]));
		toReturn.setCountry(values[7]);
		return toReturn;
	}

}
