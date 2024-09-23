package com.lucca.eventos.entities;

import java.util.HashMap;
import java.util.Date;

import com.lucca.eventos.entities.Person.Client;
import com.lucca.eventos.entities.Ticket.EventTicket;
import com.lucca.eventos.entities.Ticket.GenericTicket;
import com.lucca.eventos.entities.Ticket.VipTicket;
import com.lucca.eventos.service.GenerateIds;
import lombok.Getter;
import lombok.Setter;

@Getter
public class Event {

    @Setter
    private String name;
    @Setter
    private String description;
    @Setter
    private String Local;
    private double eventBalance;
    private final int id;
    @Setter
    private Date data;
    private int MAX_CAPACITY;
    private HashMap<String, EventTicket> tickets;
    private int totalNumberOfTickets;
    private int numberOfVipTickets;
    private int numberOfGenericTickets;

    public Event() {
        this.id = GenerateIds.generateEventId();
    }
    public Event(String name, Date data, int MAX_CAPACITY) {
        this.name = name;
        this.data = data;
        this.MAX_CAPACITY = MAX_CAPACITY;
        this.id = GenerateIds.generateEventId();
        this.tickets = new HashMap<>(MAX_CAPACITY);
    }

    public void createTicket(String ticketName, int quantity, String type) {
        EventTicket ticket = new EventTicket();
        ticket.setName(ticketName);
        ticket.setQuantity(quantity);
        ticket.setType(type);
        tickets.put(ticketName, ticket);
        if(ticket.getType().compareTo("Vip") == 0) {
            numberOfVipTickets+=quantity;
        }
        else{
            if(ticket.getType().compareTo("Generic") == 0) {
                numberOfGenericTickets+=quantity;
            }
        }
        totalNumberOfTickets+=quantity;
    }

    public void editNameOfTicket(String ticketName,String newName) {
        if(this.tickets.containsKey(ticketName)) {
            EventTicket ticket = this.tickets.get(ticketName);
            ticket.setName(newName);
            this.tickets.remove(ticketName);
            this.tickets.put(newName, ticket);
        }
    }

    public void editQuantityOfTickets(String ticketName, int newQuantity) {
        if(this.tickets.containsKey(ticketName)) {
            EventTicket ticket = this.tickets.get(name);
            this.totalNumberOfTickets-=ticket.getQuantity();
            this.totalNumberOfTickets+=newQuantity;
            if(ticket.getType().compareTo("Vip") == 0) {
                numberOfVipTickets-=ticket.getQuantity();
                numberOfVipTickets+=newQuantity;
            }
            else{
                if(ticket.getType().compareTo("Generic") == 0) {
                    numberOfGenericTickets-=ticket.getQuantity();
                    numberOfGenericTickets+=newQuantity;
                }
            }
            ticket.setQuantity(newQuantity);
        }
    }

    public void editTicket(String ticketName, String description, String type, double price) {
        this.tickets.get(ticketName).setDescription(description);
        this.tickets.get(ticketName).setType(type);
        this.tickets.get(ticketName).setPrice(price);
    }

    public void deleteTicket(String ticketName) {
        if(this.tickets.containsKey(ticketName)) {
            EventTicket ticket = this.tickets.get(ticketName);
            if(ticket.getType().compareTo("Vip") == 0) {
                numberOfVipTickets-=ticket.getQuantity();
            }
            else{
                if(ticket.getType().compareTo("Generic") == 0) {
                    numberOfGenericTickets-=ticket.getQuantity();
                }
            }
            this.totalNumberOfTickets-=ticket.getQuantity();
            this.tickets.remove(ticketName);

        }
    }

    public double sellTicket(Client buyer, String ticketName, int quantity) {
        if(this.tickets.containsKey(ticketName)) {
            if(this.tickets.get(ticketName).getQuantity() >= quantity) {
                EventTicket ticket = this.tickets.get(ticketName);
                int newQuantity = this.tickets.get(ticketName).getQuantity() - quantity;
                this.tickets.get(ticketName).setQuantity(newQuantity);
                this.eventBalance += this.tickets.get(ticketName).getPrice() * quantity;
                if(ticket.getType().compareTo("VIP") == 0) {
                    for(int i = 0; i < quantity; i++) {
                        VipTicket vipTicket = new VipTicket();
                        vipTicket.setPrice(ticket.getPrice());
                        vipTicket.setDescription(ticket.getDescription());
                        vipTicket.setName(ticketName);
                        buyer.getTickets().put(ticketName, vipTicket);
                    }
                    numberOfVipTickets+=quantity;
                }
                else{
                    if(ticket.getType().compareTo("Generic") == 0) {
                        for(int i = 0; i < quantity; i++) {
                            GenericTicket genericTicket = new GenericTicket();
                            genericTicket.setPrice(ticket.getPrice());
                            genericTicket.setDescription(ticket.getDescription());
                            genericTicket.setName(ticketName);
                            buyer.getTickets().put(ticketName, genericTicket);
                        }
                        numberOfGenericTickets+=quantity;
                    }
                }
                this.totalNumberOfTickets-=quantity;
                return ticket.getPrice();
            }
        }
        return 0.0;
    }
}