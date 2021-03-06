package com.zaurtregulov.spring.chapter01_spring_introduction;

import org.springframework.beans.factory.annotation.Value;

//@Component("personBean")
public class Person {
//    @Autowired
//    @Qualifier("cat")
    private Pet pet;
    @Value("${person.surname}")
    private String surname;
    @Value("${person.age}")
    private int age;

    public void setSurname(String surname) {
        System.out.println("Class Person: set surname");
        this.surname = surname;
    }

    public void setAge(int age) {
        System.out.println("Class Person: set age");
        this.age = age;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    //@Autowired
    //@Qualifier("dog")
    public void setPet(Pet pet) {
        System.out.println("Class Person: set setPet");
        this.pet = pet;
    }

//    @Autowired
//    public Person(@Qualifier("cat") Pet pet) {
//        System.out.println("Person bean is created");
//        this.pet = pet;
//    }

    public Person(Pet pet) {
        System.out.println("Person bean is created");
        this.pet = pet;
    }

    public Person() {
        System.out.println("Person bean is created");
    }

    public void callYourPet() {
        System.out.println("Hello, my lovely Pet!");
        pet.say();
    }
}
