package com.zaurtregulov.spring.chapter02_AOP;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Test2 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);

        University uni =context.getBean("university", University.class);
        uni.addStudents();
        try {
            List<Student> students = uni.getStudents();
            System.out.println(students);
        }
        catch (Exception ex) {
            System.out.println("Было поймано исключение " + ex);
        }



        context.close();
    }
}
