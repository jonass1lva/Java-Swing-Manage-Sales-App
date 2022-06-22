package pt.ipleiria.model;

import java.util.Date;

public class Sale extends Transaction{
    public Sale(Date date, double value, String vin, Client client) {
        super(date, value, vin, client);
    }
}
