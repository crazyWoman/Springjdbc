package com.learning.jdbc.dao;

import com.learning.jdbc.mapper.StudentMapper;
import com.learning.jdbc.model.Students;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Repository
public class StudentDao {


    private final JdbcTemplate jdbcTemplate;
    private final NamedParameterJdbcOperations namedParameterJdbcOperations;
    private final DataSource dataSource;


    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    public StudentDao(JdbcTemplate jdbcTemplate, NamedParameterJdbcOperations namedParameterJdbcOperations, DataSource dataSource) {
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcOperations = namedParameterJdbcOperations;
        this.dataSource = dataSource();
    }

    public void save(int id,String fname,String lname,String countryid) {
        String sql = "insert into TBL_STUDENTS (id, first_name,last_name, country_id) values (?, ?, ?,?)";
        jdbcTemplate.update(sql, id, fname,lname,
                countryid);
    }

    public void update(String fname,String lname,String countryid) {
        String sql = "UPDATE TBL_STUDENTS SET COUNTRY_ID = ? WHERE FIRST_NAME = ? and Last_name= ?)";
        jdbcTemplate.update(sql, countryid, fname,lname);
    }

    public void delete(String  ID) {
        String sql = "delete  TBL_STUDENTS TD WHERE TD.ID = ? )";
        jdbcTemplate.update(sql, ID);
    }

    public void findStudentById(){

        String sql = "select top 1 from TBL_STUDENTS  )";
       /* Map<String, Object> params = new HashMap<String, Object>();
        params.put("fname", fname);*/
        Students student = jdbcTemplate.queryForObject(sql,new StudentMapper());
        System.out.println(student);

    }

}
