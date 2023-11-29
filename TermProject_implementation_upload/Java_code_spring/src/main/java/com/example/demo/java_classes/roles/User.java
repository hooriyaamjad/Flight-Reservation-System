package com.example.demo.java_classes.roles;
import java.util.ArrayList;

import com.example.demo.java_classes.connections.FlightBookingConnection;
import com.example.demo.java_classes.connections.FlightConnection;
import com.example.demo.java_classes.connections.RegisteredUserConnection;
import com.example.demo.java_classes.objects.FlightBooking;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/user-role")

public class User {

    protected String email;
    protected ArrayList<FlightBooking> userFlights;
    protected FlightConnection flightController;
    protected FlightBookingConnection bookingController;
    protected RegisteredUserConnection registratonController;

    @Autowired
    public User(String email) {
        this.email = email;
        flightController = new FlightConnection();
        bookingController = new FlightBookingConnection();
        registratonController = new RegisteredUserConnection();
    }

    @GetMapping("/get-email")
    public String getEmail() {
        return this.email;
    }

    @PostMapping("/set-email")
    public void setEmail(String email) {
        this.email = email;
    }

    @GetMapping("/get-user-flights")
    public String[] getUserFlights() {
        String[] flights = bookingController.getUserFlights(email);
        for (int i = 0; i < flights.length; i++) {
            userFlights.add(new FlightBooking(email));
        }
        return flights;
    }

    @GetMapping("/get-flight-list")
    public String[] getFlightList() {
        return flightController.getAllFlights();
    }

    @GetMapping("/get-flight-seats")
    public String[] getFlightSeatList(int flight_id) {
        return flightController.getFlightSeatList(String.valueOf(flight_id));
    }

    @PostMapping("/add-flight-booking")
    public void addFlightBooking(FlightBooking booking) {
        bookingController.newBooking(email, booking.getFlight().getId(), booking.getSeat().getNumber(), booking.getInsurance());
        bookingController.fillUserSeat(booking.getFlight().getId(), booking.getSeat().getNumber());
        userFlights.add(booking);
    }

    @DeleteMapping("/remove-flight-booking")
    public void removeFlightBooking(int flight_id, int seat_num) {
        for (int i = 0; i < userFlights.size(); i++) {
            if ((userFlights.get(i).getFlight().getId() == flight_id) && (userFlights.get(i).getSeat().getNumber() == seat_num)) {
                userFlights.remove(i);
            }
        }
        bookingController.deleteUserFlight(email, flight_id, String.valueOf(seat_num));
        bookingController.emptyUserSeat(flight_id,  String.valueOf(seat_num));
    }

    @PostMapping("/register-user")
    public void Register(String name, String address, String membership, String card, String benefits) {
        registratonController.createMembership(email, name, address, membership, card, benefits);
    }

    
}