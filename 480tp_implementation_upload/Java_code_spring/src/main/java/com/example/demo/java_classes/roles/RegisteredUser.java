package com.example.demo.java_classes.roles;

import com.example.demo.java_classes.connections.RegisteredUserConnection;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/registered-user-role")

public class RegisteredUser extends User {

    private String name;
    private String address;
    private String membership;
    private String companyCard;
    private String benefits;

    private RegisteredUserConnection registeredUserController;

    @Autowired
    public RegisteredUser(String email) {
        super(email);
        registeredUserController = new RegisteredUserConnection();
    }

    @Autowired
    public RegisteredUser(String email, String name, String address, String membership, String companyCard, String benefits) {
        super(email);
        this.name = name;
        this.address = address;
        this.membership = membership;
        this.companyCard = companyCard;
        this.benefits = benefits;
        registeredUserController = new RegisteredUserConnection();
    }

    @GetMapping("/get-name")
    public String getName() {
        return name;
    }

    @PostMapping("/set-name")
    public void setName(String name) {
        this.name = name;
    }

    @GetMapping("/get-address")
    public String getAddress() {
        return address;
    }

    @PostMapping("/set-address")
    public void setAddress(String address) {
        this.address = address;
    }

    @GetMapping("/get-memebership")
    public String getMembership() {
        return membership;
    }

    @PostMapping("/set-memebership")
    public void setMembership(String membership) {
        this.membership = membership;
    }

    @GetMapping("/get-card")
    public String getCompanyCard() {
        return companyCard;
    }

    @PostMapping("/set-card")
    public void setCompanyCard(String companyCard) {
        this.companyCard = companyCard;
    }

    @GetMapping("/get-benefits")
    public String getBenefits() {
        return benefits;
    }

    @PostMapping("/set-benefits")
    public void setBenefits(String benefits) {
        this.benefits = benefits;
    }

    @GetMapping("/get-registration-info")
    public String[] getRegistrationInfo() {
        return registeredUserController.getRegisteredUserInfo(super.email);
    }

    @DeleteMapping("/remove-membership")
    public void removeMembership() {
        registeredUserController.deleteMembership(super.email);
        setName(null);
        setAddress(null);
        setMembership(null);
        setCompanyCard(null);
        setBenefits(null);
    }
    
}
