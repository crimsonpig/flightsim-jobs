package com.crimsonpig.fs.stubs;

import com.crimsonpig.fs.domain.airport.ConvertedFS9Airport;

public class ConvertedAirportStubs {
	
	public static ConvertedFS9Airport getLAXAirport(){
		ConvertedFS9Airport lax = new ConvertedFS9Airport();
		lax.setIdentifier("KLAX");
		lax.setElevation(125);
		lax.setLatitudeRadians(0.592409021);
		lax.setLongitudeRadians(-2.06661077);
		return lax;
	}
	
	public static ConvertedFS9Airport getSmfAirport(){
		ConvertedFS9Airport smf = new ConvertedFS9Airport();
		smf.setIdentifier("KSMF");
		smf.setLatitudeRadians(0.67536243);
		smf.setLongitudeRadians(-2.12215942);
		return smf;
	}

	public static ConvertedFS9Airport getDenAirport(){
		ConvertedFS9Airport den = new ConvertedFS9Airport();
		den.setIdentifier("KDEN");
		den.setLatitudeRadians(0.69571713);
		den.setLongitudeRadians(-1.82689160);
		return den;
	}
}
