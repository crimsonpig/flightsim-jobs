package com.crimsonpig.fs.service.retrieve;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;

import com.crimsonpig.fs.domain.aircraft.FlightplanAircraft;
import com.crimsonpig.fs.exception.EntityNotFoundException;

public class RetrieveFlightplanAircraftService extends RetrieveItemFromDataSourceService {

	private RowMapper<FlightplanAircraft> rowMapper;
	
	public RetrieveFlightplanAircraftService(){
		this.rowMapper = new BeanPropertyRowMapper<FlightplanAircraft>(FlightplanAircraft.class);
	}

	public FlightplanAircraft retrieveInstalledAircraftFromAirlineAndModel(String airline, String model) {
		String sql = "SELECT * FROM FLIGHTPLANAIRCRAFT WHERE AIRLINE = ? AND ATC_MODEL = ?";		
		List<FlightplanAircraft> foundAircraft 
			= getJdbcAccessor().query(sql, rowMapper, airline, model);
		if(foundAircraft == null || foundAircraft.isEmpty()){
			throw new EntityNotFoundException("airline = " + airline + ", model = " + model);
		}
		else if(foundAircraft.size() > 1){
			throw new RuntimeException("More than one aircraft found for airline = " + airline + " and model = " + model);
		}
		else{
			return foundAircraft.get(0);
		}
	}

}
