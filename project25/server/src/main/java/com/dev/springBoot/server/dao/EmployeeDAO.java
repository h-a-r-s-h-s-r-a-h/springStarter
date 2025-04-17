package com.dev.springBoot.server.dao;

import com.dev.springBoot.server.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();
}
