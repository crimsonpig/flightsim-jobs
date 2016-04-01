package com.crimsonpig.fs.service.retrieve;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;

import com.crimsonpig.fs.domain.aircraft.InstalledAircraft;
import com.crimsonpig.fs.exception.EntityNotFoundException;

public class RetrieveInstalledAircraftService extends RetrieveItemFromDataSourceService {

	private RowMapper<InstalledAircraft> rowMapper;
	
	public RetrieveInstalledAircraftService(){
		this.rowMapper = new BeanPropertyRowMapper<InstalledAircraft>(InstalledAircraft.class);
	}
		
	public InstalledAircraft retrieveInstalledAircraft(String title) {
		String sql = "SELECT * FROM INSTALLEDAIRCRAFT WHERE TITLE = ?";		
		List<InstalledAircraft> foundAircraft 
			= getJdbcAccessor().query(sql, rowMapper, title);
		return findInstalledAircraft(title, foundAircraft);
	}
	
	protected InstalledAircraft findInstalledAircraft(String title, List<InstalledAircraft> foundAircraft){
		if(foundAircraft == null || foundAircraft.size() == 0){
			throw new EntityNotFoundException(title);
		}
		else{
			return foundAircraft.get(0);
		}
	}

}
