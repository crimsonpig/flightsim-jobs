package com.crimsonpig.fs.service.generate;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.crimsonpig.fs.domain.route.FullRouteDefinition;
import com.crimsonpig.fs.domain.route.RouteProposal;
import com.crimsonpig.fs.domain.route.RouteProposalBuilder;

public class RouteProposalTest {

	
	@Test
	public void createRouteProposal(){
		
		FullRouteDefinition ontToPhx = new FullRouteDefinition();
		ontToPhx.setOriginAirport("KONT");
		ontToPhx.setOriginLatitude(0.59438933);
		ontToPhx.setOriginLongitude(-2.05252806);
		ontToPhx.setDestinationAirport("KPHX");
		ontToPhx.setDestinationLatitude(0.58353824);
		ontToPhx.setDestinationLongitude(-1.95497093);
		ontToPhx.setLowestFlightLevel(290);
		
		RouteProposal routeProposal = new RouteProposalBuilder(ontToPhx.getOrigin(), ontToPhx.getDestination())
			.setLowestFlightLevel(ontToPhx.getLowestFlightLevel()).build();
		int ontToPhxFlightLevel = routeProposal.getOriginToDestinationFlightLevel();
		int phxToOntFlightLevel = routeProposal.getDestinationToOriginFlightLevel();
		double distance = routeProposal.getDistance();
		assertEquals(290, ontToPhxFlightLevel);
		assertEquals(300, phxToOntFlightLevel);
		assertEquals(282, distance, 0.7);
	}
	
	@Test
	public void createAnotherRouteProposal(){
	
		FullRouteDefinition smfToDen = new FullRouteDefinition();
		smfToDen.setOriginAirport("KSMF");
		smfToDen.setOriginLatitude(0.67536243);
		smfToDen.setOriginLongitude(-2.12215942);
		smfToDen.setDestinationAirport("KDEN");
		smfToDen.setDestinationLatitude(0.69571713);
		smfToDen.setDestinationLongitude(-1.82689160);
		smfToDen.setLowestFlightLevel(370);
		
		RouteProposal routeProposal = new RouteProposalBuilder(smfToDen.getOrigin(), smfToDen.getDestination())
			.setLowestFlightLevel(smfToDen.getLowestFlightLevel()).build();
		int ontToPhxFlightLevel = routeProposal.getOriginToDestinationFlightLevel();
		int phxToOntFlightLevel = routeProposal.getDestinationToOriginFlightLevel();
		double distance = routeProposal.getDistance();
		assertEquals(370, ontToPhxFlightLevel);
		assertEquals(380, phxToOntFlightLevel);
		assertEquals(788, distance, 0.5);
	}
}
