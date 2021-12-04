package com.zaurtregulov.spring.AOP;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class UniLibrary extends AbstractLibrary {
    private int i=0;

    // таким образом мы можем работать в одном контексте и вызывать адвайсы при рекурсивном вызове функций
    @Autowired
    ApplicationContext context;

    //    @Override
    public void getBook() {
        System.out.println("Мы берём книгу из UniLibrary");
        System.out.println("--------------------------------");

        UniLibrary ul = context.getBean("uniLibrary", UniLibrary.class);

        if (ul.i==0) {
            ul.i++;
            System.out.println(ul.i);
//            this.getBook();
            ul.getBook();
            ul.i=0;
        }

//        context.close();
    }

//    public void getBook(Book book) {
//        System.out.println("Мы берём книгу из UniLibrary \""+book.getName()+"\"");
//        getBook();
//    }

    public String returnBook() {
        int a = 10/0;
        System.out.println("Мы возвращаем книгу в UniLibrary");
//        System.out.println("--------------------------------");

        return "Война и мир";
    }

    public void getMagazine() {
        System.out.println("Мы берём журнал");
        System.out.println("--------------------------------");
    }

    public void returnMagazine() {
        System.out.println("Мы возвращаем журнал в UniLibrary");
        System.out.println("--------------------------------");
    }

    public void addBook(String person_name, Book book) {
        System.out.println("Мы добавляем книгу в UniLibrary");
        System.out.println("--------------------------------");
    }
    public void addMagazine() {
        System.out.println("Мы добавляем журнал в UniLibrary");
        System.out.println("--------------------------------");
    }
}
