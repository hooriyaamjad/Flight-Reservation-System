package com.example.demo.java_classes.objects;

import java.util.ArrayList;

public class Flight {

    private Aircraft aircraft;
    private ArrayList<Crew> crewMembers;
    private ArrayList<Seat> seats;

    private int id;
    private String origin;
    private String destination;
    private String departure;
    private String arrival;

    public Flight(int id, String origin, String destination, String departure, String arrival, Aircraft aircraft) {
        this.id = id;
        this.origin = origin;
        this.destination = destination;
        this.departure = departure;
        this.arrival = arrival;
        this.aircraft = aircraft;
        this.crewMembers = new ArrayList<Crew>();
        this.seats = new ArrayList<Seat>();
    }

    public Flight(String id) {
        this.id = Integer.parseInt(id);
        this.crewMembers = new ArrayList<Crew>();
        this.seats = new ArrayList<Seat>();
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrigin() {
        return this.origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return this.destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDeparture() {
        return this.departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getArrival() {
        return this.arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    public Aircraft getAircraft() {
        return this.aircraft;
    }

    public void setAircraft(Aircraft aircraft) {
        this.aircraft = aircraft;
    }

    public ArrayList<Crew> getCrewMembers() {
        return this.crewMembers;
    }

    public void setCrewMembers(ArrayList<Crew> crewMembers) {
        this.crewMembers = crewMembers;
    }

    public void addCrewMember(String name, String role) {
        crewMembers.add(new Crew(name, role, this.id));
    }

    public void removeCrewMember(String member_name) {
        for (int i = 0; i < crewMembers.size(); i++) {
            if (crewMembers.get(i).getName() == member_name) {
                crewMembers.remove(crewMembers.get(i));
            }
        }
    }

    public ArrayList<Seat> getSeats() {
        return this.seats;
    }

    public void setSeats(ArrayList<Seat> seats) {
        this.seats = seats;
    }

    public void addSeat(int num, String seat_class, String price, String status) {
        seats.add(new Seat(num, seat_class, price, status));
    }

    public void removeSeat(int seat_num) {
        for (int i = 0; i < seats.size(); i++) {
            if (seats.get(i).getNumber() == seat_num) {
                seats.remove(seats.get(i));
            }
        }
    }
    
}
