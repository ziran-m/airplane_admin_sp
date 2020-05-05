package com.airplane.airplane_admin.entity;

public class Flight {
    private String date;
    private String flightNumber;
    private String startTime;
    private String endTime;
    private String cost;
    private String origin;
    private String destination;
    private String moudel;
    private int seat;

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public String getMoudel() {
        return moudel;
    }

    public void setMoudel(String moudel) {
        this.moudel = moudel;
    }

    public String getCost() {
        return cost;
    }

    public String getDate() {
        return date;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getOrigin() {
        return origin;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getEndTime() {
        return endTime;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }
}
