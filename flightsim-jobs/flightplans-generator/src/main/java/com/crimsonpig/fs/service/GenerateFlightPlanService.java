package com.crimsonpig.fs.service;


import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import com.crimsonpig.fs.domain.flightplan.FlightPlan;
import com.crimsonpig.fs.domain.flightplan.Leg;
import com.crimsonpig.fs.domain.flightplan.Repetition;
import com.crimsonpig.fs.domain.route.FlightPlanRouteDefinition;
import com.crimsonpig.fs.service.generate.*;


public class GenerateFlightPlanService {

	private static final long ONE_HOUR_IN_SECONDS = 3600;
	
	private long defaultHoldTime = ONE_HOUR_IN_SECONDS;
	
	private AircraftRegistrationGenerator registrationGenerator;
	private PercentageGenerator percentageGenerator;
	private StartTimeSequenceGenerator startTimesGenerator;
	private FlightPlanBuilder flightPlanBuilder;
	private RepetitionBuilder repetitionBuilder;
	private FlightNumberGenerator flightNumberGenerator;
	
	public GenerateFlightPlanService(){
		registrationGenerator = new AircraftRegistrationGenerator();
		percentageGenerator = new PercentageGenerator();
		startTimesGenerator = new StartTimeSequenceGenerator();
		flightPlanBuilder = new FlightPlanBuilder();
		repetitionBuilder = new RepetitionBuilder();
		flightNumberGenerator = new FlightNumberGenerator();
	}

	public List<FlightPlan> buildFlightPlans(FlightPlanRouteDefinition item) {

		RouteTime routeTimes = new RouteTime(item.getRouteTime(), defaultHoldTime);
		Repetition repetition = repetitionBuilder.buildFromSeconds(routeTimes);
		
		int numberOfFlightPlans = flightPlanBuilder.getNumberOfFlightPlans(item.getFlightFrequency(), repetition);
		List<FlightPlan> output = new ArrayList<FlightPlan>(numberOfFlightPlans);
		
		List<LocalTime> startTimes = startTimesGenerator
				.generateSequenceOfStartTimes(item.getOriginTimezone(), numberOfFlightPlans, routeTimes.getSingleRepetitionSeconds());
	
		int flightPlanIdx = 0;
		while(flightPlanIdx < numberOfFlightPlans){
			FlightPlan flightPlan = new FlightPlan();

			List<Leg> legs = new ArrayList<Leg>(2);
			Leg outboundLeg = new Leg();
			Leg returnLeg = new Leg();
			
			LocalTime departureTime = startTimes.get(flightPlanIdx);
			LocalTime arrivalTime = departureTime.plusSeconds(routeTimes.getRouteLegSeconds());
			LocalTime returnDepartureTime = departureTime.plusSeconds(routeTimes.getMinimumLegSeconds());
			LocalTime returnArrivalTime = returnDepartureTime.plusSeconds(routeTimes.getRouteLegSeconds());
			
			outboundLeg.setDepartureTime(departureTime);
			outboundLeg.setArrivalTime(arrivalTime);
			returnLeg.setDepartureTime(returnDepartureTime);
			returnLeg.setArrivalTime(returnArrivalTime);
			outboundLeg.setFlightNumber(flightNumberGenerator.generateRandomFlightNumber());
			returnLeg.setFlightNumber(outboundLeg.getFlightNumber() + 1);
			
			if(flightPlanIdx % 2 == 0){
				outboundLeg.setDepartureAirport(item.getOriginAirport());
				outboundLeg.setArrivalAirport(item.getDestinationAirport());	
				outboundLeg.setFlightLevel(item.getOutboundFlightLevel());

				returnLeg.setDepartureAirport(item.getDestinationAirport());
				returnLeg.setArrivalAirport(item.getOriginAirport());
				returnLeg.setFlightLevel(item.getReturnFlightLevel());
				
			} else {
				outboundLeg.setDepartureAirport(item.getDestinationAirport());
				outboundLeg.setArrivalAirport(item.getOriginAirport());
				outboundLeg.setFlightLevel(item.getReturnFlightLevel());
				
				returnLeg.setDepartureAirport(item.getOriginAirport());
				returnLeg.setArrivalAirport(item.getDestinationAirport());
				returnLeg.setFlightLevel(item.getOutboundFlightLevel());
			}
			legs.add(outboundLeg);
			legs.add(returnLeg);
			flightPlan.setLegs(legs);
			
			flightPlan.setRepetition(repetition);
			flightPlan.setAirline(item.getAirline());
			flightPlan.setAircraftTitle(item.getAircraftTitle());
			flightPlan.setAircraftNumber(item.getAircraftNumber());
			flightPlan.setRegistration(registrationGenerator.getRandomAmericanRegistration());
			flightPlan.setPercentage(percentageGenerator.getRandomPercentage());
			output.add(flightPlan);
			flightPlanIdx++;
		}
		
		return output;
	}

}
