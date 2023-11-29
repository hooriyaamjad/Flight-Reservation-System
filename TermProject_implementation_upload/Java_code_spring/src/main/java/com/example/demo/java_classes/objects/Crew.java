package com.example.demo.java_classes.objects;

import java.util.ArrayList;

public class Crew {

    private String name;
    private String role;
    private ArrayList<Integer> flights;

    public Crew(String name, String role, int flight_id) {
        this.name = name;
        this.role = role;
        flights = new ArrayList<Integer>();
        flights.add(flight_id);
    }

    public Crew(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String new_name) {
        this.name = new_name;
    }

    public String getRole() {
        return this.role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public ArrayList<Integer> getFlights() {
        return this.flights;
    }

    public void setFlights(ArrayList<Integer> new_flights) {
        this.flights = new_flights;
    }

    public void addFlight(int flight_id) {
        flights.add(flight_id);
    }

    public void removeFlight(int flight_id) {
        flights.remove(flight_id);
    }
    
    
}
