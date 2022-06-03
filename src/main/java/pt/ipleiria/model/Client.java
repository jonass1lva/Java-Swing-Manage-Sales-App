package pt.ipleiria.model;

public class Client {
    /*TODO: IMPLENTAR RELAÇÕES DE CLIENTE */
    private String name;
    private int nif;
    private int phoneNumber;

    public Client(String name, int nif, int phoneNumber) {
        this.name = name;
        this.nif = nif;
        this.phoneNumber = phoneNumber;
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
}
