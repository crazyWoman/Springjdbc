package com.learning.jdbc;

import com.learning.jdbc.dao.StudentDao;
import com.learning.jdbc.model.Students;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class controller {

    @Autowired
    StudentDao studentDao;

    @PutMapping("/studentLastName/{lastName}/{firstName}/{countryid")
    public void getByLastNameAndFirstName(@PathVariable final String StudentslastName,
                                          @PathVariable final String firstName,
                                          @PathVariable final String countryId) {

        studentDao.update(firstName, StudentslastName, countryId);

    }
}