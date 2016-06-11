package com.crimsonpig.fs.config.readers;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;

import com.crimsonpig.fs.domain.airport.ConvertedAirport;
import com.crimsonpig.fs.service.retrieve.RetrieveItemFromDataSourceService;

public class ConvertedAirportReader extends RetrieveItemFromDataSourceService {

	private RowMapper<ConvertedAirport> rowMapper;
	
	public ConvertedAirportReader(){
		this.rowMapper = new BeanPropertyRowMapper<ConvertedAirport>(ConvertedAirport.class);
	}
	
	public List<ConvertedAirport> retrieveAirport(String identifier){
		String sql = "SELECT IDENT AS IDENTIFIER, LATITUDE AS LATITUDE_RADIANS, LONGITUDE AS LONGITUDE_RADIANS FROM CONVERTEDAIRPORTS WHERE IDENT= ?";		
		List<ConvertedAirport> foundAirports 
			= getJdbcAccessor().query(sql, rowMapper, identifier);
		return foundAirports;	
	}
	
}
