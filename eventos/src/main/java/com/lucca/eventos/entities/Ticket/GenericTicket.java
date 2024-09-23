package com.lucca.eventos.entities.Ticket;

import com.lucca.eventos.service.GenerateIds;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GenericTicket implements Ticket {

    private String description;
    private String type;
    private String name;
    private double price;
    private int id;

    public GenericTicket() {
        this.type = "Generic";
        this.id = GenerateIds.generateGenericTicketId();
    }

    public boolean validateTicket() {
        return true;
    }
}
