package pt.ipleiria.model;

import java.awt.*;
import java.util.Date;
import java.util.HashMap;

public class Vehicle {

    private Boolean inOurPosession;
    private String brand;
    private String model;
    private String licensePlate;
    private int kilometers;
    private String vin;
    private float siteValue;
    private CarCondition condition;
    private double value;
    private String color;
    private int year;
    private int nmrOwners;
    private Date lastInspectionDate;
    private Client lastOwner;


    public Vehicle(Boolean inOurPosession, String brand, String model, String licensePlate, int kilometers, float siteValue, String vin, String color, int year
            , int nmrOwners, Client lastOwner, Date lastInspectionDate, CarCondition condition) {
        this.inOurPosession = inOurPosession;
        this.brand = brand;
        this.model = model;
        this.licensePlate = licensePlate;
        this.kilometers = kilometers;
        this.siteValue = siteValue;
        this.condition = condition;
        this.vin = vin;
        this.color = color;
        this.year = year;
        this.nmrOwners = nmrOwners;
        this.lastOwner = lastOwner;
        this.lastInspectionDate = lastInspectionDate;
        this.value = siteValue * condition.getValueMultiplier();
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
    public float getSiteValue() {
        return siteValue;
    }
    public void setSiteValue(int siteValue) {
        this.siteValue = siteValue;
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

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public CarCondition getCondition() {
        return condition;
    }

    public double getValue() {
        return value;
    }

    public void setSiteValue(float siteValue) {
        this.siteValue = siteValue;
        this.value = siteValue * condition.getValueMultiplier();
    }

    public void setCondition(CarCondition condition) {
        this.condition = condition;
        this.value = siteValue * condition.getValueMultiplier();
    }


    public void printVehicle() {
        System.out.printf("\nVehicle{" +
                "inOurPosession=" + inOurPosession +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", licensePlate='" + licensePlate + '\'' +
                ", kilometers=" + kilometers +
                ", vin='" + vin + '\'' +
                ", siteValue=" + siteValue +
                ", Condition=" + condition +
                ", value=" + value +
                ", color='" + color + '\'' +
                ", year=" + year +
                ", nmrOwners=" + nmrOwners +
                ", lastInspectionDate=" + lastInspectionDate +
                ", lastOwner=" + lastOwner.toString() +
                "}\n");
    }
}
