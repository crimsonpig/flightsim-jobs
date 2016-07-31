package com.crimsonpig.fs.config.readers;

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

	public List<FlightplanAircraft> retrieveInstalledAircraftByTitle(String title){
		String sql = "SELECT * FROM FLIGHTPLANAIRCRAFT WHERE TITLE = ? ";		
		List<FlightplanAircraft> foundAircraft 
			= getJdbcAccessor().query(sql, rowMapper, title);
		return foundAircraft;
	}
	
}
