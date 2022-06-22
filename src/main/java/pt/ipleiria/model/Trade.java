package pt.ipleiria.model;

import java.util.Date;

public class Trade extends Transaction{
    public Trade(Date date, double value, String vin, Client client) {
        super(date, value, vin, client);
    }
    //todo adicionar coisas extra da troca
}
