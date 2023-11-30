package com.example.demo.java_classes.roles;

import java.util.ArrayList;

import com.example.demo.java_classes.connections.FlightConnection;
import com.example.demo.java_classes.connections.LoginConnection;
import com.example.demo.java_classes.connections.RegisteredUserConnection;
import com.example.demo.java_classes.objects.Aircraft;
import com.example.demo.java_classes.objects.Crew;
import com.example.demo.java_classes.objects.Flight;
import com.example.demo.java_classes.objects.FlightList;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/admin-role")

public class Admin {

    private String email;
    private FlightList flightList;
    private ArrayList<RegisteredUser> users;
    private ArrayList<Aircraft> aircrafts;
    private String highestFlightID;

    private FlightConnection flightController;
    private LoginConnection adminLoginConnector;
    private RegisteredUserConnection registeredUserController;

    private String adminPassword;

    @Autowired
    public Admin(String email) {
        this.email = email;
        this.flightList = new FlightList();
        this.users = new ArrayList<RegisteredUser>();

        flightController = new FlightConnection();
        adminLoginConnector = new LoginConnection();
        registeredUserController = new RegisteredUserConnection();
    }

    @GetMapping("/get-email")
    public String getEmail() {
        return this.email;
    }

    @PostMapping("/set-email")
    public void setEmail(String email) {
        this.email = email;
    }

    @GetMapping("/use-highest-id")
    public String useHighestFlightID() {
        return this.highestFlightID;
    }

    @PostMapping("/set-highest-id")
    public void setHighestFlightID(String id) {
        this.highestFlightID = id;
    }

    @GetMapping("/use-flight-list")
    public FlightList UseFlightList() {
        return this.flightList;
    }

    @PostMapping("/set-flight-list")
    public void setFlightList(FlightList flights) {
        this.flightList = flights;
    }

    @GetMapping("/use-registered-users")
    public ArrayList<RegisteredUser> useRegisteredUsers() {
        return this.users;
    }

    @PostMapping("/set-registered-users")
    public void setRegisteredUsers(ArrayList<RegisteredUser> users) {
        this.users = users;
    }

    @GetMapping("/use-aircrafts")
    public ArrayList<Aircraft> useAircrafts() {
        return this.aircrafts;
    }

    @PostMapping("/set-aircrafts")
    public void setAircrafts(ArrayList<Aircraft> airplanes) {
        this.aircrafts = airplanes;
    }

    @GetMapping("/use-admin-password")
    public String useAdminPassword() {
        return this.adminPassword;
    }

    @PostMapping("/set-admin-password")
    public void setAdminPassword(String password) {
        this.adminPassword = password;
    }

    @GetMapping("/get-admin-password")
    public String[] getAdminPassword() {
        this.adminPassword = adminLoginConnector.getAdminPassword()[0];
		return adminLoginConnector.getAdminPassword();
	}

    @GetMapping("/get-registered-users")
    public String[] getRegisteredUserList() {
        String[] registeredUsers = registeredUserController.getAllRegisteredUsers();
        for (int i = 0; i < registeredUsers.length; i++) {
            users.add(new RegisteredUser(email));
        }
        return registeredUsers;
    }

