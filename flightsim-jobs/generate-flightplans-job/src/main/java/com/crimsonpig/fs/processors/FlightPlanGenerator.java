package com.crimsonpig.fs.processors;

import java.util.List;

import org.springframework.batch.item.ItemProcessor;

import com.crimsonpig.fs.domain.flightplan.*;
import com.crimsonpig.fs.domain.route.FlightPlanRouteDefinition;
import com.crimsonpig.fs.service.GenerateFlightPlanService;

public class FlightPlanGenerator implements
		ItemProcessor<FlightPlanRouteDefinition, List<FlightPlan>> {

	private GenerateFlightPlanService generateService;

	public FlightPlanGenerator(){
		this.generateService = new GenerateFlightPlanService();
	}
	
	public List<FlightPlan> process(FlightPlanRouteDefinition item) throws Exception {
		return generateService.buildFlightPlans(item);
	}

}
