package com.zaurtregulov.spring.AOP.aspects;

import com.zaurtregulov.spring.AOP.Book;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(10)
public class LoggingAspect {


//     Эта штука срабатывает только при внешнем вызове функции getBook
//     Если вызывать getBook рекурсивно саму из себя, то адвайс не работает
//     аналогично если getBook вызвать из другой функции класса Library, а из-вне вызывать именно эту другую функцию
//     (т.е. например, из-вне вызвать getBook(String), а в ней будет вызов getBook(), то адвайс не сработает)
//    @Before("execution(public void *(*))") // один параметр любого типа
//    @Before("execution(public void com.zaurtregulov.spring.AOP.UniLibrary.getBook())")
//    @Before("execution(public void get*())")
//    @Before("execution(public void *(..))") // Любое кол-во любых параметров
//    @Before("execution(public void getBook(com.zaurtregulov.spring.AOP.Book,..))") // первый параметр Book + после 0 и более других параметров
    //@Before("com.zaurtregulov.spring.AOP.aspects.MyPointCuts.allAddMethods()")
    @Before("execution(public void getBook())")
    public void beforeAddLoggingAdvice(JoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature)joinPoint.getSignature();
//        System.out.println("methodSignature = "+methodSignature);
//        System.out.println("methodSignature.getMethod = "+methodSignature.getMethod());
//        System.out.println("methodSignature.getReturnType = "+methodSignature.getReturnType());
//        System.out.println("methodSignature.getName = "+methodSignature.getName());

        if(methodSignature.getName().equals("addBook")) {
            Object[] arguments = joinPoint.getArgs();
            for (Object obj :arguments) {
                if (obj instanceof Book) {
                    Book myBook = (Book) obj;
                    System.out.println("Информация о книге: название - " + myBook.getName() +
                            ", автор - " + myBook.getAuthor() + ", год издания - " + myBook.getYearOfPublication());
                }
                else if (obj instanceof String) {
                    System.out.println("книгу в библиотеку добавляет " + obj);
                }
            }
        }


        System.out.println("beforeAddLoggingAdvice: логирование попытки добавить книгу/журнал");
        System.out.println("-----------------------------------------------------------------");
    }

    // любой access modifier, любой возвращаемый тип, имя метода returnBook, без параметров
    @Before("execution(* returnBook())")
    public void beforeReturnBookAdvice() {
        System.out.println("beforeReturnBookAdvice: попытка вернуть книгу");
        System.out.println("-----------------------------------------------------------------");
    }


// комбинирование PointCut-ов, часть 1
//    @Pointcut("execution(* com.zaurtregulov.spring.AOP.UniLibrary.get*())")
//    private void allGetMethodsFromUniLibrary(){}
//
//    @Pointcut("execution(* com.zaurtregulov.spring.AOP.UniLibrary.return*())")
//    private void allReturnMethodsFromUniLibrary(){}
//
//    @Pointcut("allGetMethodsFromUniLibrary() || allReturnMethodsFromUniLibrary()")
//    private void allGetAndReturnMethodsFromUniLibrary(){}
//
//
//
//    @Before("allGetMethodsFromUniLibrary()")
//    public void beforeGetLoggingAdvice() {
//        System.out.println("beforeGetLoggingAdvice: writing Log #1");
//    }
//
//    @Before("allReturnMethodsFromUniLibrary()")
//    public void beforeReturnLoggingAdvice() {
//        System.out.println("beforeReturnLoggingAdvice: writing Log #2");
//    }
//
//    @Before("allGetAndReturnMethodsFromUniLibrary()")
//    public void beforeGetAndReturnLoggingAdvice() {
//        System.out.println("beforeGetAndReturnLoggingAdvice: writing Log #3");
//    }

    // комбинирование PointCut-ов, часть 2
//    @Pointcut("execution(* com.zaurtregulov.spring.AOP.UniLibrary.*(..))")
//    private void allMethodsFromUniLibrary(){}
//
//    @Pointcut("execution(public void com.zaurtregulov.spring.AOP.UniLibrary.returnMagazine())")
//    private void returnMagazineFromUniLibrary(){}
//
//    @Pointcut("allMethodsFromUniLibrary() && !returnMagazineFromUniLibrary()")
//    private void allMethodsExceptReturnMagazineFromUniLibrary(){}
//
//
//    @Before("allMethodsExceptReturnMagazineFromUniLibrary()")
//    public void beforeAllMethodsExceptReturnMagazineFromUniLibrary() {
//        System.out.println("beforeAllMethodsExceptReturnMagazineFromUniLibrary: writing Log #10");
//    }

}
