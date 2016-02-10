package com.crimsonpig.fs.lineaggregators;

import org.springframework.batch.item.file.transform.DelimitedLineAggregator;

import com.crimsonpig.fs.domain.aircraft.FlightplanAircraft;

public class FlightplanAiAircraftAggregator extends DelimitedLineAggregator<FlightplanAircraft> {
	
	@Override
	public String aggregate(FlightplanAircraft item){
		StringBuilder toReturn = new StringBuilder();
		toReturn.append("AC#");
		toReturn.append(item.getAcId());
		toReturn.append(",");
		toReturn.append(item.getGroundspeed());
		toReturn.append(",\"");
		toReturn.append(item.getTitle());
		toReturn.append("\"");
		return toReturn.toString();
	}
}
