package com.zaurtregulov.spring.rest;

import com.zaurtregulov.spring.rest.configuration.MyConfig;
import com.zaurtregulov.spring.rest.entity.Employee;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        Communication communication = context.getBean("communication", Communication.class);

//        Список всех сотрудников
//        List<Employee> allEmployees = communication.getAllEmployees();
//        System.out.println(allEmployees);

//      Прочитать инфу о сотруднике по ID
//        Employee emp = communication.getEmployee(2);
//        System.out.println(emp);

//      Получить эксепшон, что запрошенный сотрдуник не существует
//        emp = communication.getEmployee(1000);
//        System.out.println(emp);

//      Добавить нового сотрудника
//        Employee emp = new Employee("Света", "Соколова", "HR", 900);
//        communication.saveEmployee(emp);

//      Изменить сотрудника, добавленного в предыдущем шаге
//        Employee emp = new Employee("Света", "Соколова", "IT", 1200);
//        emp.setId(8);
//        communication.saveEmployee(emp);

//      Удалить сотрудника, добавленного в пред-предыдущем шаге
//        communication.deleteEmployee(8);

//      Получить эксепшон, что удаляемый сотрдуник не существует
//        communication.deleteEmployee(100);
    }
}
