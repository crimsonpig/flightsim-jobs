package com.crimsonpig.fs.processors;

import org.springframework.batch.item.ItemProcessor;

import com.crimsonpig.fs.domain.route.FlightPlanRouteDefinition;
import com.crimsonpig.fs.domain.route.FullRouteDefinition;
import com.crimsonpig.fs.service.DistanceAndHeadingService;

public class FlightPlanRouteDefinitionsProcessor implements
		ItemProcessor<FullRouteDefinition, FlightPlanRouteDefinition> {

	private DistanceAndHeadingService distanceAndHeading;

	public void setDistanceAndHeading(DistanceAndHeadingService distanceAndHeading) {
		this.distanceAndHeading = distanceAndHeading;
	}

	@Override
	public FlightPlanRouteDefinition process(FullRouteDefinition item)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
