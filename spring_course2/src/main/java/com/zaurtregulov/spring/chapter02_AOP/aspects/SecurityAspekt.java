package com.zaurtregulov.spring.chapter02_AOP.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(20)
public class SecurityAspekt {
    @Before("com.zaurtregulov.spring.chapter02_AOP.aspects.MyPointCuts.allAddMethods()")
    public void beforeAddSecurityAdvice() {
        System.out.println("beforeAddSecurityAdvice: проверка прав на добавление книги/журнала");
        System.out.println("-----------------------------------------------------------------");
    }
}
