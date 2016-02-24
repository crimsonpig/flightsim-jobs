package com.crimsonpig.fs.processors;

import org.springframework.batch.item.ItemProcessor;

import com.crimsonpig.fs.domain.route.FlightPlanRouteDefinition;
import com.crimsonpig.fs.domain.route.FullRouteDefinition;

public class FlightPlanRouteDefinitionsProcessor implements
		ItemProcessor<FullRouteDefinition, FlightPlanRouteDefinition> {

	@Override
	public FlightPlanRouteDefinition process(FullRouteDefinition item)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
