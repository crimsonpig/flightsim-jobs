package com.crimsonpig.fs.domain.route;

public class RouteProposal {

	private double distance;
	private int originToDestinationFlightLevel;
	private int destinationToOriginFlightLevel;
	
	protected RouteProposal(){
		
	}

	private void setDistance(double outboundDistance, double inboundDistance){
		//verify distances are equal
		if(outboundDistance != inboundDistance){
			throw new RuntimeException("Distances should be equal!");
		} else {
			this.distance = outboundDistance;
		}
	}
	
	public int getOriginToDestinationFlightLevel() {
		return originToDestinationFlightLevel;
	}


	public int getDestinationToOriginFlightLevel() {
		return destinationToOriginFlightLevel;
	}


	public double getDistance() {
		return distance;
	}

}
