package com.crimsonpig.fs.mappers;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

import com.crimsonpig.fs.domain.airport.Runway;
import com.crimsonpig.fs.domain.airport.Surface;

public class RunwayFieldSetMapper implements FieldSetMapper<Runway> {

	@Override
	public Runway mapFieldSet(FieldSet fieldSet) throws BindException {
		String[] values = fieldSet.getValues();
		Runway toReturn = new Runway();
		//values[0] is merely the word "RUNWAY" and will not be mapped
		toReturn.setLength(Integer.parseInt(values[1]));
		toReturn.setWidth(Integer.parseInt(values[2]));
		toReturn.setSurface(Surface.valueOf(values[3]));
		return toReturn;
	}

}
