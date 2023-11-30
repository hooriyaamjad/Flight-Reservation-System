package com.example.demo.java_classes.objects;

import java.util.ArrayList;

public class FlightList {

    private ArrayList<Flight> flights;

    public FlightList(Flight flight) {
        this.flights = new ArrayList<Flight>();
        flights.add(flight);
    }

    public FlightList() {
        this.flights = new ArrayList<Flight>();
    }

    public ArrayList<Flight> getFlightList() {
        return this.flights;
    }

    public void setFlightList(ArrayList<Flight> flights) {
        this.flights = flights;
    }

    public void addFlight(Flight flight) {
        flights.add(flight);
    }

    public void removeFlight(int flight_id) {
        for (int i = 0; i < flights.size(); i++) {
            if (flights.get(i).getId() == flight_id) {
                flights.remove(flights.get(i));
            }
        }
    }

    public int getListSize() {
        return this.flights.size();
    }
    
}
