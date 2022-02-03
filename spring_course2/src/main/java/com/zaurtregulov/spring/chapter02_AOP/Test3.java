package com.zaurtregulov.spring.chapter02_AOP;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test3 {
    public static void main(String[] args) {
        System.out.println("Method Main starts");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);


        UniLibrary ul = context.getBean("uniLibrary", UniLibrary.class);
        String bookName = ul.returnBook();
        System.out.println("В библиотеку вернули книгу " + bookName);

        context.close();

        System.out.println("Method Main ends");
    }
}
