package com.crimsonpig.fs.processors;

import org.springframework.batch.item.ItemProcessor;

import com.crimsonpig.fs.domain.aircraft.RouteAircraft;
import com.crimsonpig.fs.domain.aircraft.FlightplanAircraft;
import com.crimsonpig.fs.domain.aircraft.InstalledAircraft;
import com.crimsonpig.fs.service.CreateFlightplanAircraftService;
import com.crimsonpig.fs.service.retrieve.RetrieveInstalledAircraftService;

public class FlightplanAircraftProcessor implements
		ItemProcessor<RouteAircraft, FlightplanAircraft> {
	
	private CreateFlightplanAircraftService flightplanAircraftService;
	
	private RetrieveInstalledAircraftService installedAircraftService;
	
	public FlightplanAircraftProcessor(){
		this.flightplanAircraftService = new CreateFlightplanAircraftService();
	}
	
	public void setInstalledAircraftService(RetrieveInstalledAircraftService installedAircraftService){
		this.installedAircraftService = installedAircraftService;
	}
	
	public FlightplanAircraft process(RouteAircraft item) throws Exception {
		InstalledAircraft installedItem = installedAircraftService.retrieveInstalledAircraft(item.getTitle());
		return flightplanAircraftService.createFlightplanAircraft(item, installedItem);
	}

}
