package com.example.demotesting.controller.api;
/*
  @author   george
  @project   demo-testing
  @class  EmployeeRestController
  @version  1.0.0 
  @since 15.03.22 - 19.07
*/

import com.example.demotesting.model.Employee;
import com.example.demotesting.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/employees")
public class EmployeeRestController {

    @Autowired
    EmployeeServiceImpl service;

    @GetMapping("/")
    List<Employee> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    Employee getById(@PathVariable("id") String id){
        return service.getOneById(id);
    }

    @DeleteMapping("/{id}")
    void deleteById(@PathVariable("id") String id){
         service.deleteOneById(id);
    }

    @PostMapping("/")
    Employee create(@RequestBody Employee employee){
        return service.create(employee);
    }

    @PutMapping("/")
    Employee update(@RequestBody Employee employee){
        return service.update(employee);
    }




}
