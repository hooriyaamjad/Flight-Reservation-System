package com.example.demo.java_classes.objects;

import com.example.demo.java_classes.roles.User;

public class FlightBooking {

    private Flight flight;
    private User passenger;
    private Seat selected_seat;
    private String insurance;

    public FlightBooking(Flight flight, User passenger, Seat selected_seat, String insurance) {
        this.flight = flight;
        this.passenger = passenger;
        this.selected_seat = selected_seat;
        this.insurance = insurance;
    }

    public FlightBooking(Flight flight, User passenger, Seat selected_seat) {
        this.flight = flight;
        this.passenger = passenger;
        this.selected_seat = selected_seat;
    }

    public FlightBooking(String booking) {
        this.flight = new Flight(booking);
    }

    public Flight getFlight() {
        return this.flight;
    }

    public void setFlight(Flight new_flight) {
        this.flight = new_flight;
    }

    public User getPassenger() {
        return this.passenger;
    }

    public void setPassenger(User passenger) {
        this.passenger = passenger;
    }

    public Seat getSeat() {
        return this.selected_seat;
    }

    public void setSeat(Seat seat) {
        this.selected_seat = seat;
    }

    public String getInsurance() {
        return this.insurance;
    }

    public void setInsurance(String insurance) {
        this.insurance = insurance;
    }


}
