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
	
	public static ConvertedAirport getSmfAirport(){
		ConvertedAirport smf = new ConvertedAirport();
		smf.setIdentifier("KSMF");
		smf.setLatitudeRadians(0.67536243);
		smf.setLongitudeRadians(-2.12215942);
		return smf;
	}

	public static ConvertedAirport getDenAirport(){
		ConvertedAirport den = new ConvertedAirport();
		den.setIdentifier("KDEN");
		den.setLatitudeRadians(0.69571713);
		den.setLongitudeRadians(-1.82689160);
		return den;
	}
}
