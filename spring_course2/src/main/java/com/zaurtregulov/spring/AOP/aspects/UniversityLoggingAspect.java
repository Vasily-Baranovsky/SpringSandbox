package com.zaurtregulov.spring.AOP.aspects;

import com.zaurtregulov.spring.AOP.Student;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Aspect
public class UniversityLoggingAspect {
//    @Before("execution(* getStudents())")
//    public void beforeGetStudentsLoggingAdvice() {
//        System.out.println("beforeGetStudentsLoggingAdvice: логируем получение списка студентов перед методом getStudents");
//    }
//
//    @AfterReturning(pointcut="execution(* getStudents())", returning = "students")
//    public void afterReturningGetStudentsLoggingAdvice(List<Student> students) {
//        Student firstStudent = students.get(0);
//        String nameSurname = firstStudent.getNameSurname();
//        nameSurname = "Mr. " + nameSurname;
//        firstStudent.setNameSurname(nameSurname);
//
//        double avrGrade = firstStudent.getAvrGrade();
//        avrGrade +=1;
//        firstStudent.setAvrGrade(avrGrade);
//
//        System.out.println("afterReturningGetStudentsLoggingAdvice: логируем получение списка студентов после работы метода getStudents");
//    }

//    @AfterThrowing(pointcut="execution(* getStudents())", throwing = "ex")
//    public void afterThrowingGetStudentsLoggingAdvice(Throwable ex) {
//        System.out.println("afterThrowingGetStudentsLoggingAdvice: логируем выброс исключения " + ex);
//    }

    @After("execution(* getStudents())")
    public void afterGetStudentsLoggingAdvice() {
        System.out.println("afterGetStudentsLoggingAdvice: логируем нормальное окончание работы метода или выброс исключения");
    }
}
