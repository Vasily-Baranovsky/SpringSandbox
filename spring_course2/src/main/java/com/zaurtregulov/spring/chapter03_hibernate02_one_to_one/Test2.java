package com.zaurtregulov.spring.chapter03_hibernate02_one_to_one;

import com.zaurtregulov.spring.chapter03_hibernate02_one_to_one.entity.Detail;
import com.zaurtregulov.spring.chapter03_hibernate02_one_to_one.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test2 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass((Detail.class))
                .buildSessionFactory();

        Session session = factory.getCurrentSession();
        try {
//            save info with bidirectional attributes

//            Employee employee = new Employee("Nikolai", "Ivanov", "HR", 850);
//            Detail detail = new Detail("New-York", "654123789", "nikolai@gmail.com");
//            employee.setEmpDetail(detail);
//            detail.setEmployee(employee);
//            session.beginTransaction();
//
//            session.save(detail);
//
//            session.getTransaction().commit();
//            System.out.println("Done!");


//            delete details causes deletion of employee

//            session.beginTransaction();
//            Detail detail = session.get(Detail.class, "4");
//            System.out.println(detail.getEmployee());

//            session.beginTransaction();
//            Detail detail = session.get(Detail.class, "4");
//
//            session.delete(detail);
//            session.getTransaction().commit();
//            System.out.println(detail.getEmployee());
//            System.out.println("Done!");


//            delete details only (without employee)
            session.beginTransaction();
            Detail detail = session.get(Detail.class, "1");
            detail.getEmployee().setEmpDetail(null);

            session.delete(detail);
            session.getTransaction().commit();
            System.out.println(detail.getEmployee());
            System.out.println("Done!");
        }
        finally {
            session.close();
            factory.close();
        }
    }
}
