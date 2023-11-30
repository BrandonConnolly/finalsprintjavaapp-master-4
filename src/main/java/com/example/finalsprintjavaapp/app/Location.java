package com.example.finalsprintjavaapp.app;

public class Location {
    private String airport;
    private String city;
    private String aircraft;

    public Location(String airport, String city, String aircraft) {
        this.airport = airport;
        this.city = city;
        this.aircraft = aircraft;
    }

    public String getAirport() {
        return airport;
    }

    public String getCity() {
        return city;
    }

    public String getAircraft(){
        return aircraft;
    }
}