package pt.ipleiria.model;

import java.util.Date;

public class Purchase extends Transaction{
    public Purchase(Date date, double value, String vin, Client client) {
        super(date, value, vin, client);
    }
}
