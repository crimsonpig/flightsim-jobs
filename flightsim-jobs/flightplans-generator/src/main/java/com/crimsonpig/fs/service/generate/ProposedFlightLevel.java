package com.crimsonpig.fs.service.generate;

public class ProposedFlightLevel {

	private final double heading;
	private final int lowestFlightLevel;
	
	public ProposedFlightLevel(double heading, int lowestFlightLevel) {
		this.heading = heading;
		this.lowestFlightLevel = lowestFlightLevel;
	}
	
	public double getHeading() {
		return heading;
	}
	public int getLowestFlightLevel() {
		return lowestFlightLevel;
	}

	public int determineActualFlightLevel() {
		int toReturn = lowestFlightLevel;
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
