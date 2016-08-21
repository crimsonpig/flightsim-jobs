package com.crimsonpig.fs.service;

import com.crimsonpig.fs.domain.airport.FS9Airport;
import com.crimsonpig.fs.domain.airport.ConvertedFS9Airport;

public class AirportConverter {

	public ConvertedFS9Airport convertAirport(FS9Airport fS9Airport) {
		ConvertedFS9Airport convertedAp = new ConvertedFS9Airport();
		convertedAp.setIdentifier(fS9Airport.getIdentifier());
		convertedAp.setElevation(fS9Airport.getElevation());
		convertedAp.setLatitudeRadians(convertLatitudeFromString(fS9Airport.getLatitude()));
		convertedAp.setLongitudeRadians(convertLongitudeFromString(fS9Airport.getLongitude()));
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
