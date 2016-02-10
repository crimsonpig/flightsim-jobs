package com.crimsonpig.fs.service.retrieve;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;

import com.crimsonpig.fs.domain.aircraft.InstalledAircraft;
import com.crimsonpig.fs.domain.airport.ConvertedAirport;
import com.crimsonpig.fs.exception.EntityNotFoundException;

public class RetrieveAirportService extends RetrieveItemFromDataSourceService {

	private RowMapper<ConvertedAirport> rowMapper;
	
	public RetrieveAirportService(){
		this.rowMapper = new BeanPropertyRowMapper<ConvertedAirport>(ConvertedAirport.class);
	}
	
	public ConvertedAirport retrieveAirport(String identifier){
		String sql = "SELECT IDENT AS IDENTIFIER, LATITUDE AS LATITUDE_RADIANS, LONGITUDE AS LONGITUDE_RADIANS FROM CONVERTEDAIRPORTS WHERE IDENT= ?";		
		List<ConvertedAirport> foundAirports 
			= getJdbcAccessor().query(sql, rowMapper, identifier);
		if(foundAirports == null || foundAirports.size() == 0){
			throw new EntityNotFoundException(identifier);
		}
		else{
			ConvertedAirport found =  foundAirports.get(0);
			return found;
		}		
	}
	
}
