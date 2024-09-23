package com.lucca.eventos.entities.Ticket;

import com.lucca.eventos.service.GenerateIds;
import lombok.Getter;
import lombok.Setter;

public interface Ticket {

    public boolean validateTicket();
    public double getPrice();
    public void setPrice(double price);
    public String getDescription();
    public void setDescription(String description);
    public String getName();
    public void setName(String name);
    public int getId();
    public void setId(int id);
    public String getType();
    public void setType(String type);
}