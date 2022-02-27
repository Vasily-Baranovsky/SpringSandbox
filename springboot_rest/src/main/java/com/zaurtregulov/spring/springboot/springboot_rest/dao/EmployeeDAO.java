package com.zaurtregulov.spring.springboot.springboot_rest.dao;


import com.zaurtregulov.spring.springboot.springboot_rest.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> getAllEmployees();
    void saveEmployee(Employee emp);

    Employee getEmployeeById(int id);

    void deleteEmployeeByID(int id);
}
