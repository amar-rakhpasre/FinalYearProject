package com.example.finalyearproject.PaymentGateway;


public class UserTicket {
    private String ticketTo;
    private String ticketRoute;
    private String ticketClass;

    public UserTicket(String ticketTo, String ticketRoute, String ticketClass, String ticketType, int ticketPrice, String ticketDate, int ticketNumber, int ticketAdultCount, int ticketChildCount, String ticketValidity, String ticketFrom) {
        this.ticketTo = ticketTo;
        this.ticketRoute = ticketRoute;
        this.ticketClass = ticketClass;
        this.ticketType = ticketType;
        this.ticketPrice = ticketPrice;
        this.ticketDate = ticketDate;
        this.ticketNumber = ticketNumber;
        this.ticketAdultCount = ticketAdultCount;
        this.ticketChildCount = ticketChildCount;
        this.ticketValidity = ticketValidity;
        this.ticketFrom = ticketFrom;
    }

    public UserTicket(String ticketId, String ticketTo, String ticketRoute, String ticketClass, String ticketType, int ticketPrice, String ticketDate, int ticketNumber, int ticketAdultCount, int ticketChildCount, String ticketValidity, String ticketFrom ) {

    }

    public String getTicketTo() {
        return ticketTo;
    }

    public void setTicketTo(String ticketTo) {
        this.ticketTo = ticketTo;
    }

    public String getTicketRoute() {
        return ticketRoute;
    }

    public void setTicketRoute(String ticketRoute) {
        this.ticketRoute = ticketRoute;
    }

    public String getTicketClass() {
        return ticketClass;
    }

    public void setTicketClass(String ticketClass) {
        this.ticketClass = ticketClass;
    }

    public String getTicketType() {
        return ticketType;
    }

    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }

    public int getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(int ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public String getTicketDate() {
        return ticketDate;
    }

    public void setTicketDate(String ticketDate) {
        this.ticketDate = ticketDate;
    }

    public int getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(int ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public int getTicketAdultCount() {
        return ticketAdultCount;
    }

    public void setTicketAdultCount(int ticketAdultCount) {
        this.ticketAdultCount = ticketAdultCount;
    }

    public int getTicketChildCount() {
        return ticketChildCount;
    }

    public void setTicketChildCount(int ticketChildCount) {
        this.ticketChildCount = ticketChildCount;
    }

    public String getTicketValidity() {
        return ticketValidity;
    }

    public void setTicketValidity(String ticketValidity) {
        this.ticketValidity = ticketValidity;
    }

    public String getTicketFrom() {
        return ticketFrom;
    }

    public void setTicketFrom(String ticketFrom) {
        this.ticketFrom = ticketFrom;
    }

    private String ticketType;
    private int ticketPrice;
    private String ticketDate;
    private int ticketNumber;
    private int ticketAdultCount;
    private int ticketChildCount;
    private String ticketValidity;
    private String ticketFrom;

    // Create getters and setters
    // Constructor and other methods as needed
}

