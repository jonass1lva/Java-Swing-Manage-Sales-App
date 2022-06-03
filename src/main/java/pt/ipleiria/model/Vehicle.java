package pt.ipleiria.model;

import java.awt.*;
import java.util.Date;
import java.util.HashMap;

public class Vehicle {

    private Boolean inOurProcession;
    private String brand;
    private String model;
    private String licensePlate;
    private int kilometers;
    private int price;
    private String color;
    private int year;
    private int nmrOwners;
    private Date lastInspectionDate;
    private Client lastOwner;


    public Vehicle(String brand, String model, String licensePlate, int kilometers, int price, String color, int year
            , int nmrOwners, Client lastOwner, Date lastInspectionDate) {
        this.brand = brand;
        this.model = model;
        this.licensePlate = licensePlate;
        this.kilometers = kilometers;
        this.price = price;
        this.color = color;
        this.year = year;
        this.nmrOwners = nmrOwners;
        this.lastOwner = lastOwner;
        this.lastInspectionDate = lastInspectionDate;
    }

    //? Getter & Setters
    public Date getLastInspectionDate() {
        return lastInspectionDate;
    }
    public void setLastInspectionDate(Date lastInspectionDate) {
        this.lastInspectionDate = lastInspectionDate;
    }
    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public String getLicensePlate() {
        return licensePlate;
    }
    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }
    public int getKilometers() {
        return kilometers;
    }
    public void setKilometers(int kilometers) {
        this.kilometers = kilometers;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public int getNmrOwners() {
        return nmrOwners;
    }
    public void setNmrOwners(int nmrOwners) {
        this.nmrOwners = nmrOwners;
    }
    public Client getLastOwner() {
        return lastOwner;
    }
    public void setLastOwner(Client lastOwner) {
        this.lastOwner = lastOwner;
    }
}
