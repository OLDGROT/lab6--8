package com.example.lab6__8;

import java.util.ArrayList;
import java.util.List;

public class Group extends Element{
    private String name;
    private String department;
    private List<Student> students;

    public Group(String name, String department, List<Student> students){
        super();
        this.name =name;
        this.department = department;
        this.students = students;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void addStudent(Student student){
        students.add(student);
    }

    public void deleteStudent(Student student){
        students.remove(student);
    }

    public void deleteAllStudents(){
        students.removeAll(students);
    }

    @Override
    public String getTitle() {
        return "Группа " + name;
    }

    @Override
    public String getDetails() {
        return "Кафедра " + department;
    }
}
