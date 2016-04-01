package com.crimsonpig.fs.exception;

public class RouteExceedsTwentyFourHoursException extends RuntimeException {

	private static final long serialVersionUID = 165609694129375232L;

	public RouteExceedsTwentyFourHoursException(String message) {
		super(message);
	}

}
