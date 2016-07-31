package com.crimsonpig.fs.stubs;

import com.crimsonpig.fs.domain.route.SimpleRouteDefinition;

public class SimpleRouteDefinitionStubs {

	public static SimpleRouteDefinition getSmfToDen(){
		SimpleRouteDefinition smfToDen = new SimpleRouteDefinition();
		smfToDen.setTitle("Boeing 737-400");
		smfToDen.setAirline("American Pacific");
		smfToDen.setOriginAirport("KSMF");
		smfToDen.setOriginTimezone(-7);
		smfToDen.setDestinationAirport("KDEN");
		smfToDen.setFlightFrequency(8);
		smfToDen.setLowestFlightLevel(370);
		return smfToDen;
	}
	
}
