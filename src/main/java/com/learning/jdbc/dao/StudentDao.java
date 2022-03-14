package com.learning.jdbc.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

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
        String sql = "update TBL_STUDENTS set country_id = ? where  first_name = ? and last_name= ?)";
        jdbcTemplate.update(sql, countryid, fname,lname
                );
    }

}
