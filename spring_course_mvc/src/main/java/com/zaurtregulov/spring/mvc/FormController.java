package com.zaurtregulov.spring.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/employee")
public class FormController {

    @RequestMapping("/")
    public String showFirstView() {
        return "first-view";
    }

    @RequestMapping("/askDetails")
    public String askEmpDetails(Model model) {

//        Employee emp = new Employee();
//        emp.setName("Ivan");
//        emp.setSurname("Petrov");
//        emp.setSalary(500);
//        model.addAttribute("employee", emp);
        model.addAttribute("employee", new Employee());
        return "form-ask-emp-details-view";
    }

    @RequestMapping("/showDetails")
    public String showEmpDetails(@ModelAttribute("employee") Employee emp) {

        String name = emp.getName();
        emp.setName("Mr. " + name);

        String surname = emp.getSurname();
        emp.setSurname(surname+"!");

        emp.setSalary(emp.getSalary()*10);

        return "form-show-emp-details-view";
    }
}
