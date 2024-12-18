package com.example.lab6__8;

import java.time.LocalDate;

public class MaterialForLecction extends Element {
    private String tema;
    private String cabinet;
    private String description;

    public MaterialForLecction(String tema, String cabinet, String description){
        super();
        this.tema = tema;
        this.cabinet = cabinet;
        this.description =description;
    }

    public String getDescription() {
        return description;
    }


    public String getCabinet() {
        return cabinet;
    }

    public void setCabinet(String cabinet) {
        this.cabinet = cabinet;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    @Override
    public String getTitle() {
        return "Тема лекции: " + tema;
    }

    @Override
    public String getDetails() {
        return "Кабинет: " + cabinet;
    }

    @Override
    public void setTitle(String s) {
        tema = s;
    }

    @Override
    public void setDetails(String s) {
        cabinet = s;
    }

    @Override
    public void setDescription(String s) {
        this.description = s;
    }
}
