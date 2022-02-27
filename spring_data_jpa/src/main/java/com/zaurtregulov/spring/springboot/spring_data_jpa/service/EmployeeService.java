package com.zaurtregulov.spring.springboot.spring_data_jpa.service;



import com.zaurtregulov.spring.springboot.spring_data_jpa.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();

    void saveEmployee(Employee emp);

    Employee getEmployeeById(int id);

    void deleteEmployeeById(int id);

    List<Employee> findAllByName(String name);
}
