package com.example.lab6__8;

import java.time.LocalDate;

public class MaterialForLecction extends Element {
    private String tema;
    private LocalDate date;
    private String description;

    public MaterialForLecction(String tema, LocalDate date, String description){
        super();
        this.tema = tema;
        this.date = date;
        this.description =description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String getTitle() {
        return "Тема лекции: " + tema;
    }

    @Override
    public String getDetails() {
        return "Дата проведения" + date;
    }
}
