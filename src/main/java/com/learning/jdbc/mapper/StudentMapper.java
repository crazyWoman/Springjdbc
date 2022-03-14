package com.learning.jdbc.mapper;

import com.learning.jdbc.model.Students;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentMapper implements RowMapper<Students> {
    @Override
    public Students mapRow(ResultSet rs, int rowNum) throws SQLException {
        Students student = new Students();
        student.setId(rs.getInt("id"));
        student.setCountryId(rs.getInt("country_id"));
        student.setFirstName(rs.getString("first_name"));
        student.setLastName(rs.getString("last_name"));
        return student;
    }
}
