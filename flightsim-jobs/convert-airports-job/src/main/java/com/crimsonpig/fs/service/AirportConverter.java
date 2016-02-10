package com.crimsonpig.fs.service;

import com.crimsonpig.fs.domain.airport.Airport;
import com.crimsonpig.fs.domain.airport.ConvertedAirport;

public class AirportConverter {

	public ConvertedAirport convertAirport(Airport airport) {
		ConvertedAirport convertedAp = new ConvertedAirport();
		convertedAp.setIdentifier(airport.getIdentifier());
		convertedAp.setElevation(airport.getElevation());
		convertedAp.setLatitudeRadians(convertLatitudeFromString(airport.getLatitude()));
		convertedAp.setLongitudeRadians(convertLongitudeFromString(airport.getLongitude()));
		return convertedAp;
	}

	private double convertLatitudeFromString(String latitude) {
		return latLonStringToRadians(latitude, latitude.charAt(0) == 'S');
	}

	private double convertLongitudeFromString(String longitude) {
		return latLonStringToRadians(longitude, longitude.charAt(0) == 'W');
	}

	private double latLonStringToRadians(String latLonString, boolean isNegative) {
		String degreeString = latLonString.substring(1, latLonString.indexOf("*"));
		String minuteString = latLonString.substring(latLonString.indexOf(' '), latLonString.indexOf("'"));
		double degrees = Double.parseDouble(degreeString);
		double minutes = Double.parseDouble(minuteString);
		double calculatedDegrees = degrees + (minutes / 60);
		double radians = Math.toRadians(calculatedDegrees);
		if(isNegative){
			radians = -radians;
		}
		return radians;
	}
}
