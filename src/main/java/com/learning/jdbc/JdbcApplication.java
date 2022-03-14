package com.learning.jdbc;

import com.learning.jdbc.dao.StudentDao;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class JdbcApplication {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(JdbcApplication.class);

        StudentDao studentDao = context.getBean(StudentDao.class);
        studentDao.save(1,"Angel","Hernandez","100");
        studentDao.save(2,"Albert","Hernandez","100");
        studentDao.save(3,"Erik","Hernandez","800");
      //  studentDao.update("Erik","Hernandez","800");
        //studentDao.delete("800");
        studentDao.findStudentById();
    }
}
