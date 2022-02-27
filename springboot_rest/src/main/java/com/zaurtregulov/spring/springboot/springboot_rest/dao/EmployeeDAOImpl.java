package com.zaurtregulov.spring.springboot.springboot_rest.dao;

import com.zaurtregulov.spring.springboot.springboot_rest.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List getAllEmployees() {
//        Session session = entityManager.unwrap(Session.class);
//        Query<Employee> query = session.createQuery("from Employee", Employee.class);
//
//        return query.getResultList();
        Query query = entityManager.createQuery("from Employee");
        return query.getResultList();
    }

    @Override
    public void saveEmployee(Employee emp) {
//        Session session = entityManager.unwrap(Session.class);
//        session.saveOrUpdate(emp);

        Employee newEmp = entityManager.merge(emp);
        emp.setId(newEmp.getId());
    }

    @Override
    public Employee getEmployeeById(int id) {
//        return entityManager.unwrap(Session.class).get(Employee.class, id);
        return entityManager.find(Employee.class, id);
    }

    @Override
    public void deleteEmployeeByID(int id) {
//        Session session = entityManager.unwrap(Session.class);
//        Query<?> query = session.createQuery("delete from Employee where id=:employeeId");
//        query.setParameter("employeeId", id);
//        query.executeUpdate();
        Query query = entityManager.createQuery("delete from Employee where id=:employeeId");
        query.setParameter("employeeId", id);
        query.executeUpdate();
    }
}
