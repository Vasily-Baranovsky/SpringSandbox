package com.zaurtregulov.spring.mvc;

import com.zaurtregulov.spring.mvc.validation.CheckEmail;

import javax.validation.constraints.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class ValidatedEmployee {
    @Size(min=2, message = "name must be min 2 symbols")
    private String name;
//    @NotEmpty(message = "surname is required field")
    @NotBlank(message = "surname is required field")
    private String surname;
    @Min(value=500, message="must be greater than 499")
    @Max(value=1000, message="must be less than 1001")
    private int salary;
    private String department;
    private Map<String, String> departments;
    private String carBrand;
    private Map<String, String> carBrands;
    private String[] lanquages;
    private Map<String, String> languageList;
    @Pattern(regexp="[0-9]{3}-[0-9]{2}-[0-9]{2}", message="please use pattern XXX-XX-XX")
    private String phoneNumber;
    @CheckEmail(value="abc.com", message="email must ends with abc.com")
    private String email;

    public ValidatedEmployee() {
        departments = new HashMap<>();
        departments.put("IT", "Information Technology");
        departments.put("HR", "Human Resources");
        departments.put("Sales", "Sales");

        carBrands  = new LinkedHashMap<>();
        carBrands.put("BMW", "BMW");
        carBrands.put("Audi", "Audi");
        carBrands.put("Mersedes-Benz", "MB");

        languageList= new LinkedHashMap<>();
        languageList.put("EN", "English");
        languageList.put("DE", "German");
        languageList.put("FR", "French");
    }

    @Override
    public String toString() {
        return "ValidatedEmployee{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", salary=" + salary +
                ", department='" + department + '\'' +
                ", carBrand='" + carBrand + '\'' +
                ", lanquages=" + Arrays.toString(lanquages) +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Map<String, String> getDepartments() {
        return departments;
    }

    public void setDepartments(Map<String, String> departments) {
        this.departments = departments;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public Map<String, String> getCarBrands() {
        return carBrands;
    }

    public void setCarBrands(Map<String, String> carBrands) {
        this.carBrands = carBrands;
    }

    public String[] getLanquages() {
        return lanquages;
    }

    public void setLanquages(String[] lanquages) {
        this.lanquages = lanquages;
    }

    public Map<String, String> getLanguageList() {
        return languageList;
    }

    public void setLanguageList(Map<String, String> languageList) {
        this.languageList = languageList;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
