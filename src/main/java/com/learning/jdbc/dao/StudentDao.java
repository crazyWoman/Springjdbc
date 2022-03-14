package com.learning.jdbc.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.learning.jdbc.mapper.StudentMapper;
import com.learning.jdbc.model.Students;

import java.util.List;

import javax.sql.DataSource;

@Repository
public class StudentDao {


    private final JdbcTemplate jdbcTemplate;
    private final DataSource dataSource;

    public StudentDao(JdbcTemplate jdbcTemplate, DataSource dataSource) {
        this.jdbcTemplate = jdbcTemplate;
        this.dataSource = dataSource;
    }

    public void save(int id,String fname,String lname,String countryid) {
        String sql = "insert into TBL_STUDENTS (id, first_name,last_name, country_id) values (?, ?, ?,?)";
        jdbcTemplate.update(sql, id, fname,lname,
                countryid);
    }

    public void update(String fname,String lname,int countryid) {
        String sql = "update TBL_STUDENTS set country_id = ? where  first_name = ? and last_name= ?";
        jdbcTemplate.update(sql, new Object[] {countryid, fname,lname});
    }

    public List<Students> findByLastName(String lname) {
    	String sql = "select * from TBL_STUDENTS where last_name = ?";
    	return jdbcTemplate.query(sql, new Object[] {lname}, new StudentMapper());
    }
    
}
