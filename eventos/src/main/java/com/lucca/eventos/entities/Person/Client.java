package com.lucca.eventos.entities.Person;

import com.lucca.eventos.entities.Event;
import com.lucca.eventos.entities.Ticket.Ticket;
import lombok.Getter;

import java.util.LinkedHashMap;

@Getter
public class Client extends Person {

    private LinkedHashMap<String, Ticket> tickets = new LinkedHashMap<>();
    private double balance;

    public void addMoney(double money) {
        if(money >= 0) {
            this.balance += money;
        }
    }

    public void removeMoney(double money) {
        if(money >= 0 && this.balance >= money) {
            this.balance -= money;
        }
    }

    public void buyEventTicket(Event event, String nameOfTicket, int quantity) {
        if(event.getTickets().containsKey(nameOfTicket)) {
            if(event.getTickets().get(nameOfTicket).getPrice() * quantity <= this.balance) {
                this.balance -= event.sellTicket(this,nameOfTicket,quantity);
            }
        }
    }

    public void buyClientTicket(Client seller, String nameOfTicket) {
        if(seller.getTickets().containsKey(nameOfTicket)) {
            if(seller.getTickets().get(nameOfTicket).getPrice() <= this.balance) {
                this.balance -= sellTicket(this, nameOfTicket);
            }
        }
    }

    private double sellTicket(Client buyer, String nameOfTicket) {
        if(tickets.containsKey(nameOfTicket)) {
            Ticket ticket = tickets.get(nameOfTicket);
            buyer.tickets.put(nameOfTicket, ticket);
            this.balance += ticket.getPrice();
            this.tickets.remove(nameOfTicket);
            return ticket.getPrice();
        }
        return 0.0;
    }
}
