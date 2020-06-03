package com.accolite.aumanagement.candidate_management.model.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.accolite.aumanagement.candidate_management.model.Trend;



public class TrendRowMapper implements RowMapper<Trend>
{

	@Override
	public Trend mapRow(ResultSet rs, int rowNum) throws SQLException {
		Trend trend = new Trend();
		trend.setCount(rs.getInt("count"));
		trend.setLabel(rs.getString("label"));
		return trend;
	}
}
