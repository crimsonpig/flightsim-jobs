package com.crimsonpig.fs.readers;

import org.springframework.batch.item.database.ItemSqlParameterSourceProvider;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import com.crimsonpig.fs.domain.airport.Airport;

public class AirportSqlParameterSource implements
		ItemSqlParameterSourceProvider<Airport> {

	public static final String LOAD_AIRPORTS_SQL = "INSERT INTO AIRPORTS(IDENT, LATITUDE, LONGITUDE, ALTITUDE, AIRSPACE, NUM_APPROACH_FREQS, TRAFFIC_SCALAR, COUNTRY) VALUES(:identifier, :latitude, :longitude, :altitude, :airspace, :approachFrequencies, :trafficScalar, :country";

	@Override
	public SqlParameterSource createSqlParameterSource(Airport item) {
		MapSqlParameterSource mapSql = new MapSqlParameterSource(); 
		mapSql.addValue("identifier", item.getIdentifier());
		mapSql.addValue("latitude", item.getLatitudeDegrees());
		mapSql.addValue("longitude", item.getLongitudeDegrees());
		mapSql.addValue("altitude", item.getAltitude());
		mapSql.addValue("airspace", item.getAirspace().toString());
		mapSql.addValue("approachFrequencies", item.getApproachFrequencies());
		mapSql.addValue("trafficScalar", item.getTrafficScalar());
		mapSql.addValue("country", item.getCountry());
		return mapSql;
	}

}
