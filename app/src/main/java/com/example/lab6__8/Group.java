package com.example.lab6__8;

import java.util.ArrayList;
import java.util.List;

public class Group extends Element{
    private String name;
    private String department;
    private String description;

    public Group(String name, String department, String description){
        super();
        this.name =name;
        this.department = department;
        this.description ="Без описания";
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


    @Override
    public String getTitle() {
        return "Группа " + name;
    }

    @Override
    public String getDetails() {
        return "Кафедра " + department;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setTitle(String s) {
        name = s;
    }

    @Override
    public void setDetails(String s) {
        department = s;
    }

    @Override
    public void setDescription(String s) {
        this.description = s;
    }
}
