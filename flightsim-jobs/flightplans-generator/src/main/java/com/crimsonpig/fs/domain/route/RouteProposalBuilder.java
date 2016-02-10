package com.crimsonpig.fs.domain.route;

import com.crimsonpig.fs.domain.airport.ConvertedAirport;

public class RouteProposalBuilder {

	private ConvertedAirport origin;
	private ConvertedAirport destination;
	private int lowestFlightLevel;
	
	public RouteProposalBuilder(ConvertedAirport origin,
			ConvertedAirport destination) {
		this.origin = origin;
		this.destination = destination;
	}


	public RouteProposalBuilder setLowestFlightLevel(int lowestFlightLevel) {
		this.lowestFlightLevel = lowestFlightLevel;
		return this;
	}


	public RouteProposal build() {
		RouteProposal proposal = new RouteProposal();
		proposal.calculateDistanceAndFlightLevels(this);
		return proposal;
	}


	public ConvertedAirport getOrigin() {
		return origin;
	}


	public ConvertedAirport getDestination() {
		return destination;
	}


	public int getLowestFlightLevel() {
		return lowestFlightLevel;
	}

}
