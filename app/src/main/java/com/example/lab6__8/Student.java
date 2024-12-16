package com.example.lab6__8;

import java.time.LocalDate;

public class Student extends Element{
    private String name;
    private String secondName;
    private LocalDate birthday;

    public Student(String name, String secondName, LocalDate birthday){
        super();
        this.name = name;
        this.secondName =secondName;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    @Override
    public String getTitle() {
        return secondName + " "+ name;
    }

    @Override
    public String getDetails() {
        return "День рождения " + birthday;
    }
}


