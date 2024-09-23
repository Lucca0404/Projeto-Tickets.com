package com.lucca.eventos.entities.Person;

import com.lucca.eventos.entities.Event;

import java.util.HashMap;

public class Manager extends Person {

    private double balance;
    private HashMap<Integer, Event> events = new HashMap<>();

    public void createEvent() {
        
    }
}
