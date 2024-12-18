package com.example.lab6__8;

import android.content.Context;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ElementBank {
    private static ElementBank instance;

    private List<Element> elements;
    private Context appContext;

    private ElementBank() {
        elements = new ArrayList<>();
        Random rand = new Random();
        for(int i = 0; i<100;i++){
            if(i%2 ==0){
                Element element = new Group("2" +i +"VA" + rand.nextInt(4)
                        , "Sapr"
                        , "Любой текст" );
                elements.add(element);
            }else {
                Element element = new MaterialForLecction("Android №" +i
                        , "7a-20" +rand.nextInt(9)
                        , "Отсутсвует" );
                elements.add(element);
            }
        }
    }

    public static ElementBank getInstance() {
        if (instance == null) {
            instance = new ElementBank();
        }
        return instance;
    }

    public void addElement(Element element) {
        elements.add(element);
    }

    public List<Element> getElements() {
        return new ArrayList<>(elements);
    }

    public Element getElementById(int index){
        return elements.get(index);
    }

    public void removeElement(Element element) {
        elements.remove(element);
    }

    public void clear() {
        elements.clear();
    }

    public void setElement(Element element, int index){
        elements.set(index, element);
    }
}
