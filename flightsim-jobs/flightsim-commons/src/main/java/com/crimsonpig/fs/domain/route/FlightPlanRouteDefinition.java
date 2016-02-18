package com.crimsonpig.fs.domain.route;

import com.crimsonpig.fs.domain.aircraft.FlightplanAircraft;

public class FlightPlanRouteDefinition {

	private FlightplanAircraft flightplanAircraft;
	private int originTimezone;
	private int flightFrequency;
	private RouteLeg originToDestination;
	private RouteLeg destinationToOrigin;
	private int minimumHoldTimeInMinutes;

	public FlightplanAircraft getFlightplanAircraft() {
		return flightplanAircraft;
	}

	public void setFlightplanAircraft(FlightplanAircraft flightplanAircraft) {
		this.flightplanAircraft = flightplanAircraft;
	}

	public int getOriginTimezone() {
		return originTimezone;
	}

	public void setOriginTimezone(int originTimezone) {
		this.originTimezone = originTimezone;
	}

	public int getFlightFrequency() {
		return flightFrequency;
	}

	public void setFlightFrequency(int flightFrequency) {
		this.flightFrequency = flightFrequency;
	}

	public RouteLeg getOriginToDestination() {
		return originToDestination;
	}

	public void setOriginToDestination(RouteLeg originToDestination) {
		this.originToDestination = originToDestination;
	}

	public RouteLeg getDestinationToOrigin() {
		return destinationToOrigin;
	}

	public void setDestinationToOrigin(RouteLeg destinationToOrigin) {
		this.destinationToOrigin = destinationToOrigin;
	}
	
	public int getMinimumHoldTimeInMinutes() {
		return minimumHoldTimeInMinutes;
	}

	public void setMinimumHoldTimeInMinutes(int minimumHoldTimeInMinutes) {
		this.minimumHoldTimeInMinutes = minimumHoldTimeInMinutes;
	}

}
