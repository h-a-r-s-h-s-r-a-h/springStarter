package com.dev.springBoot.server.service;

import com.dev.springBoot.server.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();
}
