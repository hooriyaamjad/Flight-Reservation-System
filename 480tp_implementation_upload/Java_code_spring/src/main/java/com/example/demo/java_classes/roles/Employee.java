package com.example.demo.java_classes.roles;

import com.example.demo.java_classes.connections.FlightConnection;
import com.example.demo.java_classes.connections.LoginConnection;
import com.example.demo.java_classes.objects.Flight;
import com.example.demo.java_classes.objects.FlightList;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/employee-role")

public class Employee {
    
    private String email;
    private FlightList flightInfo;

    private FlightConnection emloyeeController;
    private LoginConnection emplyeeLoginConnector;

    private String employeePassword;
    
    @Autowired
    public Employee(String email) {
        this.email = email;
        this.flightInfo = new FlightList();
        emloyeeController = new FlightConnection();
        emplyeeLoginConnector = new LoginConnection();
    }

    @GetMapping("/get-email")
    public String getEmail() {
        return this.email;
    }

    @PostMapping("/set-email")
    public void setEmail(String email) {
        this.email = email;
    }

    @GetMapping("/get-flight-list")
    public FlightList getFlightList() {
        return this.flightInfo;
    }

    @GetMapping("/use-employee-password")
    public String useEmployeePassword() {
        return this.employeePassword;
    }

    @GetMapping("/get-employee-password")
    public String[] getEmployeePassword() {
        this.employeePassword = emplyeeLoginConnector.getEmployeePassword()[0];
		return emplyeeLoginConnector.getEmployeePassword();
	}

    @GetMapping("/view-flights")
    public String[] viewAllFlights() {
        String[] flights = emloyeeController.getAllFlights();
        for (int i = 0; i < flights.length; i++) {
            flightInfo.addFlight(new Flight(flights[i]));
        }
        return emloyeeController.getAllFlights();
    }

    @GetMapping("/view-specific-flight")
    public String[] viewSpecificFlightInfo(int flight_id) {
        return emloyeeController.getSpecificFlight(String.valueOf(flight_id));
    }

    @GetMapping("/view-passengers")
    public String[] viewFlightPassengers(int flight_id) {
        return emloyeeController.getFlightPassengers(String.valueOf(flight_id));
    }

}
