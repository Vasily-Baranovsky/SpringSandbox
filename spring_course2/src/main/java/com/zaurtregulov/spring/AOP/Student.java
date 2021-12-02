package com.zaurtregulov.spring.AOP;

public class Student {
    private String nameSurname;
    private int course;
    private double avrGrade;

    public Student(String nameSurname, int course, double avrGrade) {
        this.nameSurname = nameSurname;
        this.course = course;
        this.avrGrade = avrGrade;
    }

    public String getNameSurname() {
        return nameSurname;
    }

    public void setNameSurname(String nameSurname) {
        this.nameSurname = nameSurname;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public double getAvrGrade() {
        return avrGrade;
    }

    public void setAvrGrade(double avrGrade) {
        this.avrGrade = avrGrade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "nameSurname='" + nameSurname + '\'' +
                ", course=" + course +
                ", avrGrade=" + avrGrade +
                '}';
    }
}
