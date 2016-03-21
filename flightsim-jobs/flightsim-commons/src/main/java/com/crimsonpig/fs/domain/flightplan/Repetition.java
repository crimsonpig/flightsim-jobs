package com.crimsonpig.fs.domain.flightplan;

public class Repetition {
	
	private final long seconds;
	private final int hours;
	private final int frequency;
	
	private Repetition(long seconds, int frequency) {
		this.seconds = seconds;
		this.hours = (int)(seconds / 3600);
		this.frequency = frequency;
	}

//	public static final Repetition ONE_HOUR = new Repetition(3600, 24);
//	public static final Repetition TWO_HOURS = new Repetition(7200, 12);
	public static final Repetition FOUR_HOURS = new Repetition(14400, 6);
	public static final Repetition SIX_HOURS = new Repetition(21600, 4);
	public static final Repetition EIGHT_HOURS = new Repetition(28800, 3);
	public static final Repetition TWELVE_HOURS = new Repetition(43200, 2);
	public static final Repetition TWENTY_FOUR_HOURS = new Repetition(86400, 1);

	public long getSeconds(){
		return seconds;
	}
	
	public int getHours(){
		return hours;
	}
	
	public String toString(){
		return seconds + "";
	}

	public int getFrequency() {
		return frequency;
	}

}
