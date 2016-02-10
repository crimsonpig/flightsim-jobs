package com.crimsonpig.fs.processors;

import java.util.List;

import org.springframework.batch.item.ItemProcessor;

import com.crimsonpig.fs.domain.flightplan.*;
import com.crimsonpig.fs.domain.route.FullRouteDefinition;
import com.crimsonpig.fs.service.GenerateFlightPlanService;

public class FlightPlanGenerator implements
		ItemProcessor<FullRouteDefinition, List<FlightPlan>> {

	private GenerateFlightPlanService generateService;

	public FlightPlanGenerator(){
		this.generateService = new GenerateFlightPlanService();
	}
	
	public List<FlightPlan> process(FullRouteDefinition item) throws Exception {
		return generateService.buildFlightPlans(item);
	}

}
