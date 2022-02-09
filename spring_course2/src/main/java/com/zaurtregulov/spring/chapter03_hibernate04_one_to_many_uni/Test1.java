package com.zaurtregulov.spring.chapter03_hibernate04_one_to_many_uni;

import com.zaurtregulov.spring.chapter03_hibernate04_one_to_many_uni.entity.Department;
import com.zaurtregulov.spring.chapter03_hibernate04_one_to_many_uni.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test1 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass((Department.class))
                .buildSessionFactory();

        Session session = factory.getCurrentSession();
        try {
            // first sample many-to-one uni-directional. Create
//            Department dep = new Department("HR", 500, 1500);
//            Employee emp1 = new Employee("Oleg", "Ivanov", 800);
//            Employee emp2 = new Employee("Andrey", "Sidorov", 1000);
//
//            dep.addEmployeeToDepartment(emp1).addEmployeeToDepartment(emp2);
//            session.beginTransaction();
//            session.save(dep);
//
//            session.getTransaction().commit();
//            System.out.println("Done!");

            // get department and all its employees
//            session.beginTransaction();
//            Department dep = session.get(Department.class, 2);
//
//            System.out.println(dep);
//            System.out.println(dep.getEmps());
//
//            session.getTransaction().commit();
//            System.out.println("Done!");

            // get employee. Info about his/her department is impossible cause uni-directional connection
//            session.beginTransaction();
//            Employee emp = session.get(Employee.class, 3);
//
//            System.out.println(emp);
//
//            session.getTransaction().commit();
//            System.out.println("Done!");
//***************
            // delete 1 employee doesn't cause department's deletion because employee doesn't know his/her department
//            session.beginTransaction();
//            Employee emp = session.get(Employee.class, 6);
//
//            session.delete(emp);
//
//            session.getTransaction().commit();
//            System.out.println("Done!");

            int depId = prepareTestInfrastructure();
            System.out.println("created DepartmentId is: "+depId);

            // but if we delete a department, so all its employees will be deleted automatically (cascade)
            session.beginTransaction();
            Department dep = session.get(Department.class, depId);

            session.delete(dep);

            session.getTransaction().commit();
            System.out.println("Done!");

        }
        finally {
            session.close();
            factory.close();
        }
    }

    public static int prepareTestInfrastructure() {

        truncateTables();

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass((Department.class))
                .buildSessionFactory();

        Session session = factory.getCurrentSession();
        int res = -1;
        try {
            Department dep = new Department("HR", 500, 1500);
            Employee emp1 = new Employee("Oleg", "Ivanov", 800);
            Employee emp2 = new Employee("Andrey", "Sidorov", 1000);

            dep.addEmployeeToDepartment(emp1).addEmployeeToDepartment(emp2);
            session.beginTransaction();

            session.save(dep);

            session.getTransaction().commit();
            System.out.println("Test data created!");

            res= dep.getId();
        }
        finally {
            session.close();
            factory.close();

            return res;
        }
    }

    public static void truncateTables() {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass((Department.class))
                .buildSessionFactory();

        Session session = factory.getCurrentSession();
        try {
            session.beginTransaction();
            session.createQuery("delete from Employee").executeUpdate();
            session.createQuery("delete from Department").executeUpdate();
            session.getTransaction().commit();
            System.out.println("truncated!");

        }
        finally {
            session.close();
            factory.close();
        }
    }
}
