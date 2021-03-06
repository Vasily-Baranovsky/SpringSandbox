package com.zaurtregulov.spring.chapter03_hibernate01_intro;

import com.zaurtregulov.spring.chapter03_hibernate01_intro.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test4 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        Session session;
        try {
            session = factory.getCurrentSession();
            session.beginTransaction();

//            Employee emp = session.get(Employee.class, 1);
//            emp.setSalary(1500);

            session.createQuery("update Employee set salary=1000 where name='Aleksandr'").executeUpdate();

            session.getTransaction().commit();  // здесь транзакция закрывается
            System.out.println("Done!");
        }
        finally {
            factory.close();
        }
    }
}
