package com.crimsonpig.fs.processors;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.util.Assert;

import com.crimsonpig.fs.domain.route.DistanceAndHeading;
import com.crimsonpig.fs.domain.route.FlightPlanRouteDefinition;
import com.crimsonpig.fs.domain.route.FullRouteDefinition;
import com.crimsonpig.fs.service.DistanceAndHeadingService;
import com.crimsonpig.fs.service.FlightLevelService;
import com.crimsonpig.fs.service.FlightPlanRouteDefinitionsService;
import com.crimsonpig.fs.service.RouteTimesService;

public class FlightPlanRouteDefinitionsProcessor implements
		ItemProcessor<FullRouteDefinition, FlightPlanRouteDefinition>, InitializingBean {
	
	private DistanceAndHeadingService distanceAndHeadingService;
	
	private FlightLevelService flightLevelService;
	
	private FlightPlanRouteDefinitionsService routeDefinitionsService;
	
	private RouteTimesService routeTimesService;

	public void setDistanceAndHeading(DistanceAndHeadingService distanceAndHeading) {
		this.distanceAndHeadingService = distanceAndHeading;
	}

	public void setFlightLevelService(FlightLevelService flightLevelService) {
		this.flightLevelService = flightLevelService;
	}

	public void setRouteDefinitionsService(
			FlightPlanRouteDefinitionsService routeDefinitionsService) {
		this.routeDefinitionsService = routeDefinitionsService;
	}

	public void setRouteTimesService(RouteTimesService routeTimesService) {
		this.routeTimesService = routeTimesService;
	}

	@Override
	public FlightPlanRouteDefinition process(FullRouteDefinition item)
			throws Exception {

		DistanceAndHeading originToDestination = distanceAndHeadingService.computeDistanceAndHeading(item.getOrigin(), item.getDestination());
		DistanceAndHeading destinationToOrigin = distanceAndHeadingService.computeDistanceAndHeading(item.getDestination(), item.getOrigin());

		if(originToDestination.getDistance() != destinationToOrigin.getDistance()){
			throw new Exception("Distances should be equal!");
		} 
		
		double distance = originToDestination.getDistance();
	
		int outboundFlightLevel = flightLevelService.determineActualFlightLevel(originToDestination.getHeading(), item.getLowestFlightLevel());
		int inboundFlightLevel = flightLevelService.determineActualFlightLevel(destinationToOrigin.getHeading(), item.getLowestFlightLevel());

		FlightPlanRouteDefinition toReturn = routeDefinitionsService.populateFlightPlanRouteDefinition(item);
		toReturn.setOutboundFlightLevel(outboundFlightLevel);
		toReturn.setReturnFlightLevel(inboundFlightLevel);
		toReturn.setDistance(distance);
		
		long routeTime = routeTimesService.calculateRouteTime(distance, item.getGroundspeed());

		toReturn.setRouteTime(routeTime);

		return toReturn;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		Assert.notNull(distanceAndHeadingService, "DistanceAndHeadingService cannot be null!");
		Assert.notNull(flightLevelService, "FlightLevelService cannot be null!");
		Assert.notNull(routeDefinitionsService, "FlightPlanRouteDefinitionsService cannot be null!");
		Assert.notNull(routeTimesService, "RouteTimesService cannot be null!");
	}
	
}
