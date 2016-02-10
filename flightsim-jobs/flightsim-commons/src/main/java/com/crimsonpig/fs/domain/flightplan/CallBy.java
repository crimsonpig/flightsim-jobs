package com.crimsonpig.fs.domain.flightplan;

//If this enum is R, ATC will refer to the flight by its tail number.
//If this enum is F, ATC will refer to the flight by its callsign (airline). 
public enum CallBy {
	F, R
}
