package com.example.demotesting.repository;

import com.example.demotesting.model.Employee;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

/*
  @author   george
  @project   demo-testing
  @class  EmployeeMongoRepositoryTest
  @version  1.0.0 
  @since 15.03.22 - 21.26
*/

@DataMongoTest
class EmployeeMongoRepositoryTest {

    List<Employee> list = new ArrayList<>(
            Arrays.asList(
                    new Employee("5", "John","EQI", "C++", "description", LocalDateTime.now(), LocalDateTime.now()),
                    new Employee("6", "Paul","T1", "DevOps", "description", LocalDateTime.now(), LocalDateTime.now()),
                    new Employee("7", "Richard","ACC", "Java Dev", "description", LocalDateTime.now(), LocalDateTime.now()),
                    new Employee("8", "George","T1", "JS Dev", "description", LocalDateTime.now(), LocalDateTime.now())
            )
    );

    @Autowired
    EmployeeMongoRepository underTest;


    @BeforeEach
    void setUp() {
        underTest.saveAll(list);
    }

    @AfterEach
    void tearDown() {
        underTest.deleteAll(list);
    }


    @Test
    void findAllByTeam() {
        List<Employee>  team = underTest.findAllByTeam("T1");
        assertThat(team.size()).isEqualTo(2);
        assertThat(team.get(0))
                .hasFieldOrPropertyWithValue("id", "6");
    }

}
