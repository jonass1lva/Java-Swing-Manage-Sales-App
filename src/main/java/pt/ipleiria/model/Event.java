package pt.ipleiria.model;

import java.util.Date;
import java.util.LinkedList;

public class Event {

    private String name;
    private String local;
    private Date initialDate;
    private Date finaldate;
    private LinkedList<Vehicle> vehicleList;

    public Event(String name, String local, Date initialDate, Date finaldate) {
        this.name = name;
        this.local = local;
        this.initialDate = initialDate;
        this.finaldate = finaldate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public Date getInitialDate() {
        return initialDate;
    }


    public void setInitialDate(Date initialDate) {
        this.initialDate = initialDate;
    }

    public Date getFinaldate() {
        return finaldate;
    }

    public void setFinaldate(Date finaldate) {
        this.finaldate = finaldate;
    }

    public LinkedList<Vehicle> getVehicleList() {
        return vehicleList;
    }
}