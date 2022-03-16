package com.example.demotesting.service;

import com.example.demotesting.repository.EmployeeMongoRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/*
  @author   george
  @project   demo-testing
  @class  EmployeeServiceImplTest
  @version  1.0.0 
  @since 16.03.22 - 12.21
*/

class EmployeeServiceImplTest {

    @Mock
    EmployeeMongoRepository repository;

    EmployeeServiceImpl underTest;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        underTest = new EmployeeServiceImpl(repository);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void itShouldNotCreateWhenNameIsEmpty() {
    }
}
