package com.learning.jdbc;

import com.learning.jdbc.dao.StudentDao;
import com.learning.jdbc.model.Students;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class JdbcApplication {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(JdbcApplication.class);

        StudentDao studentDao = context.getBean(StudentDao.class);
        studentDao.save(1,"Angel","Hernandez","100");
        studentDao.save(2,"Eric", "Hernandez","800");
        studentDao.update("Eric", "Hernandez", 1500);
        List<Students> student = studentDao.findByLastName("Hernandez");
        System.out.println(student.toString());
    }
}
