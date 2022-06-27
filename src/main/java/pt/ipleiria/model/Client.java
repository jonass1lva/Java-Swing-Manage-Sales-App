package pt.ipleiria.model;

import java.util.Date;
import java.util.LinkedList;

public class Client {
    /*TODO: IMPLENTAR RELAÇÕES DE CLIENTE */
    private String name;
    private int nif;
    private int phoneNumber;
    private LinkedList<Transaction> transactions;

    public Client(String name, int nif, int phoneNumber) {
        this.name = name;
        this.nif = nif;
        this.phoneNumber = phoneNumber;
        this.transactions = new LinkedList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNif() {
        return nif;
    }

    public void setNif(int nif) {
        this.nif = nif;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void registerPurchase(Vehicle vehicle){ //estes três perderiam os atributos por estarem a ser postos na lista da super classe
        transactions.add(new Purchase(new Date(), vehicle.getValue(), vehicle.getVin(), this));
    }

    public void registerSale(Vehicle vehicle){ //estes três perderiam os atributos por estarem a ser postos na lista da super classe
        transactions.add(new Sale(new Date(), vehicle.getValue(), vehicle.getVin(), this));
    }

    public void registerTrade(Vehicle vehicle){ //estes três perderiam os atributos por estarem a ser postos na lista da super classe
        transactions.add(new Trade(new Date(), vehicle.getValue(), vehicle.getVin(), this));
    }

    public LinkedList<Transaction> getTransactions() {
        return transactions;
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", nif=" + nif +
                ", phoneNumber=" + phoneNumber +
                '}';
    }
}
