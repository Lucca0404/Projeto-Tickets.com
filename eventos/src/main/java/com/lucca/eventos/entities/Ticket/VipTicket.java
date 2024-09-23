package com.lucca.eventos.entities.Ticket;

import com.lucca.eventos.service.GenerateIds;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class VipTicket implements Ticket{

    private String description;
    private String type;
    private String name;
    private double price;
    private int id;

    public VipTicket() {
        this.type = "VIP";
        this.id = GenerateIds.generateVIPTicketId();
    }

    public boolean validateTicket() {
        return true;
    }
}
