// ReturnTicketModel.java
package com.example.finalyearproject.java;

import java.util.ArrayList;
import java.util.List;

public class ReturnTicketModel {

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

    public String getTicketClass() {
        return TicketClass;
    }

    public String getTicketType() {
        return TicketType;
    }

    public int getTicketAdultCount() {
        return TicketAdultCount;
    }

    public int getTicketChildCount() {
        return TicketChildCount;
    }

    public String getTicketDate() {
        return TicketDate;
    }

    public int getTicketNumber() {
        return TicketNumber;
    }

    public String getTicket_From() {
        return Ticket_From;
    }

    public String getTicketValidity() {
        return TicketValidity;
    }

    public int getTicketPrice() {
        return TicketPrice;
    }

    public String getTicket_To() {
        return Ticket_To;
    }

    public String getTicket_Route() {
        return Ticket_Route;
    }

    public ReturnTicketModel(String ticketClass, String ticketType, int ticketAdultCount, int ticketChildCount, String ticketDate, int ticketNumber, String ticket_From, String ticketValidity, int ticketPrice, String ticket_To, String ticket_Route) {
        TicketClass = ticketClass;
        TicketType = ticketType;
        TicketAdultCount = ticketAdultCount;
        TicketChildCount = ticketChildCount;
        TicketDate = ticketDate;
        TicketNumber = ticketNumber;
        Ticket_From = ticket_From;
        TicketValidity = ticketValidity;
        TicketPrice = ticketPrice;
        Ticket_To = ticket_To;
        Ticket_Route = ticket_Route;
    }

    // Add data for multiple stations here
    public static List<ReturnTicketModel> getSampleStationData() {
        List<ReturnTicketModel> stationList = new ArrayList<>();

        // Add data for each station
        stationList.add(new ReturnTicketModel("Second", "ORDINARY", 1, 0, "2024-02-17", 123456, "Mumbai", "3 HOUR", 10, "Churchgate Station", "Western Line"));
        stationList.add(new ReturnTicketModel("Second", "ORDINARY", 1, 0, "2024-02-17", 123457, "Mumbai", "3 HOUR", 10, "Marine Lines Station", "Western Line"));
        stationList.add(new ReturnTicketModel("Second", "ORDINARY", 1, 0, "2024-02-17", 123458, "Mumbai", "3 HOUR", 10, "Charni Road Station", "Western Line"));
        stationList.add(new ReturnTicketModel("Second", "ORDINARY", 1, 0, "2024-02-17", 123459, "Mumbai", "3 HOUR", 10, "Grant Road Station", "Western Line"));
        stationList.add(new ReturnTicketModel("Second", "ORDINARY", 2, 1, "2024-02-17", 123528, "Mumbai", "3 HOUR", 10, "Mumbai Central", "Western Line"));
        stationList.add(new ReturnTicketModel("Second", "ORDINARY", 1, 0, "2024-02-18", 124512, "Mumbai", "3 HOUR", 10, "Mahalaxmi", "Western Line"));
        // Add more stations as needed

        return stationList;
    }
}
