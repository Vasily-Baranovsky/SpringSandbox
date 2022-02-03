package com.zaurtregulov.spring.chapter02_AOP.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(30)
public class ExceptionHandlingAspekt {
    @Before("com.zaurtregulov.spring.chapter02_AOP.aspects.MyPointCuts.allAddMethods()")
    public void beforeAddExceptionHandlingAdvice() {
        System.out.println("beforeAddExceptionHandlingAdvice: ловим/обрабатываем исключения при попытке добавить книгу/журнал");
        System.out.println("-----------------------------------------------------------------");
    }
}
