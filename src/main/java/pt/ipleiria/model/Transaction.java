package pt.ipleiria.model;

import java.util.Date;

public abstract class Transaction {
    //private final int transactionID;
    private final Date date;
    private final double value;
    private final String vin;
    private final Client client; //Possívelmente inútil uma vez que está a ser guardado no cliente de qualquer maneira


    protected Transaction(Date date, double value, String vin, Client client) {
        this.date = date;
        this.value = value;
        this.vin = vin;
        this.client = client;
    }
    public Date getDate() {
        return date;
    }

    public double getValue() {
        return value;
    }

    public String getVin() {
        return vin;
    }

    public Client getClient() {
        return client;
    }
}
