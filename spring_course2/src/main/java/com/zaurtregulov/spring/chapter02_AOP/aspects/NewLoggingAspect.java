package com.zaurtregulov.spring.chapter02_AOP.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class NewLoggingAspect {

    @Around("execution(public String returnBook())")
    public Object aroundReturnBookLoggingAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("aroundReturnBookLoggingAdvice: В библиотеку пытаются вернуть книгу");

//        long begin = System.currentTimeMillis();
        Object targetMethodResult;
        try {
            targetMethodResult = proceedingJoinPoint.proceed();
        }
        catch (Exception ex) {
            System.out.println("aroundReturnBookLoggingAdvice: Было поймано исключение " + ex);
//            targetMethodResult = "Неизвестное название книги";
            throw ex;
        }
//        long end = System.currentTimeMillis();

//        targetMethodResult = "Преступление и наказание";

        System.out.println("aroundReturnBookLoggingAdvice: В библиотеку успешно вернули книгу");
//        System.out.println("aroundReturnBookLoggingAdvice: Method returnBook выполнил работу за " + (end-begin) + " мс");

        return targetMethodResult;
    }
}
