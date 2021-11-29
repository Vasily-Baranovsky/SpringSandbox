package com.zaurtregulov.spring.spring_introduction;

public class Dog implements Pet {
//    private String name;

//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getName() {
//        return name;
//    }

    public Dog() {
        System.out.println("Dog bean is created");
    }

    @Override
    public void say() {
        System.out.println("Bow-Wow");
    }

    // тип видимости может быть любым
    // возвращаемый тип может быть любым, но т.к. вызывается спрингом, то использовать его мы не сможем
    protected void init() {
        System.out.println("Class Dog: init method");
    }

    private void destroy() {
        System.out.println("Class Dog: destroy method");
    }
}
