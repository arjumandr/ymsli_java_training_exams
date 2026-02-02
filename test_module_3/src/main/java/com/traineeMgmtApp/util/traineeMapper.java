package com.traineeMgmtApp.util;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.traineeMgmtApp.dto.Trainee;

@Component
public class traineeMapper implements RowMapper<Trainee>{

	@Override
	public Trainee mapRow(ResultSet rs, int rowNum) throws SQLException {
        Trainee t = new Trainee();
        t.setId(rs.getInt("id"));
        t.setTraineeName(rs.getString("traineeName"));
        t.setDepartment(rs.getString("department"));
        return t;
	}
}
