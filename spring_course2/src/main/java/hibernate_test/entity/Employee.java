package hibernate_test.entity;

import javax.persistence.*;

@Entity
@Table(name="employees")
public class Employee {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")      // better to write column name (name="id"), but it's not obligatory
    private int id;
    @Column(name="name")    // if column name and variable name are equal, it's allowed not to write (name="name")
    private String firstname;
    @Column
    private String surname;
    @Column
    private String department;
    @Column
    private int salary;

    public Employee() {}

    @Override
    public String toString() {
        return "Employee{" +
                "id="+id+
                ", name='"+ firstname +"'"+
                ", surname='"+surname+"'"+
                ", department='"+department+"'"+
                ", salary="+salary +
                "}";
    }


    public Employee(String name, String surname, String department, int salary) {
        this.firstname = name;
        this.surname = surname;
        this.department = department;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
