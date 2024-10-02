package com.example.finalyearproject.java;

import java.io.Serializable;

public class StationMapModel implements Serializable {
    private String textStationName;
    private String TicketClass;
    private String TicketType;
    private int TicketAdultCount;
    private int TicketChildCount;
    private String TicketDate;
    private int TicketNumber;
    private String Ticket_From;
    private String TicketValidity;
    private int TicketPrice;
    private String Ticket_To;
    private String Ticket_Route;

    public StationMapModel() {
        // Default constructor required for Firebase
    }

    public StationMapModel(String stationName) {
        this.textStationName = stationName;
    }

    public String getStationName() {
        return textStationName;
    }

    public void setStationName(String stationName) {
        this.textStationName = stationName;
    }

    // Add getters and setters for other fields
}
