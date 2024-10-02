package com.example.finalyearproject.java;

public class UserMapTicketModel {
    private String ticketTo;
    private String ticketFrom;
    private String ticketClass;
    private String ticketType;
    private String ticketPrice;
    private String timestamp;
    private int ticketAdultCount;

    public UserMapTicketModel(String ticketTo, String ticketFrom, String ticketClass, String ticketType,
                         String ticketPrice, String timestamp, int ticketAdultCount) {
        this.ticketTo = ticketTo;
        this.ticketFrom = ticketFrom;
        this.ticketClass = ticketClass;
        this.ticketType = ticketType;
        this.ticketPrice = ticketPrice;
        this.timestamp = timestamp;
        this.ticketAdultCount = ticketAdultCount;
    }

    // Getter methods for accessing the ticket properties

    public String getTicketTo() {
        return ticketTo;
    }

    public String getTicketFrom() {
        return ticketFrom;
    }

    public String getTicketClass() {
        return ticketClass;
    }

    public String getTicketType() {
        return ticketType;
    }

    public String getTicketPrice() {
        return ticketPrice;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public int getTicketAdultCount() {
        return ticketAdultCount;
    }
}

