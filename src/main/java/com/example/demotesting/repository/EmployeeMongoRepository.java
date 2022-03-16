package com.example.demotesting.repository;

import com.example.demotesting.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/*
  @author   george
  @project   demo-testing
  @class  EmployeeMongoRepository
  @version  1.0.0 
  @since 15.03.22 - 18.42
*/
@Repository
public interface EmployeeMongoRepository extends MongoRepository<Employee, String> {
    List<Employee> findAllByTeam(String team);
}
