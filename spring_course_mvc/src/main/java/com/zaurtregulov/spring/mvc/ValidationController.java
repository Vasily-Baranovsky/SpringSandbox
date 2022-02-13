package com.zaurtregulov.spring.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/employee_validation")
public class ValidationController {

    @RequestMapping("/askDetails")
    public String askEmpDetails(Model model) {

        model.addAttribute("validated_employee", new ValidatedEmployee());
        return "validation-ask-emp-details-view";
    }

//    @RequestMapping(path="/showDetails", method=RequestMethod.GET)
    // alternative synthax
    @GetMapping("/showDetails")
//    @PostMapping("/showDetails")
    public String showEmpDetails(@Valid @ModelAttribute("validated_employee") ValidatedEmployee emp,
                                 BindingResult bindingResult) {

//        System.out.println("surname length = "+emp.getSurname().length());

        if (bindingResult.hasErrors()) {
            return "validation-ask-emp-details-view";
        }

        return "validation-show-emp-details-view";
    }
}
