package com.crimsonpig.fs.stubs;

import com.crimsonpig.fs.domain.route.FullRouteDefinition;

public class FullRouteDefinitionStubs {

	public static FullRouteDefinition getSmfToDen(){
		FullRouteDefinition smfToDen = new FullRouteDefinition();
		smfToDen.setAircraftNumber(1);
		smfToDen.setAircraftTitle("Boeing 737-400 Paint1");
		smfToDen.setAircraftModel("B734");
		smfToDen.setAirline("American Pacific");
		smfToDen.setGroundspeed(430);
		smfToDen.setOriginAirport("KSMF");
		smfToDen.setOriginLatitude(0.67536243);
		smfToDen.setOriginLongitude(-2.12215942);
		smfToDen.setOriginTimezone(-7);
		smfToDen.setDestinationAirport("KDEN");
		smfToDen.setDestinationLatitude(0.69571713);
		smfToDen.setDestinationLongitude(-1.82689160);
		smfToDen.setFlightFrequency(8);
		smfToDen.setLowestFlightLevel(370);
		return smfToDen;
	}
	
}
