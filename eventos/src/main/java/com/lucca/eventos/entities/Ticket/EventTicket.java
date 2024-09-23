package com.lucca.eventos.entities.Ticket;

import com.lucca.eventos.entities.Event;
import com.lucca.eventos.service.GenerateIds;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EventTicket implements Ticket {

    private String description;
    private String type;
    private String name;
    private double price;
    private int quantity;
    private int id;

    public EventTicket() {
        this.type = "Event";
        this.id = GenerateIds.generateEventTicketId();
    }

    public boolean validateTicket(){
        return true;
    }

}
