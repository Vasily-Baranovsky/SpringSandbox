package com.zaurtregulov.spring.chapter01_spring_introduction;

//@Component
public class Cat implements Pet{
    public Cat() {
        System.out.println("Cat bean is created");
    }

    @Override
    public void say() {
        System.out.println("Meow-Meow");
    }
}
