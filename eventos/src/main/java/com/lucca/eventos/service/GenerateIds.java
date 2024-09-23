package com.lucca.eventos.service;

public class GenerateIds {

    public static int generatePersonId() {
        return (int) (Math.random() * 31 * 579) % 100000;
    }

    public static int generateGenericTicketId() {
        return (int) (Math.random() * 31 * 579) % 10000;
    }

    public static int generateVIPTicketId() {
        return (int) (Math.random() * 31 * 579) % 100;
    }

    public static int generateEventId() {
        return (int) (Math.random() * 31 * 579) % 1000;
    }

    public static int generateEventTicketId() {
        return (int) (Math.random() * 31 * 579) % 1000;
    }
}