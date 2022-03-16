package com.example.demotesting.service;
/*
  @author   george
  @project   demo-testing
  @class  EmployeeServiceImpl
  @version  1.0.0 
  @since 15.03.22 - 18.44
*/

import com.example.demotesting.model.Employee;
import com.example.demotesting.repository.EmployeeMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class EmployeeServiceImpl {


    final private EmployeeMongoRepository repository;

    @Autowired
    public EmployeeServiceImpl(EmployeeMongoRepository repository) {
        this.repository = repository;
    }



    private List<Employee> list = new ArrayList<>(
            Arrays.asList(
                    new Employee("1", "John","EQI", "C++", "description", LocalDateTime.now(), LocalDateTime.now()),
                    new Employee("2", "Paul","RTI", "DevOps", "description", LocalDateTime.now(), LocalDateTime.now()),
                    new Employee("3", "Richard","ACC", "Java Dev", "description", LocalDateTime.now(), LocalDateTime.now()),
                    new Employee("4", "George","INT", "JS Dev", "description", LocalDateTime.now(), LocalDateTime.now())
            )
    );

    @PostConstruct
    void init(){
        repository.saveAll(list);
    }

    public List<Employee> getAll(){
       return repository.findAll();
    }

    public Employee getOneById(String id){
       return repository.findById(id).orElse(null);
    }

    public void deleteOneById(String id){
        repository.deleteById(id);
    }

    public Employee create(Employee employee){

       if(employee.getName().equals("")){
           throw new IllegalStateException("Name  is required");
       }else {

           employee.setCreatedAt(LocalDateTime.now());
           return repository.save(employee);
       }
    }

    public Employee update(Employee employee){
        employee.setUpdatedAt(LocalDateTime.now());
        return repository.save(employee);
    }






}