    @DeleteMapping("/remove-registered-user")
    public void removeRegisteredUser(String user_email) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).email == user_email) {
                users.remove(i);
            }
        registeredUserController.removeRegisteredUser(email);
        }
    }

    @GetMapping("/get-flights")
    public String[] viewAllFlights() {
        String[] flights = flightController.getAllFlights();
        for (int i = 0; i < flights.length; i++) {
            flightList.addFlight(new Flight(flights[i]));
        }
        return flightController.getAllFlights();
    }

    @GetMapping("/get-specific-flight")
    public String[] viewSpecificFlightInfo(int flight_id) {
        return flightController.getSpecificFlight(String.valueOf(flight_id));
    }

    @GetMapping("/get-flight-passengers")
    public String[] viewFlightPassengers(int flight_id) {
        return flightController.getFlightPassengers(String.valueOf(flight_id));
    }

    @GetMapping("/get-flight-seats")
    public String[] getFlightSeats(int flight_id) {
        return flightController.getFlightSeatList(String.valueOf(flight_id));
    }

    @PutMapping("/update-origin")
    public void updateFlightOrigin(int flight_id, String new_origin) {
        for (int i = 0; i < flightList.getListSize(); i++) {
            if (flightList.getFlightList().get(i).getId() == flight_id) {
                flightList.getFlightList().get(i).setOrigin(new_origin);
            }
        }
        flightController.updateOrigin(flight_id, new_origin);
    }

    @PutMapping("/update-destination")
    public void updateFlightDestination(int flight_id, String new_destination) {
        for (int i = 0; i < flightList.getListSize(); i++) {
            if (flightList.getFlightList().get(i).getId() == flight_id) {
                flightList.getFlightList().get(i).setDestination(new_destination);
            }
        }
        flightController.updateDestination(flight_id, new_destination);
    }

    @PutMapping("/update-takeoff")
    public void updateFlightTakeoff(int flight_id, String new_takeoff) {
        for (int i = 0; i < flightList.getListSize(); i++) {
            if (flightList.getFlightList().get(i).getId() == flight_id) {
                flightList.getFlightList().get(i).setDeparture(new_takeoff);
            }
        }
        flightController.updateTakeoff(flight_id, new_takeoff);
    }

    @PutMapping("/update-arrival")
    public void updateFlightArrival(int flight_id, String new_arrival) {
        for (int i = 0; i < flightList.getListSize(); i++) {
            if (flightList.getFlightList().get(i).getId() == flight_id) {
                flightList.getFlightList().get(i).setArrival(new_arrival);
            }
        }
        flightController.updateArrival(flight_id, new_arrival);
    }

    @PutMapping("/update-aircraft")
    public void updateFlightAircraft(int flight_id, String new_aircraft) {
        for (int i = 0; i < flightList.getListSize(); i++) {
            if (flightList.getFlightList().get(i).getId() == flight_id) {
                flightList.getFlightList().get(i).setAircraft(new Aircraft(new_aircraft));
            }
        }
        flightController.updateAircraft(flight_id, new_aircraft);
    }

    @DeleteMapping("/delete-flight")
    public void deleteFlight(int flight_id) {
        flightController.deleteFlight(String.valueOf(flight_id));
        for (int i = 0; i < flightList.getListSize(); i++) {
            if (flightList.getFlightList().get(i).getId() == flight_id) {
                flightList.getFlightList().remove(i);
            }
        }
    }

    @PostMapping("/add-flight")
    public void addFlight(int id, String aircraft, String origin, String destination, String start_date, String end_date) {
        flightController.addFlight(id, aircraft, origin, destination, start_date, end_date);
        Flight new_flight = new Flight(String.valueOf(id));
        flightList.getFlightList().add(new_flight);
        flightController.addFlightSeats(String.valueOf(id));
    }

    @GetMapping("/get-flight-crew")
    public String[] getFlightCrew(String id) {
        return flightController.viewFlightCrew(id);
    }

    @PostMapping("/add-crew-member")
    public void addCrewMember(String name, String role, int flight_id) {
        flightController.addCrewMember(name, role, flight_id);
        for (int i = 0; i < flightList.getListSize(); i++) {
            if (flightList.getFlightList().get(i).getId() == flight_id) {
                flightList.getFlightList().get(i).getCrewMembers().add(new Crew(name, role, flight_id));
            }
        }
    }

    @DeleteMapping("/delete-crew-member")
    public void removeCrewMember(String name, int flight_id) {
        flightController.removeCrewMember(name, flight_id);
        for (int i = 0; i < flightList.getListSize(); i++) {
            if (flightList.getFlightList().get(i).getId() == flight_id) {
                ArrayList<Crew> crew = flightList.getFlightList().get(i).getCrewMembers();
                for (int j = 0; j < crew.size(); j++) {
                    if (crew.get(j).getName() == name) {
                        crew.remove(j);
                    }
                }
            }
        }
    }

    @GetMapping("/get-aircrafts")
    public String[] getAircrafts() {
        String[] airplanes = flightController.getAircrafts();
        for (int i = 0; i < airplanes.length; i++) {
            aircrafts.add(new Aircraft(airplanes[i]));
        }
        return airplanes;
    }

    @PostMapping("/add-aircraft")
    public void addAircraft(String name) {
        flightController.addAircraft(name);
        aircrafts.add(new Aircraft(name));
    }

    @DeleteMapping("/remove-aircraft")
    public void removeAircraft(String name) {
        flightController.removeAircraft(name);
        for (int i = 0; i < aircrafts.size(); i++) {
            if (aircrafts.get(i).getName() == name) {
                aircrafts.remove(i);
            }
        }
    }

    @GetMapping("/get-highest-flight-id")
    public String[] getMaxFlightID() {
        this.highestFlightID = flightController.getMaxFlightID()[0];
        return flightController.getMaxFlightID();
    }
    
}