package com.crimsonpig.fs.domain.route;

import com.crimsonpig.fs.domain.airport.ConvertedAirport;
import com.crimsonpig.fs.service.generate.DistanceAndHeadingService;
import com.crimsonpig.fs.service.generate.ProposedFlightLevel;

public class RouteProposal {

	private double distance;
	private int originToDestinationFlightLevel;
	private int destinationToOriginFlightLevel;
	
	protected RouteProposal(){
		
	}

	protected void calculateDistanceAndFlightLevels(RouteProposalBuilder builder) {
		
		DistanceAndHeading originToDestination = setOriginToDestination(builder);
		DistanceAndHeading destinationToOrigin = setDestinationToOrigin(builder);
		
		setDistance(originToDestination.getDistance(), destinationToOrigin.getDistance());
	}
	
	private DistanceAndHeading setOriginToDestination(RouteProposalBuilder builder){
		DistanceAndHeadingService originToDestinationService = new DistanceAndHeadingService(builder.getOrigin(), builder.getDestination());
		DistanceAndHeading originToDestination = originToDestinationService.computeDistanceAndHeading();
		ProposedFlightLevel oToDFlightLevelProposal = new ProposedFlightLevel(originToDestination.getHeading(), builder.getLowestFlightLevel());
		this.originToDestinationFlightLevel = oToDFlightLevelProposal.determineActualFlightLevel();
		return originToDestination;
	}
	
	private DistanceAndHeading setDestinationToOrigin(RouteProposalBuilder builder){
		DistanceAndHeadingService destinationToOriginService = new DistanceAndHeadingService(builder.getDestination(), builder.getOrigin());
		DistanceAndHeading destinationToOrigin = destinationToOriginService.computeDistanceAndHeading();
		ProposedFlightLevel dToOFlightLevelProposal = new ProposedFlightLevel(destinationToOrigin.getHeading(), builder.getLowestFlightLevel());
		this.destinationToOriginFlightLevel = dToOFlightLevelProposal.determineActualFlightLevel();		
		return destinationToOrigin;
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
