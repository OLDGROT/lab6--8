package com.example.lab6__8;

import java.util.UUID;

public abstract class Element {
    private UUID id;

    public Element(){
        this.id = UUID.randomUUID();
    }

    public UUID getId() {
        return id;
    }

    abstract public String getTitle();

    abstract public String getDetails();

    abstract public String getDescription();

    abstract public void setTitle( String s);

    abstract public void setDetails(String s);

    abstract public void setDescription(String s);
}
