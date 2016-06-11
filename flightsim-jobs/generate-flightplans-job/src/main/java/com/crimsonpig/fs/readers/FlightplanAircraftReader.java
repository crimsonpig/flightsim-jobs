package com.crimsonpig.fs.readers;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;

import com.crimsonpig.fs.domain.aircraft.FlightplanAircraft;
import com.crimsonpig.fs.service.retrieve.RetrieveItemFromDataSourceService;

public class FlightplanAircraftReader extends RetrieveItemFromDataSourceService {

	private RowMapper<FlightplanAircraft> rowMapper;
	
	public FlightplanAircraftReader(){
		this.rowMapper = new BeanPropertyRowMapper<FlightplanAircraft>(FlightplanAircraft.class);
	}

	public List<FlightplanAircraft> retrieveInstalledAircraftFromAirlineAndModel(String airline, String model) {
		String sql = "SELECT * FROM FLIGHTPLANAIRCRAFT WHERE AIRLINE = ? AND ATC_MODEL = ?";		
		List<FlightplanAircraft> foundAircraft 
			= getJdbcAccessor().query(sql, rowMapper, airline, model);
		return foundAircraft;
	}
	
}
