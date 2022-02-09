package com.zaurtregulov.spring.chapter02_AOP;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Book {
    @Value("Преступление и наказание")
    private String name;

    public String getAuthor() {
        return author;
    }

    public int getYearOfPublication() {
        return yearOfPublication;
    }

    @Value("Ф.М. Достоевский")
    private String author;

    @Value("1866")
    private int yearOfPublication;

    public String getName() {
        return name;
    }
}