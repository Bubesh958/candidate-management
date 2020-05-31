package com.accolite.aumanagement.candidate_management.model.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.accolite.aumanagement.candidate_management.model.Location;


public class LocationRowMapper implements RowMapper<Location>
{

	@Override
	public Location mapRow(ResultSet rs, int rowNum) throws SQLException {
		Location location = new Location();
		location.setLocationid(rs.getInt("locationid"));
		location.setLocation(rs.getString("location"));
		return location;
	}
	

}
