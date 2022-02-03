package com.zaurtregulov.spring.chapter02_AOP.aspects;

import org.aspectj.lang.annotation.Pointcut;

public class MyPointCuts {
    @Pointcut("execution(* abc*(..))")
    public void allAddMethods(){}
}
