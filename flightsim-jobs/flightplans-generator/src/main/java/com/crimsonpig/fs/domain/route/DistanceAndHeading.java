package com.crimsonpig.fs.domain.route;

public class DistanceAndHeading {
	
	private final double heading;
	private final double distance;
	
	public DistanceAndHeading(double distance, double heading) {
		this.heading = heading;
		this.distance = distance;
	}

	public double getHeading() {
		return heading;
	}

	public double getDistance() {
		return distance;
	}
	
	

}
