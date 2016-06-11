package com.crimsonpig.fs.stubs;

import com.crimsonpig.fs.domain.airport.ConvertedAirport;

public class ConvertedAirportStubs {
	
	public static ConvertedAirport getLAXAirport(){
		ConvertedAirport lax = new ConvertedAirport();
		lax.setIdentifier("KLAX");
		lax.setElevation(125);
		lax.setLatitudeRadians(0.592409021);
		lax.setLongitudeRadians(-2.06661077);
		return lax;
	}

}
