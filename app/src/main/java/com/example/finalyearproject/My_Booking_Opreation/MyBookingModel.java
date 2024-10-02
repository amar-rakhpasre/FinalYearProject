package com.example.finalyearproject.My_Booking_Opreation;

public class MyBookingModel {
    private int ticketChildCount;
    private int ticketAdultCount;
    private String ticketClass;
    private String ticketDate;
    private String ticketFrom;
    private int ticketNumber;
    private int ticketPrice;
    private String ticketRoute;
    private String ticketTo;
    private String ticketType;
    private String ticketValidity;

    // Default constructor required for Firebase deserialization
    public MyBookingModel() {
    }

    public int getTicketChildCount() {
        return ticketChildCount;
    }

    public void setTicketChildCount(int ticketChildCount) {
        this.ticketChildCount = ticketChildCount;
    }

    public int getTicketAdultCount() {
        return ticketAdultCount;
    }

    public void setTicketAdultCount(int ticketAdultCount) {
        this.ticketAdultCount = ticketAdultCount;
    }

    public String getTicketClass() {
        return ticketClass;
    }

    public void setTicketClass(String ticketClass) {
        this.ticketClass = ticketClass;
    }

    public String getTicketDate() {
        return ticketDate;
    }

    public void setTicketDate(String ticketDate) {
        this.ticketDate = ticketDate;
    }

    public String getTicketFrom() {
        return ticketFrom;
    }

    public void setTicketFrom(String ticketFrom) {
        this.ticketFrom = ticketFrom;
    }

    public int getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(int ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public int getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(int ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public String getTicketRoute() {
        return ticketRoute;
    }

    public void setTicketRoute(String ticketRoute) {
        this.ticketRoute = ticketRoute;
    }

    public String getTicketTo() {
        return ticketTo;
    }

    public void setTicketTo(String ticketTo) {
        this.ticketTo = ticketTo;
    }

    public String getTicketType() {
        return ticketType;
    }

    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }

    public String getTicketValidity() {
        return ticketValidity;
    }

    public void setTicketValidity(String ticketValidity) {
        this.ticketValidity = ticketValidity;
    }
}
