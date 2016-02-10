package com.crimsonpig.fs.lineaggregators;

import org.springframework.batch.item.file.transform.DelimitedLineAggregator;

import com.crimsonpig.fs.domain.flightplan.FlightPlan;
import com.crimsonpig.fs.domain.flightplan.Leg;

public class FlightPlanLineAggregator extends DelimitedLineAggregator<FlightPlan> {

	@Override
	public String aggregate(FlightPlan item){
		StringBuilder toReturn = new StringBuilder();
		toReturn.append("AC#");
		toReturn.append(item.getAircraftNumber());
		toReturn.append(',');
		toReturn.append(item.getRegistration());
		toReturn.append(',');
		//AC#14,N7169D,74%,12Hr,VFR,04:28,05:31,035,F,8332,KPBI,10:28,11:31,045,F,8331,KBOW
		toReturn.append(item.getPercentage() + "%");
		toReturn.append(',');
		toReturn.append(item.getRepetition());
		toReturn.append(',');
		toReturn.append(item.getFlightRules());
		for(Leg leg : item.getLegs()){
			toReturn.append(',');	
			toReturn.append(leg.getDepartureTime());
			toReturn.append(',');	
			toReturn.append(leg.getArrivalTime());
			toReturn.append(',');	
			toReturn.append(processFlightLevel(leg.getFlightLevel()));
			toReturn.append(',');
			toReturn.append(leg.getfOrR());
			toReturn.append(',');
			toReturn.append(leg.getFlightNumber());
			toReturn.append(',');
			toReturn.append(leg.getArrivalAirport());
		}
		
		return toReturn.toString();		
	}

	private String processFlightLevel(int flightLevel) {
		if(flightLevel < 100){
			return "0" + flightLevel;
		}else{
			return "" + flightLevel;
		}
	}
}
