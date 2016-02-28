package com.crimsonpig.fs.service;

public class ProposedFlightLevel {

	private double heading;
	private int lowestFlightLevel;

	public int determineActualFlightLevel(double heading, int lowestFlightLevel) {
		this.heading = heading;
		this.lowestFlightLevel = lowestFlightLevel;
		int toReturn = this.lowestFlightLevel;
		//odd
		if(flightLevelShouldBeAdjustedUp()){
			toReturn += 10;
		}
		return toReturn;
	}
	
	private boolean flightLevelShouldBeAdjustedUp(){
		return (headingIsForOddAltitude() && isLowestFlightLevelEven()) || 
				(headingIsForEvenAltitude() && !isLowestFlightLevelEven());
	}
	
	private boolean headingIsForOddAltitude(){
		return heading < 180;
	}
	
	private boolean headingIsForEvenAltitude(){
		return heading >= 180;
	}
	
	private boolean isLowestFlightLevelEven(){
		return ((lowestFlightLevel / 10) % 2 ) == 0;
	}
}
