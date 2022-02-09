package hibernate03_one_to_many_bi;

import hibernate03_one_to_many_bi.entity.Department;
import hibernate03_one_to_many_bi.entity.Employee;
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
            // first sample many to one bi-directional
//            Department dep = new Department("IT", 300, 1200);
//            Employee emp1 = new Employee("Zaur", "Tregulov", 800);
//            Employee emp2 = new Employee("Elena", "Smirnova", 1000);
//
//            dep.addEmployeeToDepartment(emp1).addEmployeeToDepartment(emp2);
//            session.beginTransaction();
//            session.save(dep);
//
//            session.getTransaction().commit();
//            System.out.println("Done!");
//***************
            // get department and all its employees
//            session.beginTransaction();
//            Department dep = session.get(Department.class, 1);
//
//            System.out.println(dep);
//            System.out.println(dep.getEmps());
//
//            session.getTransaction().commit();
//            System.out.println("Done!");
//***************
            // get employee and infos about his/her department
//            session.beginTransaction();
//            Employee emp = session.get(Employee.class, 1);
//
//            System.out.println(emp);
//            System.out.println(emp.getDepartment());
//
//            session.getTransaction().commit();
//            System.out.println("Done!");
//***************
            // delete 1 employee causes department's deletion and then deletion all employees from department (cascade)
//            session.beginTransaction();
//            Employee emp = session.get(Employee.class, 1);
//
//            session.delete(emp);
//
//            session.getTransaction().commit();
//            System.out.println("Done!");

            /// delete 1 employee without cascade deletion
//            session.beginTransaction();
//            Employee emp = session.get(Employee.class, 4);
//
//            session.delete(emp);
//
//            session.getTransaction().commit();
//            System.out.println("Done!");
//***************

            // eager / lazy. Prepare infrastructure

//            Department dep = new Department("Sales", 800, 1500);
//            Employee emp1 = new Employee("Zaur", "Tregulov", 800);
//            Employee emp2 = new Employee("Elena", "Smirnova", 1500);
//            Employee emp3 = new Employee("Anton", "Sidorov", 1200);
//
//            dep.addEmployeeToDepartment(emp1).addEmployeeToDepartment(emp2).addEmployeeToDepartment(emp3);

            session.beginTransaction();
//            session.save(dep);

            System.out.println("Get department");
            Department department = session.get(Department.class, 15);

            System.out.println("Show department");
            System.out.println(department);

            System.out.println("Подгрузим работников");
            // это поможет избежать эксепшна при getEmps внизу после коммита и Lazy fetch-type
            department.getEmps().isEmpty();

            session.getTransaction().commit();

            System.out.println("Show employees of the department");
            System.out.println(department.getEmps());

            System.out.println("Done!");
        }
        finally {
            session.close();
            factory.close();
        }
    }
}
