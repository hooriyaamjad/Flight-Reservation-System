package com.example.demo.java_classes.objects;

public class Seat {

    private int number;
    private String seat_class;
    private String price;
    private String status;
    

    public Seat(int num, String seat_class, String price, String status) {
        this.number = num;
        this.seat_class = seat_class;
        this.price = price;
        this.status = status;
    }

    public Seat(int number) {
        this.number = number;
    }

    public int getNumber() {
        return this.number;
    }

    public void setNumber(int num) {
        this.number = num;
    }

    public String getSeatClass() {
        return this.seat_class;
    }

    public void setSeatClass(String seat_class) {
        this.seat_class = seat_class;
    }

    public String getPrice() {
        return this.price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


}
