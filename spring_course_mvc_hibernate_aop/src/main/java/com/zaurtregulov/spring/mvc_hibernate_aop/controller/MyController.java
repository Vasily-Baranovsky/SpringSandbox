package com.zaurtregulov.spring.mvc_hibernate_aop.controller;

import com.zaurtregulov.spring.mvc_hibernate_aop.entity.Employee;
import com.zaurtregulov.spring.mvc_hibernate_aop.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MyController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("showAllEmployees")
    public String showAllEmployees(Model model) {

        List<Employee> allEmployees = employeeService.getAllEmployees();
        model.addAttribute("allEmps", allEmployees);
        return "all-employees";
    }

    @RequestMapping("addNewEmployee")
    public String addNewEmployee(Model model) {
        Employee emp = new Employee();
        model.addAttribute("employee", emp);

        return "employee-info";
    }

    @RequestMapping("saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        employeeService.saveEmployee(employee);

        return "redirect:showAllEmployees";
    }

    @RequestMapping("updateInfo")
    public String updateEmployee(@RequestParam("empId") int id, Model model) {
        Employee emp=employeeService.getEmployeeById(id);
        model.addAttribute("employee", emp);

        return "employee-info";
    }

    @RequestMapping("deleteEmployee")
    public String deleteEmployee(@RequestParam("empId") int id) {
        employeeService.deleteEmployeeById(id);

        return "redirect:showAllEmployees";
    }
}
