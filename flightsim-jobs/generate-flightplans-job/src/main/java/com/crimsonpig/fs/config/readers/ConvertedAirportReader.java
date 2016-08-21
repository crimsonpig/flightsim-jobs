package com.crimsonpig.fs.config.readers;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;

import com.crimsonpig.fs.domain.airport.ConvertedFS9Airport;
import com.crimsonpig.fs.service.retrieve.RetrieveItemFromDataSourceService;

public class ConvertedAirportReader extends RetrieveItemFromDataSourceService {

	private RowMapper<ConvertedFS9Airport> rowMapper;
	
	public ConvertedAirportReader(){
		this.rowMapper = new BeanPropertyRowMapper<ConvertedFS9Airport>(ConvertedFS9Airport.class);
	}
	
	public List<ConvertedFS9Airport> retrieveAirport(String identifier){
		String sql = "SELECT IDENT AS IDENTIFIER, LATITUDE AS LATITUDE_RADIANS, LONGITUDE AS LONGITUDE_RADIANS FROM CONVERTEDAIRPORTS WHERE IDENT= ?";		
		List<ConvertedFS9Airport> foundAirports 
			= getJdbcAccessor().query(sql, rowMapper, identifier);
		return foundAirports;	
	}
	
}
